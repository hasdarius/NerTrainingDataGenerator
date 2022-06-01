package generator

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import utils.FileUtil

object NerDataGenerator {

  def generateTaggedDataForTrainingNer(spark: SparkSession): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val conceptsDataFrame = spark
      .read
      .option("header", "true")
      .csv("data/concepts.csv")
      .union(spark
        .read
        .option("header", "false")
        .csv("data/conceptsDbpedia.csv"))

    val sentencesDataFrame: DataFrame = spark
      .read
      .option("header", "true")
      .csv("data/sentences.csv")
    /*.union(spark
      .read
      .option("header", "false")
      .csv("data/sentencesDbpedia.csv"))*/

    def getListOfDifferentValuesFromColumn(dataFrame: DataFrame, columnName: String, filterFunction: Row => Boolean): List[String] = {
      dataFrame
        .filter(filterFunction)
        .select(columnName)
        .distinct()
        .collect()
        .toList
        .map(_.mkString)
    }

    val conceptList = getListOfDifferentValuesFromColumn(conceptsDataFrame, "Concept", _ => true)
    val sentenceTypeList = getListOfDifferentValuesFromColumn(sentencesDataFrame, "Type", _ => true)

    val conceptsMap = (for (concept <- conceptList) yield
      (concept, getListOfDifferentValuesFromColumn(conceptsDataFrame, "Instance", _ (1) == concept))).toMap


    sentenceTypeList.foreach(sentenceType => {
      val sentences = getListOfDifferentValuesFromColumn(sentencesDataFrame, "Sentence", _ (0) == sentenceType)
      FileUtil.writeListOfTuplesToFile(sentenceType + ".csv", sentences
        .map(string => string.replace(",", " ,")
          .replace(".", " .")
          .replaceAll(" (\\.[a-zA-Z])", "$1")
          .replace("(", "( ")
          .replace(")", " )"))
        .flatMap(_.split(" "))
        .map(_.trim)
        .map(generateTuple), append = false)
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
