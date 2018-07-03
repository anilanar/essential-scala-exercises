package essential

import java.util.Date

sealed trait Visitor
{
    def id: String
    def createdAt: Date
    def age: Long = new Date().getTime - createdAt.getTime
}

final case class Anonymous(id: String, createdAt: Date) extends Visitor
final case class User(id: String, createdAt: Date, name: String) extends Visitor
