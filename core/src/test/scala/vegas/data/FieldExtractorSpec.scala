package vegas.data

import org.scalatest.{FlatSpec, Matchers}

class FieldExtractorSpec extends FlatSpec with Matchers {

  case class Ex(a: Int, b: String, c: Double)

  "FieldExtractor" should "extract fields from a case class into a Map[String, Any]" in {
    val ex = Ex(2, "UK", 3.14)
    val fields = FieldExtractor.extractFields( ex )
    fields should equal (Map("a" -> 2, "b" -> "UK", "c" -> 3.14))
  }

}
