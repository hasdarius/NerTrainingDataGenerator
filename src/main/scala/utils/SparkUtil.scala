package utils

import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SparkUtil {
  def getListOfDifferentValuesFromColumn(dataFrame: DataFrame, columnName: String, filterFunction: Row => Boolean): List[String] = {
    dataFrame
      .filter(filterFunction)
      .select(columnName)
      .distinct()
      .collect()
      .toList
      .map(_.mkString)
  }

  def readKnowledgeBase(spark: SparkSession): DataFrame = spark
    .read
    .option("header", "true")
    .csv("data/manualKnowledgeBase.csv")
    .union(spark
      .read
      .option("header", "false")
      .csv("data/knowledgeBase.csv"))

  def readSentences(spark: SparkSession): DataFrame = spark
    .read
    .option("header", "true")
    .csv("data/sentences.csv")

}
