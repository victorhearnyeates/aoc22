import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source


class DayOneSpec extends AnyFlatSpec with Matchers {

    val testInput = """1000
                    |2000
                    |3000
                    |
                    |4000
                    |
                    |5000
                    |6000
                    |
                    |7000
                    |8000
                    |9000
                    |
                    |10000""".stripMargin

    "parseAndCollectInput" should "read the string text into a list of numbers summed, where a newline adds a new number" in {
        val parsed = DayOne.parseAndCollectInput{testInput}

        assert(parsed == List(6000, 4000, 11000, 24000, 10000))
    }

    "dayone" should "give the answer" in {
        val input = TestUtils.dayone
        val parsed = DayOne.parseAndCollectInput(input)

        assert(parsed.max == 68292)
    }

    it should "sum the top three" in {
        val input = TestUtils.dayone
        val sorted = DayOne.parseAndCollectInput(input).sorted.reverse
        
        assert(sorted.take(3).sum == 203203)
    }


}