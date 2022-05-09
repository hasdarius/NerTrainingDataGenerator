import org.apache.spark.sql.{DataFrame, SparkSession}

object NerDataGenerator extends App{
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val concepts = spark
    .read
    .option("header","true")
    .csv("data/concepts.csv")

  val sentences: DataFrame = spark
    .read
    .option("header","true")
    .csv("data/sentences.csv")

  concepts.show()
  sentences.show()
}
