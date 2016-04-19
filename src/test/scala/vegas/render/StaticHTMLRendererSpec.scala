package vegas.render

import vegas.DSL.Vegas
import vegas.spec.{QUANTITATIVE, NOMINAL, BAR}
import vegas.{ BaseSpec, Fixtures }

/**
  * @author Aish Fenton.
  */
class StaticHTMLRendererSpec extends BaseSpec with Fixtures {

  import StaticHTMLRenderer._

  "StaticHTMLRenderer.pageHTML" should "produce an HTML page" in {
    val data = rawData.popData
    val spec = specs.popBarSpec

    val specBuilder = Vegas("Country Pop")
      .addData(data)
      .addTransformCalculation("pop_millions", "datum.population / 1000000")
      .encodeX("pop_millions", QUANTITATIVE)
      .encodeY("country", NOMINAL)
      .mark(BAR)

    val html = specBuilder.pageHTML()
    html shouldBe a [String]
    html should startWith("<html>")
    html should include(specBuilder.spec.toJson())
    html should endWith("</html>")
  }

}
