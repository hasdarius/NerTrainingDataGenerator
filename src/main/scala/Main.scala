import generator.KnowledgeGraphComponentsGenerator.generateKnowledgeGraph
import generator.NerTrainingDataGenerator.generateTaggedDataForTrainingNer
import generator.KnowledgeBaseGenerator.updateKnowledgeBase
import generator.TrainingSentencesGenerator.generateTrainingSentences
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import utils.SparkUtil


object Main extends App {

  updateKnowledgeBase()

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("Main")
    .getOrCreate()

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  Logger.getLogger("log4j").setLevel(Level.OFF)

  val conceptsDataFrame = SparkUtil.readKnowledgeBase(spark)
  val sentencesDataFrame = SparkUtil.readSentences(spark)

  generateTaggedDataForTrainingNer(conceptsDataFrame, sentencesDataFrame)
  generateKnowledgeGraph(conceptsDataFrame)

}
