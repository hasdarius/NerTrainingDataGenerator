name := "NerTrainingDataGenerator"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.0" % "provided"