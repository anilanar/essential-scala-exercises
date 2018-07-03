package essential

import scala.annotation.tailrec

sealed trait IntList
{
    @tailrec
    private def _length(acc: Int): Int = this match {
        case End => acc
        case Pair(_, xs) => xs._length(acc + 1)
    }
    def length: Int = _length(0)

    @tailrec
    private def _product(acc: Int): Int = this match {
        case End => acc
        case Pair(x, xs) => xs._product(acc * x)
    }
    def product = _product(1)

    @tailrec
    private def _double(acc: IntList): IntList = this match {
        case Pair(x, xs) => xs._double(Pair(2 * x, acc))
        case End => acc
    }
    def double = _double(End)._reverse(End)

    @tailrec
    private def _reverse(acc: IntList): IntList = this match {
        case Pair(x, xs) => xs._reverse(Pair(x, acc))
        case End => acc
    }

}
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
