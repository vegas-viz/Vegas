package vegas.render

import vegas._
import vegas.data.External._
import org.scalatest.{FlatSpec, Matchers}
import vegas.DSL.SpecBuilder

class WindowRendererSpec extends FlatSpec with Matchers {
  val specBuilder: SpecBuilder =
    Vegas("Country Pop")
      .withURL(Population)
      .encodeX("age", Quant)
      .encodeY("people", Nom, AggOps.Sum)
      .mark(Bar)

  "WindowRenderer.show" should "render plots without JS errors" in {
    val wr = specBuilder.window
    wr.show
    Thread.sleep(1000)
    wr.errors shouldBe (empty)
    wr.close
  }

}
