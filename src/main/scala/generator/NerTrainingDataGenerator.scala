package generator

import org.apache.spark.sql.DataFrame
import utils.FileUtil.writeListOfTuplesToFile
import utils.SparkUtil.getListOfDifferentValuesFromColumn

object NerTrainingDataGenerator {

  def generateTaggedDataForTrainingNer(conceptsDataFrame: DataFrame, sentencesDataFrame: DataFrame): Unit = {

    val conceptList = getListOfDifferentValuesFromColumn(conceptsDataFrame, conceptColumn, _ => true)
    val sentenceTypeList = getListOfDifferentValuesFromColumn(sentencesDataFrame, typeColumn, _ => true)

    val conceptsMap = (for (concept <- conceptList) yield
      (concept, getListOfDifferentValuesFromColumn(conceptsDataFrame, instanceColumn, _ (1) == concept))).toMap


    sentenceTypeList.foreach(sentenceType => {
      val sentences = getListOfDifferentValuesFromColumn(sentencesDataFrame, sentenceColumn, _ (0) == sentenceType)
      writeListOfTuplesToFile(sentenceType + ".csv", sentences
        .map(string => string.replace(",", " ,")
          .replace(".", " .")
          .replaceAll(" (\\.[a-zA-Z])", "$1")
          .replace("(", "( ")
          .replace(")", " )"))
        .flatMap(_.split(" "))
        .map(_.trim)
        .map(generateTuple)
        .map(tuple => tuple._1 + "," + tuple._2), append = false)
    })

    def generateTuple(word: String): (String, String) = {
      val categoryList = conceptsMap.keySet.filter(conceptsMap(_).contains(word.toLowerCase)).toList
      var category = "O"
      if (categoryList.nonEmpty)
        category = categoryList.head
      if (word != ",")
        (word.replace("-", " "), category)
      else
        ("\",\"", category)

    }
  }

}
