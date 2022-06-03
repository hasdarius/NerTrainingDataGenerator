package generator

import org.apache.spark.sql.DataFrame
import utils.FileUtil.writeListOfTuplesToFile

import scala.util.Random

object TrainingSentencesGenerator {
  def generateTrainingSentences(concepts: DataFrame, numberOfSentences: Int = 100): Unit = {
    val conceptList = concepts
      .select(instanceColumn)
      .distinct()
      .collect()
      .toList
      .map(_.mkString)

    var trainingSentences: List[(String, String)] = List.empty
    (1 to numberOfSentences).foreach(_ => {
      val randomSentence = "Nice to have: " + Random.shuffle(conceptList).take(10).mkString(", ")
      trainingSentences = ("train", s"\"${randomSentence}.\"") :: trainingSentences
    })

    writeListOfTuplesToFile("data/sentencesDbpedia.csv", trainingSentences.map(tuple => tuple._1 + "," + tuple._2), append = false)


  }

}
