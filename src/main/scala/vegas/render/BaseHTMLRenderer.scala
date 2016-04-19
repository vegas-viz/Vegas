package vegas.render

import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
trait BaseHTMLRenderer {

  def jsImports = Array(
    "//d3js.org/d3.v3.min.js",
    "//vega.github.io/vega/vega.js",
    "//vega.github.io/vega-lite/vega-lite.js",
    "//vega.github.io/vega-editor/vendor/vega-embed.js"
  )

  def spec: Spec

}
