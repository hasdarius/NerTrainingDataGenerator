package generator

import org.apache.spark.graphx.{Edge, Graph, VertexId}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import utils.SparkUtil.getListOfDifferentValuesFromColumn
import utils.SparqlUtil


object KnowledgeGraphGenerator {

  def generateKnowledgeGraph(spark: SparkSession, conceptsDataFrame: DataFrame): Unit = {

    val programmingLanguagesList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Programming Language")
    val toolsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Tool/Framework")
    val conceptsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Programming Concept")

    def getRelationshipSet(query: String,
                           listForFirstTupleElement: List[String],
                           listForSecondTupleElement: List[String],
                           flatMapFunction: ((String, String)) => List[(String, String)] = tuple => List(tuple)): Set[(String, String)] = {
      SparqlUtil
        .getRelationshipTupleFromDbpedia(query)
        .flatMap(flatMapFunction)
        .filter(tuple =>
          listForFirstTupleElement.contains(tuple._1) && listForSecondTupleElement.contains(tuple._2))
    }

    val toolProgrammingLanguageSet = getRelationshipSet(toolsAndFrameworksQuery, toolsList, programmingLanguagesList)
    val conceptProgrammingLanguageSet = getRelationshipSet(conceptsQuery,
      conceptsList,
      programmingLanguagesList,
      tuple => {
        tuple._1
          .replace("multi-paradigm: ", "")
          .replace(".", "")
          .replace("@en", "")
          .replace(":", ",")
          .replace("and", ",")
          .split(",")
          .map(string => string.trim.replace(" ", "-"))
          .filter(_.nonEmpty)
          .map((_, tuple._2))
          .toList
      })

    val programmingLanguages = (conceptProgrammingLanguageSet ++ toolProgrammingLanguageSet)
      .map(tuple => (tuple._2, "Programming Language"))
      .groupBy(_._1)
      .values
      .map(_.head)
      .toList
    val concepts = conceptProgrammingLanguageSet.map(tuple => (tuple._1, "Programming Concept"))
    val tools = toolProgrammingLanguageSet.map(tuple => (tuple._1, "Tool/Framework"))

    val vertices: RDD[(VertexId, (String, String))] =
      spark.sparkContext.parallelize(programmingLanguages ++ concepts ++ tools)
        .zipWithIndex
        .map(tuple => (tuple._2.toLong, tuple._1))

    def transformTupleSetIntoEdgeSet(set: Set[(String, String)], relationship: String) = {
      def getVertexId(string: String): VertexId = {
        vertices.filter(vertex => vertex._2._1 == string).first()._1
      }

      set
        .map(tuple => Edge(getVertexId(tuple._1), getVertexId(tuple._2), relationship))
        .toList
    }

    val edges: RDD[Edge[String]] =
      spark.sparkContext.parallelize(
        transformTupleSetIntoEdgeSet(toolProgrammingLanguageSet, "uses") ++ transformTupleSetIntoEdgeSet(conceptProgrammingLanguageSet, "influences")
      )

    val graph = Graph(vertices, edges)

    def toGexf[VD,ED](g:Graph[VD,ED]) : String = {
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<gexf xmlns=\"http://www.gexf.net/1.2draft\" version=\"1.2\">\n" +
        "  <graph mode=\"static\" defaultedgetype=\"directed\">\n" +
        "    <nodes>\n" +
        g.vertices.map(v => "      <node id=\"" + v._1 + "\" label=\"" +
          v._2 + "\" />\n").collect.mkString +
        "    </nodes>\n" +
        "    <edges>\n" +
        g.edges.map(e => "      <edge source=\"" + e.srcId +
          "\" target=\"" + e.dstId + "\" label=\"" + e.attr +
          "\" />\n").collect.mkString +
        "    </edges>\n" +
        "  </graph>\n" +
        "</gexf>"
    }

    println(toGexf(graph))

  }
}
