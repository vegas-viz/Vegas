package vegas.render

import vegas.spec.Spec.ExtendedUnitSpec

import scala.io.Source

trait BaseHTMLRenderer {

  private val WebJars = Source.fromInputStream(getClass.getResourceAsStream("/webjars.csv"))
    .getLines
    .map { l => val row = l.split(","); (row(0), row(1)) }
    .toMap

  private def CDN(artifact: String, file: String) = s"http://cdn.jsdelivr.net/webjars/org.webjars.bower/$artifact/${WebJars(artifact)}/$file"

  def JSImports = List(
    CDN("d3", "d3.min.js"),
    CDN("vega", "vega.min.js"),
    CDN("vega-lite", "vega-lite.min.js"),
    "https://vega.github.io/vega-editor/vendor/vega-embed.js"
  )

  def defaultName = {
    "vegas-" + java.util.UUID.randomUUID.toString
  }

  def specJson: String

  def show(implicit fn: String => Unit)

}
