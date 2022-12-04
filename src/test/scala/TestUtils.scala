import scala.io.Source
object TestUtils {
  lazy val dayone: String = Source.fromResource("dayone.txt").getLines().toList.mkString("\n")
  lazy val daytwo: List[String] = Source.fromResource("daytwo.txt").getLines().toList
  lazy val daythree: List[String] = Source.fromResource("daythree.txt").getLines().toList
  lazy val dayfour: List[String] = Source.fromResource("dayfour.txt").getLines().toList
}
