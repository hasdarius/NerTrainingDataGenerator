package generator

import utils.FileUtil.writeListOfTuplesToFile
import utils.SparqlUtil
import utils.SparqlUtil.{getInstanceConceptTupleSetFromDbpedia, preProcessConceptResult}

object KnowledgeBaseGenerator {

  def updateKnowledgeBase(): Unit = {
    val programmingLanguagesList = getInstanceConceptTupleSetFromDbpedia(
      programmingLanguageLabel,
      programmingLanguagesQuery,
      stringFilter = programmingLanguage => programmingLanguage.contains("_(programming_language)"))
    // avoid cases like letters to avoid overfitting NER model

    val toolsAndFrameworksList = getInstanceConceptTupleSetFromDbpedia(
      toolFrameworkLabel,
      toolsAndFrameworksQuery,
      stringFilter = _ => true).filter{
      case (toolFramework,_) => !programmingLanguagesList.map(_._1).contains(toolFramework) && toolFramework.length > 1 && toolFramework != "debug"
    } // avoid programming languages that were mistakenly considered tools by Dbpedia or words like debug which are clearly not tools/frameworks

    val certificationsList = getInstanceConceptTupleSetFromDbpedia(
      "Certifications",
      certificationsQuery,
      stringFilter = certification => !certification.contains("list"))
    // avoid getting list of certifications as single certifications

    val conceptsList = getInstanceConceptTupleSetFromDbpedia(programmingConceptLabel,
      conceptsQuery,
      stringFilter = _ => true)
      .flatMap(preProcessConceptResult) // concepts in dbpedia are often times a list of concepts. need to take each individual concept from that list
      .distinctBy(_._1)
      .filterNot(tuple => tuple._1.toLowerCase == "javascript") // Dbpedia considers javascript also as a programming concept

    val dbpediaConcepts = (programmingLanguagesList ++ toolsAndFrameworksList ++ certificationsList ++ conceptsList)
      .map(tuple => tuple._1 + "," + tuple._2)

    writeListOfTuplesToFile(knowledgeBaseFileName, dbpediaConcepts, append = false)
  }
}
