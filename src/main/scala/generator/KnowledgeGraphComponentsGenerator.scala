package generator

import org.apache.spark.sql.DataFrame
import utils.FileUtil.writeListOfTuplesToFile
import utils.GraphUtil._
import utils.SparkUtil.getListOfDifferentValuesFromColumn
import utils.SparqlUtil
import utils.SparqlUtil.preProcessConceptResult


object KnowledgeGraphComponentsGenerator {

  def getRelationshipSetFromDbpedia(query: String,
                                    listForFirstTupleElement: List[String],
                                    listForSecondTupleElement: List[String],
                                    flatMapFunction: ((String, String)) => List[(String, String)] = tuple => List(tuple)): Set[(String, String)] = {
    SparqlUtil
      .getRelationshipTupleFromDbpedia(query)
      .flatMap(flatMapFunction)
      .filter(tuple =>
        listForFirstTupleElement.contains(tuple._1) && listForSecondTupleElement.contains(tuple._2))
  }


  def generateKnowledgeGraph(conceptsDataFrame: DataFrame): Unit = {

    val programmingLanguagesList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Programming Language")
    val toolsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Tool/Framework")
    val conceptsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == "Programming Concept")

    val toolProgrammingLanguageRelationshipSet = getRelationshipSetFromDbpedia(toolsAndFrameworksQuery, toolsList, programmingLanguagesList)
    val conceptProgrammingLanguageRelationshipSet = getRelationshipSetFromDbpedia(conceptsQuery,
      conceptsList,
      programmingLanguagesList,
      tuple =>
        preProcessConceptResult(tuple._1)
          .map((_, tuple._2))
          .toList
    )

    val edges = generateEdgeSet(conceptProgrammingLanguageRelationshipSet.map(_.swap), "influences") ++
      generateEdgeSet(toolProgrammingLanguageRelationshipSet, "uses") ++
      generateEdgeSet(programmingLanguagesList.map((_, "Programming Language")).toSet, "isA") ++
      generateEdgeSet(toolsList.map((_, "Tool/Framework")).toSet, "isA") ++
      generateEdgeSet(conceptsList.map((_, "Programming Concept")).toSet, "isA")

    writeListOfTuplesToFile("edges.csv", edges.map(tuple => tuple._1 + "," + tuple._2 + "," + tuple._3).toList, append = false)
  }
}
