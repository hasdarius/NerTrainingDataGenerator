package utils

import java.io.{FileOutputStream, PrintWriter}

object FileUtil {

  def writeListOfTuplesToFile(fileName: String, tupleSet: List[(String, String)], append: Boolean = true): Unit = {
    val csvFile = new PrintWriter(new FileOutputStream(fileName, append))
    tupleSet.foreach(tuple => csvFile.write(s"${tuple._1},${tuple._2}\n"));
    csvFile.close();
  }

}
