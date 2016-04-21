package vegas.render

import vegas._
import vegas.{Fixtures, BaseSpec}

/**
  * @author Aish Fenton.
  */
class DynamicHTMLRendererSpec extends BaseSpec with Fixtures {
  import DynamicHTMLRenderer._

  val data = rawData.popData
  val spec = specs.popBarSpec
  val specBuilder = Vegas("Country Pop")
    .loadData(data)
    .addTransformCalculation("pop_millions", "datum.population / 1000000")
    .encodeX("pop_millions", QUANTITATIVE)
    .encodeY("country", NOMINAL)
    .mark(BAR)

  "DynamicHTMLRenderer.HTMLImports" should "produce a HTML script element containing the Vega js imports" in {
    val html = specBuilder.HTMLImports

    html shouldBe a [String]
    html.trim should startWith ("<script>")
    specBuilder.JSImports.foreach { url => html should include (url) }
    html.trim should endWith ("</script>")
  }

  "DynamicHTMLRenderer.HTMLChart" should "produce a HTML script element containing the Spec json" in {
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
