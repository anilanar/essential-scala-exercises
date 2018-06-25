case class Person(
    val firstName: String,
    val lastName: String
)
{
    def fullName = s"$firstName $lastName"
}

object Person {
    def apply(name: String): Person =
    {
        val parts = name.split(" ")
        new Person(parts(0), parts(1))
    }
}

object Stormtrooper
{
    private def rebelScum = "Stop, rebel scum"
    private def moveAlong(name: String) = s"Move along, $name"
    def inspect(person: Person): String =
        person match {
            case Person("Luke", "Skywalker") => rebelScum
            case Person("Han", "Solo") => rebelScum
            case p => moveAlong(p.fullName)
        }
}

val anil = Person("Anil", "Anar")
val luke = Person("Luke Skywalker")
Stormtrooper.inspect(anil)
Stormtrooper.inspect(luke)
