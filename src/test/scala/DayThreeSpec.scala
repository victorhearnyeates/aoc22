import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DayThreeSpec extends AnyFlatSpec with Matchers {

    val input = List(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"
    )
  
    "commonElem" should "take a string and split it in half, working out the commmon character for each half" in {
        val output = DayThree.commonElem("vJrwpWtwJgWrhcsFMMfFFhFp")

        output shouldBe "p"
    }

    "priority" should "give 27 for A and 1 for a" in {
        DayThree.priority("A") shouldBe 27
        DayThree.priority("a") shouldBe 1
    }

    "findBadges" should "take a list of Strings, and calculate the common item between groups of three" in {
        DayThree.findBadges(input) shouldBe List("r", "Z")
    }

    "calcPrioritySum" should "calculate the priority for part 1" in {
        DayThree.calcPrioritySum(TestUtils.daythree) shouldBe 7766
    }

    it should "calculate the priority for part 2" in {
        DayThree.calcPrioritySum2(TestUtils.daythree) shouldBe 2415
    }
}
