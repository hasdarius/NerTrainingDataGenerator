package utils

import java.io.{FileOutputStream, PrintWriter}

object FileUtil {
  def writeListOfTuplesToFile(fileName: String, tuples: List[String], append: Boolean = true): Unit = {
    val csvFile = new PrintWriter(new FileOutputStream(fileName, append))
    tuples.foreach(tuple => csvFile.write(s"$tuple\n"))
    csvFile.close()
  }

}
