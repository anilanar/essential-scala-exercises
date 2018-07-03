package essential.sum

sealed trait Sum[+A, +B] {
  def map[C](fn: B => C): Sum[A, C] = this match {
    case Success(v) => Success(fn(v))
    case Failure(v) => Failure(v)
  }
  def fold[C](error: A => C, success: B => C): C = this match {
    case Success(v) => success(v)
    case Failure(v) => error(v)
  }
  def flatMap[AS >: A, C](f: B => Sum[AS, C]): Sum[AS, C] = this match {
    case Success(v) => f(v)
    case Failure(v) => Failure(v)
  }
}
final case class Success[B](value: B) extends Sum[Nothing, B]
final case class Failure[A](value: A) extends Sum[A, Nothing]
