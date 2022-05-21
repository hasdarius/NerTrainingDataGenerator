import generator.NerDataGenerator.generateTaggedDataForTrainingNer
import generator.SparqlConceptsGenerator.updateSystemConcepts
import generator.TrainingSentencesGenerator.generateTrainingSentences
import org.apache.spark.sql.SparkSession


object Main extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("Main")
    .getOrCreate()

  updateSystemConcepts()
  generateTrainingSentences(spark)
  generateTaggedDataForTrainingNer(spark)

}
