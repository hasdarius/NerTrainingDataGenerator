package modelData

import java.io.{File, PrintWriter}

object TrainingDataCreator extends App {

  def generateTuple(word: String): (String, String) = {
    val category = word.toLowerCase match {
      case programmingLanguage if (programmingLanguageList.contains(programmingLanguage)) => "Programming Language"
      case certification if (certificationList.contains(certification)) => "Certification"
      case seniority if (seniorityList.contains(seniority)) => "Seniority"
      case toolsFrameworks if (toolsFrameworksList.contains(toolsFrameworks)) => "Tool/Framework"
      case role if (roleList.contains(role)) => "IT Specialization"
      case concept if (conceptList.contains(concept)) => "Programming Concept"
      case _ => "O"
    }
    if (word != ",")
      (word.replace("-", " "), category)
    else
      ("\",\"", category)

  }

  def splitSentencesInArrayOfWords(sentences: String): Array[String] = sentences
    .replace(",", " ,")
    .replace(".", " .")
    .replace("(", "( ")
    .replace(")", " )")
    .replace("\n", " ")
    .split(" ")


  def generateCsvFile(sentences: String, fileName: String): Unit = {
    val preProcessedSentences = splitSentencesInArrayOfWords(sentences)
    val csvFile = new PrintWriter(new File(fileName))
    preProcessedSentences
      .map(_.trim)
      .map(generateTuple)
      .foreach(tuple => csvFile.write(s"${tuple._1},${tuple._2}\n"))
    csvFile.close()

  }

  generateCsvFile(trainSentences,"train.csv")
  generateCsvFile(validationSentences,"validate.csv")
  generateCsvFile(trainSentences,"test.csv")

}