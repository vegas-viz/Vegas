package vegas.render

import vegas._
import vegas.spec.{BAR, NOMINAL, QUANTITATIVE}
import vegas.{Fixtures, BaseSpec}

/**
  * @author Aish Fenton.
  */
class DynamicHTMLRendererSpec extends BaseSpec with Fixtures {
  import DynamicHTMLRenderer._

  "DynamicTMLRenderer.HTMLSection" should "produce an HTML page" in {
    val data = rawData.popData
    val spec = specs.popBarSpec

    val specBuilder = Vegas("Country Pop")
      .loadData(data)
      .addTransformCalculation("pop_millions", "datum.population / 1000000")
      .encodeX("pop_millions", QUANTITATIVE)
      .encodeY("country", NOMINAL)
      .mark(BAR)

    val html = specBuilder.HTMLSection()
    println(html)
    html shouldBe a [String]
    html should startWith("<html>")
    html should include(specBuilder.spec.toJson())
    html should endWith("</html>")
  }

}
