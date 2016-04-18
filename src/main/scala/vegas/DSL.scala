package vegas

import java.net.URL
import monocle.macros.GenLens
import argonaut._, Argonaut._

/**
  * @author Aish Fenton.
  */
object Vegas {

  def apply(description: String) = SpecBuilder(Spec(description=Some(description)))

}

/**
  * @author Aish Fenton.
  */
case class SpecBuilder(spec: Spec) extends HTMLDisplay {

  val _spec = GenLens[SpecBuilder](_.spec)
  val _data = GenLens[Spec](_.data)
  val _mark = GenLens[Spec](_.mark)
  val _transform = GenLens[Spec](_.transform)

  val _calculate = GenLens[Transform](_.calculate)
  val _filterNull = GenLens[Transform](_.filterNull)
  val _filter = GenLens[Transform](_.filter)

  val _encoding = GenLens[Spec](_.encoding)
  val _x = GenLens[Encoding](_.x)
  val _y = GenLens[Encoding](_.y)

  def addData(values: Seq[Map[String, Any]]): SpecBuilder = {
    val data = Data(Option(values))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def addData(values: Array[Any]) = ???

  def addData(url: URL, formatType: FormatType) = {
    val data = Data(None, Option(url), Option(formatType))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(Some(mark))(this)
  }

  def encodeX(field: String, dataType: DataType) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType))
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _x).set(Some(cd))(this)
  }

  def encodeY(field: String, dataType: DataType) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType))
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _y).set(Some(cd))(this)
  }

  def addTransformCalculation(field: String, expr: String) = {
    val formula = Formula(field, expr)
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _calculate composePrism _orElse(Nil)).modify((xs: Seq[Formula]) => xs :+ formula)(this)
  }

  def transformFilter(filter: String) = {
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _filter).set(Some(filter))(this)
  }

  def transformFilterNull(filterNull: Boolean = true) = {
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _filterNull).set(Some(filterNull))(this)
  }

}

trait HTMLDisplay {
  self: SpecBuilder =>

  val HTMLHeader =
    """
      | <html>
      |   <head>
      |     <script src="//d3js.org/d3.v3.min.js" charset="utf-8"></script>
      |     <script src="//vega.github.io/vega/vega.js" charset="utf-8"></script>
      |     <script src="//vega.github.io/vega-lite/vega-lite.js" charset="utf-8"></script>
      |     <script src="//vega.github.io/vega-editor/vendor/vega-embed.js" charset="utf-8"></script>
      |   </head>
      |   <body>
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

  def asJson(pretty: Boolean = false) = {
    val json = self.spec.asJson
    if (pretty) json.pretty(vegas.noNullSpaces2) else json.pretty(vegas.noNulls)
  }

  def displayHTML(divName: String = "viz") = {
    HTMLHeader + HTMLSection(divName, asJson(false)) + HTMLFooter
  }

}
