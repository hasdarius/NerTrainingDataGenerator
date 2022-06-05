package generator

import org.apache.spark.sql.DataFrame
import utils.FileUtil.writeListOfTuplesToFile
import utils.GraphUtil._
import utils.SparkUtil.getListOfDifferentValuesFromColumn
import utils.SparqlUtil
import utils.SparqlUtil.preProcessConceptResult


object KnowledgeGraphComponentsGenerator {

  def getRelationshipSetFromDbpedia(query: String,
                                    sourceInstancesList: List[String],
                                    destinationInstancesList: List[String],
                                    flatMapFunction: ((String, String)) => List[(String, String)] = tuple => List(tuple)): Set[(String, String)] = {
    SparqlUtil
      .getRelationshipTupleFromDbpedia(query)
      .flatMap(flatMapFunction)
      .filter(tuple =>
        sourceInstancesList.contains(tuple._1) && destinationInstancesList.contains(tuple._2))
  }


  def generateKnowledgeGraph(conceptsDataFrame: DataFrame): Unit = {

    val programmingLanguagesList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == programmingLanguageLabel)
    val toolsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == toolFrameworkLabel)
    val conceptsList = getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == programmingConceptLabel)

    val toolProgrammingLanguageRelationshipSet = getRelationshipSetFromDbpedia(
      toolsAndFrameworksQuery,
      toolsList,
      programmingLanguagesList)

    val conceptProgrammingLanguageRelationshipSet = getRelationshipSetFromDbpedia(
      conceptsQuery,
      conceptsList,
      programmingLanguagesList,
      preProcessConceptResult)
      .map {
        case (alreadyExistingInstance, label) if conceptsList.contains(alreadyExistingInstance + "-programming") => (alreadyExistingInstance + "-programming", label)
        case newConcept => newConcept
      } // dbpedia returns both "object oriented" and "object oriented programming" as concepts. the second one would suffice for us

    val edges = generateEdgeSet(conceptProgrammingLanguageRelationshipSet.map(_.swap), programmingLanguageProgrammingConceptRelationship) ++
      generateEdgeSet(toolProgrammingLanguageRelationshipSet, toolProgrammingLanguageRelationship) ++
      generateEdgeSet(programmingLanguagesList.map((_, programmingLanguageLabel)).toSet, instanceLabelRelationship) ++
      generateEdgeSet(toolsList.map((_, toolFrameworkLabel)).toSet, instanceLabelRelationship) ++
      generateEdgeSet(conceptsList.map((_, programmingConceptLabel)).toSet, instanceLabelRelationship)

    writeListOfTuplesToFile(edgesKnowledgeGraphFileName, edges.map(tuple => tuple._1 + "," + tuple._2 + "," + tuple._3).toList, append = false)
  }
}
