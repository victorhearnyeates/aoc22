sealed trait RPS { self =>
    def addon: Int
    def outcome(that: RPS): Outcome
    def points(outcome: Outcome, that: RPS): Int = outcome match {
        case Draw => 3 + that.addon
        case Lose => 0 + that.addon
        case Win => 6 + that.addon
    }
    def dual(that: RPS):Int = points(outcome(that), that)

    def wins: RPS // needs to win
    def loses: RPS // needs to lose
    def draw: RPS = self
}

object RPS {
    def apply(str: String) = str match
        case "A" | "X" => Rock
        case "B" | "Y" => Paper
        case "C" | "Z" => Scissors

    def calcWinLose(letter: String): RPS => RPS = letter match
    case "X" => (r: RPS) => r.wins
    case "Y" => (r: RPS) => r.draw
    case "Z" => (r: RPS) => r.loses
}

case object Rock extends RPS {
    val addon = 1
    def outcome(that: RPS): Outcome = that match
        case Paper => Win
        case Rock => Draw
        case Scissors => Lose

    def wins: RPS = Scissors
    def loses: RPS = Paper
}

case object Paper extends RPS {
    val addon = 2
    def outcome(that: RPS): Outcome = that match
        case Paper => Draw
        case Rock => Lose
        case Scissors => Win

    def wins: RPS = Rock
    def loses: RPS = Scissors
}

case object Scissors extends RPS {
    val addon = 3
    def outcome(that: RPS): Outcome = that match
        case Paper => Lose
        case Rock => Win
        case Scissors => Draw

    def wins: RPS = Paper
    def loses: RPS = Rock
}

sealed trait Outcome
case object Win extends Outcome
case object Draw extends Outcome
case object Lose extends Outcome

object DayTwo {

def parseRPS(str: String): List[RPS] = str.split(" ").map(_.trim()).map(RPS.apply).toList
def score(xss: List[List[RPS]]): List[Int] = xss.map(xs => xs(0).dual(xs(1)))
}