import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class DayFourSpec extends AnyFlatSpec with Matchers {
    
    val input = """2-4,6-8
                |2-3,4-5
                |5-7,7-9
                |2-8,3-7
                |6-6,4-6
                |2-6,4-8""".stripMargin

    "input2Range" should "take a string input seperated by a '-' and convert it to a range of ints" in {
        val input = "6-8"
        val expected = 6 to 8
        
        val output = DayFour.input2Range(input)
        output shouldBe expected
    }

    "isFullyContained" should "be true when a range fully contains another" in {
        val range1 = 3 until 10
        val range2 = 4 until 6

        val isFullyContained1 = DayFour.isFullyContained(range1, range2)
        val isFullyContained2 = DayFour.isFullyContained(range2, range1)

        assert(isFullyContained1)
        assert(isFullyContained2)
    }

    it should "be false otherwise" in {
        val range1 = 3 until 10
        val range2 = 2 until 6

        val isFullyContained1 = DayFour.isFullyContained(range1, range2)
        val isFullyContained2 = DayFour.isFullyContained(range2, range1)

        assert(!isFullyContained1)
        assert(!isFullyContained2)
    }

    "isPartiallyContained" should "return true if one range partially contains another" in {
        val range1 = 3 until 10
        val range2 = 2 until 6

        val isPartiallyContained1 = DayFour.isPartiallyContained(range1, range2)
        val isPartiallyContained2 = DayFour.isPartiallyContained(range2, range1)

        assert(isPartiallyContained1)
        assert(isPartiallyContained2)
    }

    lazy val listOfPairs = TestUtils.dayfour.map(_.trim().split(","))
    lazy val ranges = listOfPairs.map(xs => (DayFour.input2Range(xs(0)), DayFour.input2Range(xs(1))))

    "partOne" should "calculate the number of pairs wherre one is fully in another" in {
        val filtered = ranges.filter{
            (r1, r2) => DayFour.isFullyContained(r1, r2)
        }

        assert(filtered.size == 503)
    }

    "partTwo" should "calculate the number of pairs wherre one is fully in another" in {
        val filtered = ranges.filter{
            (r1, r2) => DayFour.isPartiallyContained(r1, r2)
        }

        assert(filtered.size == 827)
    }
}
