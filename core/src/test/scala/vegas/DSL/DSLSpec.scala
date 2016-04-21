package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.{BAR, NOMINAL, QUANTITATIVE}
import vegas.{BaseSpec, Fixtures}

/**
  * @author Aish Fenton.
  */
class DSLSpec extends BaseSpec with Fixtures {
  "_orElse, when composing a Lens and a Prism" should "reach modify case classes with optional values immutably" in {
    import Vegas._orElse

    case class Person(address: Option[Address])
    case class Address(street: Option[String])

    val _address = GenLens[Person](_.address)
    val _street = GenLens[Address](_.street)

    val bob = Person(None)

    val setStreet = (_address composePrism _orElse(Address(None)) composeLens _street composePrism _orElse("NoWhere"))

    setStreet.set("myStreet")(bob) should equal (Person(Some(Address(Some("myStreet")))))

  }

  "The DSL" should "build a valid Spec" in {
    val data = rawData.popData
    val spec = specs.popBarSpec

    val specBuilder = Vegas("Country Pop")
      .loadData(data)
      .addTransformCalculation("pop_millions", "datum.population / 1000000")
      .encodeX("pop_millions", QUANTITATIVE)
      .encodeY("country", NOMINAL)
      .mark(BAR)

    specBuilder.spec should equal (spec)
  }


}
