package generator

import utils.FileUtil.writeListOfTuplesToFile
import utils.SparqlUtil.getInstanceConceptTupleSetFromDbpedia

object SparqlConceptsGenerator {

  def updateSystemConcepts(): Unit = {
    val programmingLanguagesSet = getInstanceConceptTupleSetFromDbpedia("Programming Language", programmingLanguagesQuery, programmingLanguage => programmingLanguage.contains("_(programming_language)"))
      .filter(tuple => tuple._1.length > 1) // avoid cases like letters
    val programmingLanguagesList = programmingLanguagesSet.map(_._1)
    val toolsAndFrameworksSet = getInstanceConceptTupleSetFromDbpedia("Tool/Framework", toolsAndFrameworksQuery, _ => true)
      .filterNot(tuple => {
        programmingLanguagesList.contains(tuple._1) || tuple._1.length == 1 || tuple._1 == "debug" // avoid cases like letters
      }) // filter programming languages that were mistakenly considered tools by Dbpedia
    val certificationsSet = getInstanceConceptTupleSetFromDbpedia("Certifications", certificationsQuery, !_.contains("list"))

    val conceptsSet = getInstanceConceptTupleSetFromDbpedia("Programming Concept", conceptsQuery, _ => true)
      .flatMap(tuple => {
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
      })
      .groupBy(_._1)
      .values
      .map(_.head)
      .toList

    val fileName = "data/conceptsDbpedia.csv"

    writeListOfTuplesToFile(fileName, programmingLanguagesSet, append = false)
    writeListOfTuplesToFile(fileName, toolsAndFrameworksSet)
    writeListOfTuplesToFile(fileName, certificationsSet)
    writeListOfTuplesToFile(fileName, conceptsSet)
  }

}
