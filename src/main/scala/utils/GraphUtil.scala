package utils

object GraphUtil {

  def generateEdgeSet(relationshipSet: Set[(String, String)],
                      relationship: String): Set[(String, String, String)] = {
    relationshipSet.map { case (from, to) => (from.replace("-"," "), relationship, to.replace("-"," ")) }
  }


}
