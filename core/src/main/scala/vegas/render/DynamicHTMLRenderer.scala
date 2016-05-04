package vegas.render

import vegas.DSL.SpecBuilder
import vegas.spec.Spec

/**
  * @author Aish Fenton.
  */
case class DynamicHTMLRenderer(spec: Spec) extends BaseHTMLRenderer {

  val JQueryImport = """<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>"""

  def importsHTML = {
    def quote(s: String) = "'" + s + "'"
    def requireLoad =
      s"""
      |  require.config({
      |    paths: {
      |      ${ JSImports.map { case(k,v) => quote(k) + ":" + quote(v + "?noext") }.mkString(",")}
      |    },
      |    shim: {
      |      "vg_embed": { deps: ["vg", "vl"] },
      |      "vl": {deps: ["vg"]},
      |      "vg": {deps: ["d3"]}
      |    }
      |  });
      """.stripMargin

    def jQueryLoad = "$.getScript(\"" + JSImports.values.head + "\")" + JSImports.values.tail.map { i => ".then(function() { return $.getScript(\"" + i + "\") })" }.mkString("")

    s"""
      | <script>
      |   window['isRequireJS'] = isRequireJS = (typeof define === "function" && define.amd)
      |   if (isRequireJS) {
      |    ${requireLoad}
      |   } else {
      |     $$.ajaxSetup({ cache: true });
      |     window['vegas'] = ${jQueryLoad}
      |   }
      | </script>
    """.stripMargin
  }

  def chartHTML(name: String, pretty: Boolean = false) =
    s"""
       | <script>
       |   function doEmbed(vg) {
       |     var embedSpec = {
       |       mode: "vega-lite",
       |       spec: ${spec.toJson(pretty)}
       |     }
       |     vg.embed("#$name", embedSpec, function(error, result) {});
       |   }
       |   if (isRequireJS) {
       |     require(["d3","vg", "vl", "vg_embed"], function(d3, vg, vl, vgEmbed) { doEmbed(vg); });
       |   } else {
       |     window['vegas'].then( function() { doEmbed(window['vg']) } );
       |   }
       | </script>
       | <div id='$name'></div>
    """.stripMargin

  /*
   * Complete HTML including all required script imports. This is the easiest method to use, but will result in all JS
   * scripts being re-imported for every chart, which will be quite ineffecient if there are many charts on your page.
   * If is recommended that you use .HTMLImports once, then HTMLChart for each chart
   */
  def sectionHTML(includeJQuery: Boolean = false, pretty: Boolean = false) = {
    val cell = importsHTML + chartHTML("vis", pretty)
    if (includeJQuery) JQueryImport + cell else cell
  }

  def show(implicit fn: String => Unit) = fn(sectionHTML())

}

object DynamicHTMLRenderer {

  implicit def toDynamicHTMLRenderer(sb: SpecBuilder): DynamicHTMLRenderer = { new DynamicHTMLRenderer(sb.spec) }

}