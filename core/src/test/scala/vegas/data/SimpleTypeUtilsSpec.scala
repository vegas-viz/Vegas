package vegas.data

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Aish Fenton.
  */
class SimpleTypeUtilsSpec extends FlatSpec with Matchers {

  "SimpleTypeUtils.toDouble" should "try to transform Any into Doubles, or return None" in {
    SimpleTypeUtils.toDouble(3.14) should === (Some(3.14))
    SimpleTypeUtils.toDouble(3) should === (Some(3.0))
    SimpleTypeUtils.toDouble(3L) should === (Some(3.0))
    SimpleTypeUtils.toDouble(1.toByte) should === (Some(1.0))
    SimpleTypeUtils.toDouble("hi") should === (None)
  }

  "SimpleTypeUtils.isNumber" should "true if a number, false otherwise" in {
    SimpleTypeUtils.isNumber(3.14) should be(true)
    SimpleTypeUtils.isNumber(1.toByte) should be(true)
    SimpleTypeUtils.isNumber(Long.MaxValue) should be(true)
    SimpleTypeUtils.isNumber(true) should be(false)
    SimpleTypeUtils.isNumber("a") should be(false)
  }

  "SimpleTypeUtils.isSimpleType" should "true if a number or String, otherwise false" in {
    SimpleTypeUtils.isSimpleType(3.14) should be(true)
    SimpleTypeUtils.isSimpleType("a") should be(true)
    SimpleTypeUtils.isSimpleType(Some("ok")) should be(false)
  }
}
