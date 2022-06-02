package utils

import org.apache.spark.sql.{DataFrame, Row}

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

}
