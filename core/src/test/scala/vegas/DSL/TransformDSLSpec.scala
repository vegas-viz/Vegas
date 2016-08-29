
import vegas._
import vegas.spec.Spec2._

/**
  * @author Aish Fenton.
  */
class TransformDSLSpec extends BaseSpec {

//  "TransformDSL Trait" should "add a transform filter" in {
//    val specBuilder = Vegas()
//      .transformFilter("datum.b2 > 60")
//
//    specBuilder.spec.transform.get should equal (Transform(
//      filter = Some("datum.b2 > 60")
//    ))
//  }

  it should "add to an array of transform formulas" in {
    val specBuilder = Vegas()
      .addTransformCalculation("a", "datum.a + 1")
      .addTransformCalculation("b", "datum.b + 2")

    specBuilder.spec.transform.get should equal (Transform(
      calculate = Some(List(
        Formula("a", "datum.a + 1"),
        Formula("b", "datum.b + 2")
      ))
    ))
  }
}

