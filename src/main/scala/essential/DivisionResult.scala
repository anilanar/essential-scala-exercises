package essential

sealed trait DivisionResult
final case class Finite(value: Int) extends DivisionResult
final case object Infinite extends DivisionResult

object divide {
    def apply(a: Int, b: Int): DivisionResult =
        if (b == 0) Infinite
        else Finite(a / b)
}
