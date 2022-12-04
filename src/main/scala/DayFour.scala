import scala.compiletime.ops.string
object DayFour {
  
    def input2Range(string: String) = {
        val split = string.split("-").map(_.toInt)
        split(0) to split(1)
    }

    def isFullyContained(r1: Range, r2: Range): Boolean = {
        val s1 = r1.toSet
        val s2 = r2.toSet

        (s1 ++ s2).size == s1.size || (s1 ++ s2).size == s2.size
    }

    def isPartiallyContained(r1: Range, r2: Range): Boolean = {
        val s1 = r1.toSet
        val s2 = r2.toSet

        (s1 ++ s2).size != s1.size + s2.size
    }
}
