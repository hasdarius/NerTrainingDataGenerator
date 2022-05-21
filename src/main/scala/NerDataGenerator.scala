import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.log4j.Logger
import org.apache.log4j.Level

import java.io.{File, PrintWriter}


object NerDataGenerator extends App {
  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("DataGenerator")
    .getOrCreate()

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)

  val conceptsDataFrame = spark
    .read
    .option("header", "true")
    .csv("data/concepts.csv")

  val sentencesDataFrame: DataFrame = spark
    .read
    .option("header", "true")
    .csv("data/sentences.csv")

  val conceptList = getListOfDifferentValuesFromColumn(conceptsDataFrame,"Concept", _ => true)
  val sentenceTypeList = getListOfDifferentValuesFromColumn(sentencesDataFrame,"Type", _ => true)

  var conceptsMap = (for (concept <- conceptList) yield
    (concept, getListOfDifferentValuesFromColumn(conceptsDataFrame,"Instance", _(1) == concept))).toMap


  sentenceTypeList.foreach(sentenceType => {
    val sentences = getListOfDifferentValuesFromColumn(sentencesDataFrame,"Sentence",_(0)==sentenceType)
      .map(_.replace(",", " ,")
        .replace(".", " .")
        .replace("(", "( ")
        .replace(")", " )"))
      .flatMap(_.split(" "))
    generateCsvFile(sentences, sentenceType)
  })

  def generateTuple(word: String): (String, String) = {
    val categoryList = conceptsMap.keySet.filter(conceptsMap(_).contains(word.toLowerCase)).toList
    var category = "O"
    if(categoryList.nonEmpty)
      category = categoryList.head
    if (word != ",")
      (word.replace("-", " "), category)
    else
      ("\",\"", category)

  }

  def generateCsvFile(sentences: List[String], fileName: String): Unit = {
    val csvFile = new PrintWriter(new File(fileName+".csv"))
    sentences
      .map(_.trim)
      .map(generateTuple)
      .foreach(tuple => csvFile.write(s"${tuple._1},${tuple._2}\n"))
    csvFile.close()

  }

  def getListOfDifferentValuesFromColumn(dataFrame: DataFrame, columnName: String, filterFunction: Row => Boolean): List[String] ={
    dataFrame
      .filter(filterFunction)
      .select(columnName)
      .distinct()
      .collect()
      .toList
      .map(_.mkString)
  }

}
