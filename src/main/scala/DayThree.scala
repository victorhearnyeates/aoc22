object DayThree {
  def commonElem(str: String): String = {
    val (s1, s2) = str.splitAt(str.length() / 2)
    s1.intersect(s2)
  }

  def priority(str: String): Int = if (str.toUpperCase == str) {
    str.head.toByte.toInt - 38
  } else {
    str.head.toByte.toInt - 96
  }

  def calcPrioritySum(xs: List[String]) = xs.map(commonElem).map(priority).sum

  def calcPrioritySum2(xs: List[String]) = findBadges(xs).map(priority).sum

  def findBadges(xs: List[String]): List[String] = xs.grouped(3).toList.map(xss => xss.reduce((x,y) => x.intersect(y)))
}
