package utils

object GraphUtil {

  def generateEdgeSet(relationshipSet: Set[(String, String)],
                      vertices: List[(String, String, String)],
                      relationship: String,
                      inverseRelationship: String): List[(String, String, String)] = {

    def getVertexId(string: String): String = {
      vertices.filter(vertex => vertex._2 == string).head._1
    }

    relationshipSet
      .flatMap(tuple =>
        List(
          (getVertexId(tuple._1), getVertexId(tuple._2), relationship),
          (getVertexId(tuple._2), getVertexId(tuple._1), inverseRelationship)))
      .toList
  }


}
