package vegas

import argonaut._, Argonaut._


case class Spec(description: Option[String] = None, data: Option[Data] = None, mark: Mark,
                transform: Option[Transform] = None, encoding: Option[Encoding] = None,
                config: Option[Config] = None)

case class Data(values: Option[Map[String, Any]] = None, url: Option[String] = None,
                formatType: Option[FormatType] = None)

sealed trait FormatType { def name: String }
case object JSON extends FormatType { val name = "json" }
case object CSV extends FormatType { val name = "csv" }
case object TSV extends FormatType { val name = "tsv" }

sealed trait Mark { def name: String }
case object BAR extends Mark { val name = "bar" }
case object CIRCLE extends Mark { val name = "circle" }
case object SQUARE extends Mark { val name = "square" }
case object TICK extends Mark { val name = "tick" }
case object LINE extends Mark { val name = "line" }
case object AREA extends Mark { val name = "area" }
case object POINT extends Mark { val name = "point" }
case object TEXT extends Mark { val name = "text" }

case class Transform(calculate: Option[Array[Formula]] = None, filterNull: Option[Boolean] = None, filter: Option[String] = None)
case class Formula(field: String, expr: String)

case class Encoding(x: Option[ChannelDef] = None, y: Option[ChannelDef] = None, color: Option[ChannelDef] = None)

case class ChannelDef(field: Option[String] = None, dataType: Option[DataType] = None, value: Option[String] = None)

sealed trait DataType { def name: String }
case object QUANTITATIVE extends DataType { val name = "quantitative" }
case object NOMINAL extends DataType { val name = "nominal" }

case class Config(t: String)

trait Encoders {

  val noNullSpaces2 = PrettyParams.spaces2.copy(dropNullKeys = true)
  val noNulls = PrettyParams.nospace.copy(dropNullKeys = true)

  private def stringifyValues(v: Map[String, Any]) = v.map { case(k,v) => (k, v.toString) }

  implicit def SpecEncoder: EncodeJson[Spec] =
    jencode6L((s: Spec) => (s.description, s.data, s.mark.name, s.transform, s.encoding, s.config))("description", "data", "mark", "transform", "encoding", "config")

  implicit def DataEncoder: EncodeJson[Data] =
    jencode3L((d: Data) => (d.values.map(stringifyValues), d.url, d.formatType.map(_.name)))("values", "url", "formatType")

  implicit def TransformEncoder: EncodeJson[Transform] =
    jencode3L((t: Transform) => (t.calculate, t.filterNull, t.filter))("calculate", "filterNull", "filter")

  implicit def FormulaEncoder: EncodeJson[Formula] =
    jencode2L((f: Formula) => (f.field, f.expr))("field", "expr")

  implicit def EncodingEncoder: EncodeJson[Encoding] =
    jencode3L((e: Encoding) => (e.x, e.y, e.color))("x", "y", "color")

  implicit def ChannelDefEncoder: EncodeJson[ChannelDef] =
    jencode3L((cd: ChannelDef) => (cd.field, cd.dataType.map(_.name), cd.value))("field", "dataType", "value")

  implicit def ConfigEncoder: EncodeJson[Config] =
    jencode1L((c: Config) => (c.t))("t")

}


