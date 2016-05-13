package vegas.spec

import java.net.URI

import argonaut.Argonaut._
import argonaut._

case class Spec(description: Option[String] = None, data: Option[Data] = None, mark: Option[Mark] = None,
                transform: Option[Transform] = None, encoding: Option[Encoding] = None,
                config: Option[Config] = None) {

  def toJson(pretty: Boolean = false) = {
    import Encoders._

    val j = this.asJson
    if (pretty) j.pretty(Encoders.noNullSpaces2) else j.pretty(Encoders.noNulls)
  }

}

case class Data(values: Option[Seq[Map[String, Any]]] = None, url: Option[URI] = None,
                formatType: Option[FormatType] = None)

sealed trait FormatType { def name: String }
case object JSON extends FormatType { val name = "json" }
case object CSV extends FormatType { val name = "csv" }
case object TSV extends FormatType { val name = "tsv" }

sealed trait Mark { def name: String }
case object Bar extends Mark { val name = "bar" }
case object Circle extends Mark { val name = "circle" }
case object Square extends Mark { val name = "square" }
case object Tick extends Mark { val name = "tick" }
case object Line extends Mark { val name = "line" }
case object Area extends Mark { val name = "area" }
case object Point extends Mark { val name = "point" }
case object Text extends Mark { val name = "text" }

case class Transform(calculate: Option[Seq[Formula]] = None, filterNull: Option[Boolean] = None, filter: Option[String] = None)
case class Formula(field: String, expr: String)

case class Encoding(x: Option[ChannelDef] = None, y: Option[ChannelDef] = None, color: Option[ChannelDef] = None,
                    column: Option[ChannelDef] = None, row: Option[ChannelDef] = None, size: Option[ChannelDef] = None)

case class ChannelDef(field: Option[String] = None, dataType: Option[DataType] = None, value: Option[String] = None,
                      aggregate: Option[Aggregate] = None, axis: Option[Axis] = None, scale: Option[Scale] = None)

sealed trait DataType { def name: String }
case object Quantitative extends DataType { val name = "quantitative" }
case object Nominal extends DataType { val name = "nominal" }
case object Ordinal extends DataType { val name = "ordinal" }
case object Temporal extends DataType { val name = "temporal" }

sealed trait Aggregate { def name: String }
case object Count extends Aggregate { val name = "count" }
case object Valid extends Aggregate { val name = "valid" }
case object Missing extends Aggregate { val name = "missing" }
case object Distinct extends Aggregate { val name = "distinct" }
case object Sum extends Aggregate { val name = "sum" }
case object Mean extends Aggregate { val name = "mean" }
case object Average extends Aggregate { val name = "average" }
case object Variance extends Aggregate { val name = "variance" }
case object VarianceP extends Aggregate { val name = "variancep" }
case object StDev extends Aggregate { val name = "stdev" }
case object StDevP extends Aggregate { val name = "stdevp" }
case object Median extends Aggregate { val name = "median" }
case object Q1 extends Aggregate { val name = "q1" }
case object Q3 extends Aggregate { val name = "q3" }
case object ModeSkew extends Aggregate { val name = "modeskew" }
case object Min extends Aggregate { val name = "min" }
case object Max extends Aggregate { val name = "max" }

case class Axis(hide: Option[Boolean] = None, title: Option[String] = None, titleOffset: Option[Int] = None,
                titleMaxLength: Option[Int] = None, characterWidth: Option[Int] = None, orient: Option[Orient] = None,
                axisWidth: Option[Int] = None, offset: Option[Int] = None, grid: Option[Boolean] = None,
                ticks: Option[Int] = None, tickColor: Option[String] = None, tickLabelFontSize: Option[Int] = None,
                titleFontSize: Option[Int] = None,
                labels: Option[Boolean] = None, format: Option[String] = None, labelAngle: Option[Double] = None,
                labelMaxLength: Option[Int] = None, shortTimeLabels: Option[Boolean] = None)

sealed trait Orient { def name: String }
case object Bottom extends Orient { val name = "bottom" }
case object Top extends Orient { val name = "top" }
case object Left extends Orient { val name = "left" }
case object Right extends Orient { val name = "right" }

case class Scale(scaleType: Option[ScaleType] = None, bandSize: Option[Int] = None, padding: Option[Int] = None,
                 range: Option[Seq[String]] = None, rangePreset: Option[RangePreset] = None)

