package io.github.hamsters

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShowSpec extends AnyFlatSpec with Matchers {

  import Show._

  case class Name(firstName: String, lastName: String)

  case class Person(name : Name, age: Int)

  "Show on simple object" should "show field names and values of object" in {
    val n = Name("john", "doe")
    n.show should be("Name(firstName=john,lastName=doe)")
  }

  "Show on deeper object" should "show field names and values of object" in {
    val p = Person(Name("john", "doe"), 35)
    p.show should be("Person(name=Name(firstName=john,lastName=doe),age=35)")
  }

  case class Directory(persons: Seq[Person], departments: Seq[String])

  "Show on object with sequences" should "show field names and values of object" in {
    val d = Directory(Seq(Person(Name("jane", "doe"), 36), Person(Name("john", "doe"), 35), Person(Name("bob", "x"), 40)), Seq("IT, RH, MKT"))
    d.show should be("Directory(persons=[Person(name=Name(firstName=jane,lastName=doe),age=36),Person(name=Name(firstName=john,lastName=doe),age=35),Person(name=Name(firstName=bob,lastName=x),age=40)],departments=[IT, RH, MKT])")
  }

}
