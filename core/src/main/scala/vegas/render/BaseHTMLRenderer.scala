package vegas.render

import vegas.spec.Spec.ExtendedUnitSpec

import scala.io.Source

trait BaseHTMLRenderer {

  private val WebJars = Source.fromInputStream(getClass.getResourceAsStream("/webjars.csv"))
    .getLines
    .map { l => val row = l.split(","); (row(0), row(1)) }
    .toMap

  private def cdn(artifact: String) = s"https://cdn.jsdelivr.net/npm/$artifact@${WebJars(artifact)}"

  val JSImports = List(
    "vega",
    "vega-lite",
    "vega-embed"
  ).map(cdn)

  def defaultName = {
    "vegas-" + java.util.UUID.randomUUID.toString
  }

  def specJson: String


}
