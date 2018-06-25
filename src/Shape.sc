sealed trait Shape
{
    def sides: Int
    def perimeter: Double
    def area: Double
    def color: Color
}
sealed trait Color
{
    def red: Double
    def green: Double
    def blue: Double
    def light = red > 200 && green > 200 && blue > 200
    def dark = !light
}
case class CustomColor(red: Double, green: Double, blue: Double) extends Color
final case object Red extends Color
{
    val red = 1.0
    val green = 0
    val blue = 0
}
final case object Yellow extends Color
{
    val red = 1.0
    val green = 1.0
    val blue = 0
}
final case object Pink extends Color
{
    val red = 1.0
    val green = 0
    val blue = 0.5
}
sealed trait Rectangular extends Shape
{
    def width: Double
    def height: Double
    val sides = 1
    val perimeter = 2 * (width + height)
    val area = width * height
}

case class Circle(radius: Double, color: Color) extends Shape
{
    val sides = 1
    val perimeter = 2 * Math.PI * radius
    val area = math.Pi * radius * radius
}
case class Square(size: Double, color: Color) extends Rectangular
{
    val width = size
    val height = size
}
case class Rectangle(width: Double, height: Double, color: Color) extends Rectangular

object Draw
{
    def apply(s: Shape): String =
        s match
        {
            case Circle(radius, c) => s"A ${Draw(c)} circle with radius $radius"
            case Rectangle(w, h, c) => s"A ${Draw(c)} rectangle with width $w and height $h"
            case Square(s, c) => s"A ${Draw(c)} square with side size $s"
        }
    def apply(c: Color): String =
        c match
        {
            case Red => "red"
            case Yellow => "yellow"
            case Pink => "pink"
            case c => if (c.light) "light" else "dark"
        }
}

Draw(Square(5, Red))
Draw(Circle(5, CustomColor(1.0, 0.5, 0.5)))
