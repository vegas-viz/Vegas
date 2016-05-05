package vegas.render

import vegas._
import vegas.BaseSpec

/**
  * @author Aish Fenton.
  */
class StaticHTMLRendererSpec extends BaseSpec {
  import StaticHTMLRenderer._

  val data = Seq( Map("population" -> 318000000, "country" -> "USA"), Map("population" -> 64000000, "country" -> "UK") )

  val specBuilder = Vegas("Country Pop")
    .withData(data: _*)
    .addTransformCalculation("pop_millions", "datum.population / 1000000")
    .encodeX("pop_millions", Quantitative)
    .encodeY("country", Nominal)
    .mark(Bar)

  "StaticHTMLRenderer.HTMLPage" should "produce an HTML page" in {
    val html = specBuilder.pageHTML()
    html shouldBe a [String]
    html should startWith("<html>")
    html should include(specBuilder.spec.toJson())
    html should endWith("</html>")
  }

  "StaticHTMLRenderer.HTMLChart" should "produce a HTML script element containing the Spec json" in {
    val html = specBuilder.chartHTML("test")

    html shouldBe a [String]
    html.trim should startWith ("<script>")
    html should include (specBuilder.spec.toJson())
    html.trim should include ("</script>")
  }

  it should "use the given chart name" in {
    val name = "myChart"
    val html = specBuilder.chartHTML(name)

    html should include ("embed(\"#" + name)
    html should include ("id='" + name)
  }

  it should "have a default chart name that starts with a letter, and contains no spaces" in {
    val html = specBuilder.chartHTML()
    val name = "<div id='([^']*)'".r.findFirstMatchIn(html).get.group(1)

    name should fullyMatch regex """[a-zA-Z][a-zA-z\d-]*"""
  }

}
