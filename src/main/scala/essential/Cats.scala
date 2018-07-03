package essential

trait Feline
{
    val color: String
    val sound: String
}
case class Cat(color: String, food: String) extends Feline
{
    val sound = "meow"
}
case class Lion(color: String, val maneSize: Int) extends Feline
{
    val sound = "roar"
}
case class Tiger(color: String) extends Feline
{
    val sound = "roar"
}
case class Panther(color: String) extends Feline
{
    val sound = "roar"
}

object ChipShop {
    def willServe(cat: Cat): Boolean =
        cat match {
            case Cat(_, "chips") => true
            case _ => false
        }
}
