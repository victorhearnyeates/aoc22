import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DayTwoSpec extends AnyFlatSpec with Matchers {

    val text = """A Y
                |B X
                |C Z""".stripMargin

    "parseRPS" should "parse each line into the pair of RPS values" in {
        val input = text.split("\n").toList
        val asData = input.map(DayTwo.parseRPS)
        assert(asData.head == List(Rock, Paper))
        assert(asData(1) == List(Paper, Rock))
        assert(asData(2) == List(Scissors, Scissors))
    }

    "score" should "compute the score of each pair" in {
        val input = text.split("\n").toList
        val asData: List[List[RPS]] = input.map(DayTwo.parseRPS)
        val score = DayTwo.score(asData)

        assert(score == List(8, 1, 6))
    }

    it should "compute the score for everything" in {
        val input = TestUtils.daytwo
        val asData: List[List[RPS]] = input.map(DayTwo.parseRPS)
        val scores = DayTwo.score(asData)

        assert(scores.head == 4)
        assert(scores.last == 3)
        assert(scores(5) == 1)
        assert(scores(9) == 4)

        assert(scores.sum == 8890)
    }

    "calcWinLose" should "calculate the type it needs to create from the input type and letter" in {
        RPS.calcWinLose("X")(Rock) shouldBe Scissors
        RPS.calcWinLose("Y")(Rock) shouldBe Rock
    }

    it should "be able to calculate the entire chain outcome" in {
        val input = TestUtils.daytwo.map(_.trim().split(" "))
        val pairs = input.map{arr => 
            List(
                DayTwo.parseRPS(arr(0)).head,
                RPS.calcWinLose(arr(1))(DayTwo.parseRPS(arr(0)).head)
            )
        }

        val scores = DayTwo.score(pairs)
        assert(scores.sum == 10238)
    }
}
