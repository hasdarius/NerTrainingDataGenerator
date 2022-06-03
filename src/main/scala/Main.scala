import generator.KnowledgeGraphComponentsGenerator.generateKnowledgeGraph
import generator.NerDataGenerator.generateTaggedDataForTrainingNer
import generator.SparqlConceptsGenerator.updateSystemConcepts
import generator.TrainingSentencesGenerator.generateTrainingSentences
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}


object Main extends App {

  updateSystemConcepts()

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("Main")
    .getOrCreate()

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


  //generateTrainingSentences(conceptsDataFrame)
  generateTaggedDataForTrainingNer(conceptsDataFrame, sentencesDataFrame)
  generateKnowledgeGraph(conceptsDataFrame)

}
