package vegas.render

import vegas.spec.Spec2.ExtendedUnitSpec

/**
  * @author Aish Fenton.
  */
trait BaseHTMLRenderer {

  def JSImports = collection.immutable.ListMap(
    "d3" -> "https:////d3js.org/d3.v3.min.js",
    "vg" -> "https://vega.github.io/vega/vega.js",
    "vl" -> "https://vega.github.io/vega-lite/vega-lite.js",
    "vg_embed" -> "https://vega.github.io/vega-editor/vendor/vega-embed.js"
  )

  def defaultName = {
    "vegas-" + java.util.UUID.randomUUID.toString
  }

  def spec: ExtendedUnitSpec

  def show(implicit fn: String => Unit)

}
