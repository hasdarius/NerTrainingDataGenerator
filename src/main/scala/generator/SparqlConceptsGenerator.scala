package generator

import utils.FileUtil.writeListOfTuplesToFile
import utils.SparqlUtil.{getInstanceConceptTupleSetFromDbpedia, preProcessConceptResult}

object SparqlConceptsGenerator {

  def updateSystemConcepts(): Unit = {
    val programmingLanguagesList = getInstanceConceptTupleSetFromDbpedia("Programming Language", programmingLanguagesQuery, programmingLanguage => programmingLanguage.contains("_(programming_language)"))
      .filter(tuple => tuple._1.length > 1) // avoid cases like letters to avoid overfitting NER model
    val programmingLanguages = programmingLanguagesList.map(_._1)
    val toolsAndFrameworksList = getInstanceConceptTupleSetFromDbpedia("Tool/Framework", toolsAndFrameworksQuery, _ => true)
      .filterNot(tuple => {
        programmingLanguages.contains(tuple._1) || tuple._1.length == 1 || tuple._1 == "debug"
      }) // filter programming languages that were mistakenly considered tools by Dbpedia or words like debug which are clearly not tools/frameworks
    val certificationsList = getInstanceConceptTupleSetFromDbpedia("Certifications", certificationsQuery, !_.contains("list"))

    val conceptsList = getInstanceConceptTupleSetFromDbpedia("Programming Concept", conceptsQuery, _ => true)
      .flatMap(tuple => {
        preProcessConceptResult(tuple._1)
          .map((_, tuple._2))
      })
      .groupBy(_._1)
      .values
      .map(_.head)
      .toList
      .filterNot(tuple => tuple._1.toLowerCase == "javascript") // Dbpedia considers javascript also as a programming concept

    val fileName = "data/conceptsDbpedia.csv"

    writeListOfTuplesToFile(fileName, programmingLanguagesList.map(tuple => tuple._1 + "," + tuple._2), append = false)
    writeListOfTuplesToFile(fileName, toolsAndFrameworksList.map(tuple => tuple._1 + "," + tuple._2))
    writeListOfTuplesToFile(fileName, certificationsList.map(tuple => tuple._1 + "," + tuple._2))
    writeListOfTuplesToFile(fileName, conceptsList.map(tuple => tuple._1 + "," + tuple._2))
  }

}
