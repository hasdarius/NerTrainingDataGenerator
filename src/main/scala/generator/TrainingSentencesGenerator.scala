package generator

import org.apache.spark.sql.SparkSession
import utils.FileUtil

import scala.util.Random

object TrainingSentencesGenerator {
  def generateTrainingSentences(spark: SparkSession, numberOfSentences: Int = 100):Unit={
    val concepts = spark
      .read
      .option("header", "false")
      .csv("data/conceptsDbpedia.csv")

    val conceptList = concepts
      .select("_c0")
      .distinct()
      .collect()
      .toList
      .map(_.mkString)

    var trainingSentences: List[(String,String)] = List.empty
    (1 to numberOfSentences).foreach(_ =>{
      val randomSentence = "Nice to have: " + Random.shuffle(conceptList).take(10).mkString(", ")
      trainingSentences = ("train", s"\"${randomSentence}.\"") :: trainingSentences
    })

    FileUtil.writeListOfTuplesToFile("data/sentencesDbpedia.csv",trainingSentences, append = false)


  }

}
