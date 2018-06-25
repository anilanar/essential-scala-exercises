case class Director(
    val firstName: String,
    val lastName: String,
    val yearOfBirth: Int
) {
    def name: String= s"$firstName $lastName"
}

object Director
{
    def older(a: Director, b: Director): Director =
        if (a.yearOfBirth < b.yearOfBirth) a
        else b
}

case class Film(
    val name: String,
    val yearOfRelease: Int,
    val imdbRating: Double,
    val director: Director
) {
    def directorsAge = yearOfRelease - director.yearOfBirth
    def isDirectedBy(director: Director) =
        this.director == director
}

object Film
{
    def newer(a: Film, b: Film): Film =
        if (a.yearOfRelease < b.yearOfRelease) b
        else a

    def highestRating(a: Film, b: Film): Film =
        if (a.imdbRating < b.imdbRating) b
        else a
}

object Dad
{
    def rate(f: Film): Double =
        f match {
            case Film(_, _, _, Director("Client", "Eastwood", _)) => 10.0
            case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
            case _ => 3.0
        }
}


val anil = new Director("Anil", "Anar", 1990)
val anilsFilm = Film("Dark Hoax", 2020, 8.2, anil)
val client = new Director("Client", "Eastwood", 1944)
val gbu = new Film("Good, Bad & Ugly", 1972, 9.2, client)
Dad.rate(anilsFilm)
Dad.rate(gbu)
