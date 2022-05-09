import org.apache.spark.sql.{DataFrame, SparkSession}

import java.io.{File, PrintWriter}


object NerDataGenerator extends App {
  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("DataGenerator")
    .getOrCreate()

  val conceptsDataFrame = spark
    .read
    .option("header", "true")
    .csv("data/concepts.csv")

  val sentencesDataFrame: DataFrame = spark
    .read
    .option("header", "true")
    .csv("data/sentences.csv")

  conceptsDataFrame.show()

  val conceptList = conceptsDataFrame
    .select("Concept")
    .distinct()
    .collect()
    .toList
    .map(_.mkString)

  var conceptsMap = (for (concept <- conceptList) yield
    (concept, conceptsDataFrame.filter(_ (1) == concept)
      .collect
      .toList
      .map(_.get(0).toString))).toMap

  val sentenceTypes = sentencesDataFrame
    .select("type")
    .distinct()
    .collect()
    .toList
    .map(_.mkString)

  sentenceTypes.foreach(sentenceType => {
    val sentences = sentencesDataFrame
      .filter(_(0)==sentenceType)
      .select("sentence")
      .collect()
      .toList
      .map(_.mkString)
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

}
