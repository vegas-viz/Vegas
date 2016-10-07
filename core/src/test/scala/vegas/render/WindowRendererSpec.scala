package vegas.render

import vegas._
import vegas.data.External._
import org.scalatest.{ FlatSpec, Matchers }

class WindowRendererSpec extends FlatSpec with Matchers {
  import vegas.render.WindowRenderer._

  val specBuilder =
    Vegas("Country Pop")
      .withURL(Population)
      .encodeX("age", Quant)
      .encodeY("people", Nom, AggOps.Sum)
      .mark(Bar)

  "WindowRenderer.show" should "render plots without JS errors" in {
    val wr = WindowRenderer.toWindow(specBuilder)
    wr.show
    Thread.sleep(1000)
    wr.errors shouldBe (empty)
    wr.close
  }

}
