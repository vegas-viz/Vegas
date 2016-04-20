package vegas.render

import vegas.DSL.Vegas
import vegas.spec.{QUANTITATIVE, NOMINAL, BAR}
import vegas.{ BaseSpec, Fixtures }

/**
  * @author Aish Fenton.
  */
class StaticHTMLRendererSpec extends BaseSpec with Fixtures {
  import StaticHTMLRenderer._

  val data = rawData.popData
  val spec = specs.popBarSpec

  val specBuilder = Vegas("Country Pop")
    .loadData(data)
    .addTransformCalculation("pop_millions", "datum.population / 1000000")
    .encodeX("pop_millions", QUANTITATIVE)
    .encodeY("country", NOMINAL)
    .mark(BAR)

  "StaticHTMLRenderer.HTMLPage" should "produce an HTML page" in {
    val html = specBuilder.HTMLPage()
    html shouldBe a [String]
    html should startWith("<html>")
    html should include(specBuilder.spec.toJson())
    html should endWith("</html>")
  }

  "StaticHTMLRenderer.HTMLChart" should "produce a HTML script element containing the Spec json" in {
    val html = specBuilder.HTMLChart("test")

    html shouldBe a [String]
    html.trim should startWith ("<script>")
    html should include (spec.toJson())
    html.trim should include ("</script>")
  }

  it should "use the given chart name" in {
    val name = "myChart"
    val html = specBuilder.HTMLChart(name)

    html should include ("embed(\"#" + name)
    html should include ("id='" + name)
  }
}
