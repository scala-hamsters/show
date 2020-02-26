# Show

This is a port of Show from Hamsters to Scala 2.13.

Show provides a textual representation for case classes (better than `toString`).

```scala
import io.github.hamsters.Show._

case class Name(firstName: String, lastName: String)

val n = Name("john", "doe")
n.show // "Name(firstName=john,lastName=doe)"
```


It also can be a case class containing nested case classes : 

```scala 
case class Name(firstName: String, lastName: String)

case class Person(name: Name, age: Int)

val p = Person(Name("john", "doe"), 35)
p.show // "Person(name=Name(firstName=john,lastName=doe),age=35)"
```

Or a case class containing sequences : 

```scala
case class Directory(persons: Seq[Person], departments: Seq[String])
val d = Directory(Seq(Person(Name("jane", "doe"), 36), Person(Name("john", "doe"), 35), Person(Name("bob", "x"), 40)), Seq("IT, RH, MKT"))
d.show // "Directory(persons=[Person(name=Name(firstName=jane,lastName=doe),age=36),Person(name=Name(firstName=john,lastName=doe),age=35),Person(name=Name(firstName=bob,lastName=x),age=40)],departments=[IT, RH, MKT])" 
```
---

# Install

Add this to you build.sbt : 

```scala
resolvers += Resolver.bintrayRepo("loicdescotte", "Hamsters") 
libraryDependencies += "io.github.scala-hamsters" %% "show" % "1.0.0"
```
