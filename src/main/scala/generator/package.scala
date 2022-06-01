package object generator {
  val toolsAndFrameworksQuery: String =
    """SELECT ?pl ?p2 ?label
      |    WHERE {
      |        ?pl rdfs:label ?label .
      |        ?pl rdf:type dbo:Software .
      |        ?pl dbo:programmingLanguage ?p2 .
      |        FILTER (LANG(?label)='en')
      |    } """.stripMargin

  val programmingLanguagesQuery: String =
    """SELECT ?pl ?label
      |    WHERE {
      |        ?pl rdfs:label ?label .
      |        ?pl rdf:type dbo:ProgrammingLanguage .
      |        FILTER (LANG(?label)='en')
      |    } """.stripMargin

  val certificationsQuery: String =
    """SELECT ?pl ?label
      |    WHERE {
      |        ?pl rdfs:label ?label .
      |        {?pl rdf:type  yago:WikicatInformationTechnologyQualifications .}
      |        UNION
      |       {?pl dct:subject	dbc:Information_technology_qualifications .}
      |        FILTER (LANG(?label)='en')}""".stripMargin

}
