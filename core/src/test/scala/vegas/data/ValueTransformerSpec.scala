package vegas.data

import org.scalatest.{FlatSpec, Matchers}
import vegas.util.Time

class ValueTransformerSpec extends FlatSpec with Matchers {

  case class Test(i: Int)

  "DefaultValueTransformer" should "transform any values to appropriate primitive types" in {
    DefaultValueTransformer.transform(Map(
      "a" -> 1,
      "b" -> 3.14,
      "c" -> null,
      "d" -> Test(3),
      "e" -> Some(3),
      "f" -> None,
      "g" -> Time.mkSqlTimestamp(1984, 12, 25, 23, 59, 59)
    )) should === (Map(
      "a" -> 1,
      "b" -> 3.14,
      "c" -> null,
      "d" -> "Test(3)",
      "e" -> 3,
      "f" -> null,
      "g" -> "1984-12-25T23:59:59"
    ))
  }

}
