package vegas.DSL

import org.scalatest.{FlatSpec, Matchers}
import vegas.BaseSpec

/**
  * @author Aish Fenton.
  */
class OptSpec extends FlatSpec with Matchers {

  def test(a: OptArg[Int] = NoArg, b: OptArg[String] = NoArg, c: OptArg[Any] = NoArg) = (a,b,c)

  "OptArg" should "throw an exception if NoArg.get is called, and return value if SomeArg.get is called" in {
    val (x1,x2,x3) = test(b="test")
    an [NoSuchElementException] should be thrownBy x1.get
    x2.get should equal ("test")
  }

  it should "return NoArg if created with a null, and SomeArg if created with anything else" in {
    OptArg(1) should equal (SomeArg[Int](1))
    OptArg(null) should equal (NoArg)
  }

  it should "implicitly convert arguments to SomeArg[T] with the right type" in {
    val obj = new Object
    val (x1: OptArg[Int],x2: OptArg[String], x3: OptArg[Any]) = test(1, "test", obj)

    x1 should equal (SomeArg(1))
    x2 should equal (SomeArg("test"))
    x3 should equal (SomeArg(obj))
  }

  it should "implicitly convert OptArgs to Option" in {
    val (x1,x2,x3) = test(a=1)

    x1.map(x => x) should equal (Some(1))
    x2.getOrElse("was none") should equal ("was none")

  }

}
