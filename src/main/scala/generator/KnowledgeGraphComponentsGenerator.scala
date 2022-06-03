package generator

import org.apache.spark.sql.DataFrame
import utils.FileUtil.writeListOfTuplesToFile
import utils.GraphUtil._
import utils.SparkUtil.getListOfDifferentValuesFromColumn
import utils.SparqlUtil.{getRelationshipSetFromDbpedia, preProcessConceptResult}


object KnowledgeGraphComponentsGenerator {

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

    val programmingLanguages = (conceptProgrammingLanguageRelationshipSet ++ toolProgrammingLanguageRelationshipSet)
      .map(tuple => (tuple._2, "Programming Language"))
      .groupBy(_._1)
      .values
      .map(_.head)
      .toList
    val concepts = conceptProgrammingLanguageRelationshipSet.map(tuple => (tuple._1, "Programming Concept"))
    val tools = toolProgrammingLanguageRelationshipSet.map(tuple => (tuple._1, "Tool/Framework"))

    val vertices = (programmingLanguages ++ concepts ++ tools)
      .zipWithIndex
      .map {
        case ((instance, label), id) => (id.toString, instance, label)
      }
    val edges = generateEdgeSet(toolProgrammingLanguageRelationshipSet, vertices, "uses", "used by") ++
      generateEdgeSet(conceptProgrammingLanguageRelationshipSet, vertices, "influences", "influenced by")

    writeListOfTuplesToFile("vertices.csv", vertices.map(tuple => tuple._1 + "," + tuple._2 + "," + tuple._3), append = false)
    writeListOfTuplesToFile("edges.csv", edges.map(tuple => tuple._1 + "," + tuple._2 + "," + tuple._3), append = false)
  }
}
