package vegas.render

import vegas.DSL.SpecBuilder
import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
case class StaticHTMLRenderer(spec: Spec) extends BaseHTMLRenderer {

  val HTMLHeader =
    s"""
       |<html>
       |  <head>
       |    ${ this.jsImports.map { s => "<script src=\"" + s + "\" charset=\"utf-8\"></script>" }}
       |  </head>
       |  <body>
    """.stripMargin

  def HTMLSection(name: String, spec: String) =
    s"""
       | <script>
       |   var embedSpec = {
       |     mode: "vega-lite",
       |     spec: $spec
       |   }
       |   vg.embed("#$name", embedSpec, function(error, result) {});
       | </script>
       | <div id='$name'></div>
    """.stripMargin

  val HTMLFooter =
    """
      |  </body>
      |</html>
    """.stripMargin

  def pageHTML(pretty: Boolean = false) = {
    HTMLHeader.trim + HTMLSection("vis", spec.toJson(pretty)) + HTMLFooter.trim
  }

}

object StaticHTMLRenderer {

  implicit def toStaticHTMLRenderer(sb: SpecBuilder): StaticHTMLRenderer = { new StaticHTMLRenderer(sb.spec) }

}