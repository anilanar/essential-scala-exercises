package essential.calculation

sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object Calculation
{
    def +(c: Calculation, a: Int) = c match {
        case Success(b) => Success(a + b)
        case f => f
    }
    def -(c: Calculation, a: Int) = this.+(c, -a)
    def /(c: Calculation, a: Int) = c match {
        case Success(b) => if (a != 0) Success(b / a)
            else Failure("Division by zero")
        case f => f
    }
}
