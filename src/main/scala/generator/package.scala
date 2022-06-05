package object generator {

  val instanceColumn = "Instance"
  val conceptColumn = "Concept"
  val sentenceColumn = "Sentence"
  val typeColumn = "Type"

  val conceptsDbpediaFileName = "data/conceptsDbpedia.csv"
  val edgesKnowledgeGraphFileName = "edges.csv"

  val programmingLanguageLabel = "Programming Language"
  val programmingConceptLabel = "Programming Concept"
  val toolFrameworkLabel = "Tool/Framework"

  val toolProgrammingLanguageRelationship = "uses"
  val programmingLanguageProgrammingConceptRelationship = "isInfluencedBy"
  val instanceLabelRelationship = "isA"

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

  val conceptsQuery: String =
    """SELECT ?pl ?p2 ?label
      |    WHERE {
      |        ?p2 rdfs:label ?label .
      |        ?p2 rdf:type dbo:ProgrammingLanguage .
      |        ?p2 dbp:paradigm ?pl .
      |        FILTER (LANG(?label)='en')
      |    }
      |""".stripMargin

}
