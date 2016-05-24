package vegas.macros

import monocle.Lens
import monocle.macros.GenLens
import vegas._

import scala.annotation.StaticAnnotation

/**
  * @author Aish Fenton.
  */
class AliasWithLensSpec extends BaseSpec {

  class ignore_me extends StaticAnnotation
  case class Ex(a: Int)
  val _a = GenLens[Ex](_.a)

  @aliased
  trait Test {

    @alias_with_lens("fnA1", _a)
    private def fnA(a: Lens[Ex, Int])(b: Int, c: String) = (a, b, c)

    @ignore_me
    private def fnB(a: Lens[Ex, Int])(b: Int, c: String) = (a, b, c)

    @alias_with_lens("fnC1", _a)
    @ignore_me
    private def fnC(a: Lens[Ex, Int])(b: Int, c: String) = (a, b, c)
  }

  "alias_with_lens" should "alias the annotated method and partially apply it using the given lens" in {
    val t = new Test { }
    t.fnA1(1, "2") should equal((_a, 1, "2"))
  }

  it should "ignore other annotations" in {
    val t = new Test { }
    t.fnC1(1, "2") should equal((_a, 1, "2"))
  }
}