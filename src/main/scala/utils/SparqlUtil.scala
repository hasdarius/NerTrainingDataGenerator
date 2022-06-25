package utils

import org.apache.jena.query.{ParameterizedSparqlString, QueryExecutionFactory, ResultSet}

object SparqlUtil {

  def queryDbpedia(queryString: String): ResultSet = {

    val sparqlQuery = new ParameterizedSparqlString(""
      + "prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n"
      + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
      + "prefix dbo:     <http://dbpedia.org/ontology/>\n"
      + "prefix yago:     <http://yago-knowledge.org/resource/>\n"
      + "prefix dbc:      <http://dbpedia.org/resource/Category:>\n"
      + "prefix dct: <http://purl.org/dc/terms/>\n"
      + "prefix dbp: <http://dbpedia.org/property/>\n"
      + queryString)


    val queryExecutionFactory = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", sparqlQuery.asQuery)

    queryExecutionFactory.execSelect
  }

  def getInstanceConceptTupleSetFromDbpedia(label: String, query: String, stringFilter: String => Boolean): List[(String, String)] = {

    val results = SparqlUtil.queryDbpedia(query)
    var resultSet: Set[String] = Set.empty

    while (results.hasNext) {
      resultSet += results.next.get("pl").toString
    }
    resultSet
      .toList
      .filter(stringFilter)
      .sortWith(_.compareTo(_) < 0)
      .map(result => preProcessResult(result))
      .map(result => (result, label))
  }

  def getRelationshipTupleSetFromDbpedia(query: String): Set[(String, String)] = {
    var relationshipSet: Set[(String, String)] = Set.empty
    val results = SparqlUtil.queryDbpedia(query)


    while (results.hasNext) {
      val result = results.next()
      relationshipSet += (preProcessResult(result.get("pl").toString) -> preProcessResult(result.get("p2").toString))
    }

    relationshipSet
      .toList
      .sortWith((tuple1, tuple2) => tuple1._1.compareTo(tuple2._1) < 0)
      .toSet
  }

  def preProcessResult(string: String): String =
    string
      .substring(string.lastIndexOf("/") + 1)
      .toLowerCase
      .replace("_", "-") // this is how we link composite words in our training data
      .replaceAll("-\\([^()]*\\)", "") // remove paranthesis from names such as: apache-spark-(framework) -> apache-spark

  def preProcessConceptResult(conceptTuple: (String, String)): List[(String, String)] = {
    val conceptInstance = conceptTuple._1
    val conceptLabel = conceptTuple._2

    conceptInstance
      .replace("multi-paradigm: ", "")
      .replaceAll("\\.|@en", "")
      .replaceAll(":|and", ",")
      .split(",")
      .map(string => string.trim.replace(" ", "-"))
      .filter(_.nonEmpty)
      .toList
      .map((_, conceptLabel))

  }
}
