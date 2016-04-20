package vegas.render

import vegas.DSL.SpecBuilder
import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
case class DynamicHTMLRenderer(spec: Spec) extends BaseHTMLRenderer {

  val JQueryImport = """<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>"""

  def HTMLImports = {
    val loadScripts = "$.getScript(\"" + JSImports.head + "\")" + JSImports.tail.map { i => ".then(function() { return $.getScript(\"" + i + "\") })" }.mkString("")
    s"""
      | <script>
      |   $$.ajaxSetup({
      |     cache: true
      |   });
      |   window['vegas'] = ${loadScripts}
      | </script>
    """.stripMargin
  }

  def HTMLChart(name: String, pretty: Boolean = false) =
    s"""
       | <script>
       |   var embedSpec = {
       |     mode: "vega-lite",
       |     spec: ${spec.toJson(pretty)}
       |   }
       |   window['vegas'].then( function() { vg.embed("#$name", embedSpec, function(error, result) {}) } );
       | </script>
       | <div id='$name'></div>
    """.stripMargin

  /*
   * Complete HTML including all required script imports. This is the easiest method to use, but will result in all JS
   * scripts being re-imported for every chart, which will be quite ineffecient if there are many charts on your page.
   * If is recommended that you use .HTMLImports once, then HTMLChart for each chart
   */
  def HTMLSection(includeJQuery: Boolean = false, pretty: Boolean = false) = {
    val cell = HTMLImports + HTMLChart("vis", pretty)
    if (includeJQuery) JQueryImport + cell else cell
  }

}

object DynamicHTMLRenderer {

  implicit def toDynamicHTMLRenderer(sb: SpecBuilder): DynamicHTMLRenderer = { new DynamicHTMLRenderer(sb.spec) }

}