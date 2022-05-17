package sparql

object ConceptUpdater extends App {

  def getInstanceConceptTupleSet(label: String, query: String, stringFilter: String => Boolean): Set[(String, String)] = {

    val results = SparqlUtil.querySparql(query)
    var resultSet: Set[String] = Set.empty

    while (results.hasNext) {
      resultSet += results.next.get("pl").toString
    }
    resultSet
      .map(result => result.substring(result.lastIndexOf("/") + 1))
      .filter(stringFilter)
      .map(result => result
        .toLowerCase
        .replace("_", "-") // this is how we link composite words in our training data
        .replaceAll("-\\([^()]*\\)", "")) // remove paranthesis from names such as: apache-spark-(framework) -> apache-spark
      .map(result => (result, label))
  }

  val toolsAndFrameworksSet = getInstanceConceptTupleSet("Tool/Framework", toolsAndFrameworksQuery, _ => true)
  val programmingLanguagesSet = getInstanceConceptTupleSet("Programming Language", programmingLanguagesQuery, programmingLanguage => programmingLanguage.contains("_(programming_language)"))
  val certificationsSet = getInstanceConceptTupleSet("Certifications", certificationsQuery, _ => true)
  toolsAndFrameworksSet.foreach(println)
  programmingLanguagesSet.foreach(println)
  certificationsSet.foreach(println)

}