sealed trait ScaleType { def name: String }
case object Linear extends ScaleType { val name = "linear" }
case object Log extends ScaleType { val name = "log" }
case object Pow extends ScaleType { val name = "pow" }
case object Sqrt extends ScaleType { val name = "sqrt" }
case object Quantile extends ScaleType { val name = "quantile" }
case object Quantize extends ScaleType { val name = "quantize" }
case object Threshold extends ScaleType { val name = "threshold" }
case object Time extends ScaleType { val name = "time" }
case object OrdinalS extends ScaleType { val name = "ordinal" }

sealed trait RangePreset { def name: String }
case object Category10 extends RangePreset { val name = "category10" }
case object Category20 extends RangePreset { val name = "category20" }
case object Category20b extends RangePreset { val name = "category20b" }
case object Category20c extends RangePreset { val name = "category20c" }

case class Config(todo: String)

object Encoders {

  val noNullSpaces2 = PrettyParams.spaces2.copy(dropNullKeys = true)
  val noNulls = PrettyParams.nospace.copy(dropNullKeys = true)

  private def stringifyValues(v: Seq[Map[String, Any]]) = v.map { _.map { case(k,v) => (k, v.toString) } }

  implicit def SpecEncoder: EncodeJson[Spec] =
    jencode6L((s: Spec) => (s.description, s.data, s.mark.map(_.name), s.transform, s.encoding, s.config))("description", "data", "mark", "transform", "encoding", "config")

  implicit def DataEncoder: EncodeJson[Data] =
    jencode3L((d: Data) => (d.values.map(stringifyValues), d.url.map(_.toString), d.formatType.map(_.name)))("values", "url", "formatType")

  implicit def TransformEncoder: EncodeJson[Transform] =
    jencode3L((t: Transform) => (t.calculate, t.filterNull, t.filter))("calculate", "filterNull", "filter")

  implicit def FormulaEncoder: EncodeJson[Formula] =
    jencode2L((f: Formula) => (f.field, f.expr))("field", "expr")

  implicit def EncodingEncoder: EncodeJson[Encoding] =
    jencode6L((e: Encoding) => (e.x, e.y, e.color, e.column, e.row, e.size))("x", "y", "color", "column", "row", "size")

  implicit def ChannelDefEncoder: EncodeJson[ChannelDef] =
    jencode6L((cd: ChannelDef) => (cd.field, cd.dataType.map(_.name), cd.value, cd.aggregate.map(_.name),
      cd.axis, cd.scale))("field", "type", "value", "aggregate", "axis", "scale")

  implicit def AxisEncoder: EncodeJson[Axis] = EncodeJson((a: Axis) => if (a.hide.getOrElse(false)) {
    jFalse
  } else {
    ("title" := a.title) ->:
      ("titleOffset" := a.titleOffset) ->:
      ("titleMaxLength" := a.titleMaxLength) ->:
      ("characterWidth" := a.characterWidth) ->:
      ("orient" := a.orient.map(_.name)) ->:
      ("axisWidth" := a.axisWidth) ->:
      ("offset" := a.offset) ->:
      ("grid" := a.grid) ->:
      ("ticks" := a.ticks) ->:
      ("tickColor" := a.tickColor) ->:
      ("tickLabelFontSize" := a.tickLabelFontSize) ->:
      ("titleFontSize" := a.titleFontSize) ->:
      ("labels" := a.labels) ->:
      ("format" := a.format) ->:
      ("labelAngle" := a.labelAngle) ->:
      ("labelMaxLength" := a.labelMaxLength) ->:
      ("shortTimeLabels" := a.shortTimeLabels) ->:
    jEmptyObject
  })

  implicit def ScaleEncoder: EncodeJson[Scale] = EncodeJson((s: Scale) => {
    val rangeJson = if (s.rangePreset.isDefined) ("range" := s.rangePreset.map(_.name)) else ("range" := s.range)

    ("type" := s.scaleType.map(_.name)) ->:
      ("bandSize" := s.bandSize) ->:
      ("padding" := s.padding) ->:
      rangeJson  ->:
      jEmptyObject
  })

  implicit def ConfigEncoder: EncodeJson[Config] =
    jencode1L((c: Config) => (c.todo))("todo")

}


