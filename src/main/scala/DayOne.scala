import scala.util.Try

object DayOne {
  def parseAndCollectInput(input: String): List[Int] = {
    input.split("\n").toList.map{ _.trim().toIntOption }.foldLeft(List(0)) {
        (acc, elem) => elem.map(i => acc.head + i :: acc.drop(1)).getOrElse(0 :: acc)
    }.reverse
  }
}
