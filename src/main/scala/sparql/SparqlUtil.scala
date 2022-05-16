package sparql

import org.apache.jena.query.{ParameterizedSparqlString, QueryExecutionFactory, ResultSet}

object SparqlUtil {

  def querySparql(queryString: String): ResultSet = {

    val sparqlQuery = new ParameterizedSparqlString(""
      + "prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n"
      + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
      + "PREFIX dbo:     <http://dbpedia.org/ontology/>"
      + "\n"
      + queryString)


    val queryExecutionFactory = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", sparqlQuery.asQuery)

    queryExecutionFactory.execSelect
  }

}
