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

    val edges = generateEdgeSet(conceptProgrammingLanguageRelationshipSet, "influences") ++
      generateEdgeSet(toolProgrammingLanguageRelationshipSet, "uses") ++
      generateEdgeSet(programmingLanguagesList.map((_, "Programming Language")).toSet, "isA") ++
      generateEdgeSet(toolsList.map((_, "Tool/Framework")).toSet, "isA") ++
      generateEdgeSet(conceptsList.map((_, "Programming Concept")).toSet, "isA")

    writeListOfTuplesToFile("edges.csv", edges.map(tuple => tuple._1 + "," + tuple._2 + "," + tuple._3).toList, append = false)
  }
}
