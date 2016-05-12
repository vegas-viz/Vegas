
import vegas._
import vegas.spec.{Formula, Transform}

/**
  * @author Aish Fenton.
  */
class TransformDSLSpec extends BaseSpec {

  "TransformDSL Trait" should "add a transform filter" in {
    val specBuilder = Vegas()
      .transformFilter("datum.b2 > 60")

    specBuilder.spec.transform.get should equal (Transform(
      filter = Some("datum.b2 > 60")
    ))
  }

  it should "filter nulls" in {
    val specBuilder = Vegas()
      .transformFilterNull()

    specBuilder.spec.transform.get should equal (Transform(
      filterNull = Some(true)
    ))
  }

  it should "add to an array of transform formulas" in {
    val specBuilder = Vegas()
      .addTransformCalculation("a", "datum.a + 1")
      .addTransformCalculation("b", "datum.b + 2")

    specBuilder.spec.transform.get should equal (Transform(
      calculate = Some(Seq(
        Formula("a", "datum.a + 1"),
        Formula("b", "datum.b + 2")
      ))
    ))
  }
}

