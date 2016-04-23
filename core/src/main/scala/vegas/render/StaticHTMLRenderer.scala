package vegas.render

import vegas.DSL.SpecBuilder
import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
case class StaticHTMLRenderer(spec: Spec) extends BaseHTMLRenderer {

  def importsHTML(additionalImports: String*) = (JSImports.values ++ additionalImports).map { s => "<script src=\"" + s + "\" charset=\"utf-8\"></script>" }.mkString("\n")

  def headerHTML(additionalImports: String*) =
    s"""
       |<html>
       |  <head>
       |    ${ importsHTML(additionalImports:_*) }
       |  </head>
       |  <body>
    """.stripMargin

  def chartHTML(name: String = this.defaultName, pretty: Boolean = false) =
    s"""
       | <script>
       |   var embedSpec = {
       |     mode: "vega-lite",
       |     spec: ${spec.toJson(pretty)}
       |   }
       |   vg.embed("#$name", embedSpec, function(error, result) {});
       | </script>
       | <div id='$name'></div>
    """.stripMargin

  val footerHTML =
    """
      |  </body>
      |</html>
    """.stripMargin

  def pageHTML(pretty: Boolean = false) = {
    headerHTML().trim + chartHTML(pretty=pretty) + footerHTML.trim
  }

  def frameHTML(pretty: Boolean = false) =
    s"""
       |<iframe sandbox="allow-scripts" style="border: none; width: 100%" srcdoc="${xml.Utility.escape(pageHTML(pretty))}"></iframe>
     """.stripMargin


}

object StaticHTMLRenderer {

  implicit def toStaticHTMLRenderer(sb: SpecBuilder): StaticHTMLRenderer = { new StaticHTMLRenderer(sb.spec) }

}