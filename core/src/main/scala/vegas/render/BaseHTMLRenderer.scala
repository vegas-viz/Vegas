package vegas.render

import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
trait BaseHTMLRenderer {

  def JSImports = Map(
    "d3" -> "//d3js.org/d3.v3.min.js",
    "vg" -> "//vega.github.io/vega/vega.js",
    "vl" -> "//vega.github.io/vega-lite/vega-lite.js",
    "vg_embed" -> "//vega.github.io/vega-editor/vendor/vega-embed.js"
  )

  def defaultName = {
    val uuid = java.util.UUID.randomUUID.toString
    spec.description.getOrElse(uuid).replaceAll(" ", "-").toLowerCase()
  }

  def spec: Spec

}
