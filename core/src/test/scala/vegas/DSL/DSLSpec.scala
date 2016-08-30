package vegas.DSL

import monocle.macros.GenLens
import org.scalatest.{FlatSpec, Matchers}
import vegas._
import vegas.BaseSpec

/**
  * @author Aish Fenton.
  */
class DSLSpec extends FlatSpec with Matchers {

  "_orElse, when composing a Lens and a Prism" should "reach modify case classes with optional values immutably" in {
    case class Person(address: Option[Address])
    case class Address(street: Option[String])

    val _address = GenLens[Person](_.address)
    val _street = GenLens[Address](_.street)

    val bob = Person(None)

    val setStreet = (_address composePrism _orElse(Address(None)) composeLens _street composePrism _orElse("NoWhere"))

    setStreet.set("myStreet")(bob) should equal (Person(Some(Address(Some("myStreet")))))

  }

}
