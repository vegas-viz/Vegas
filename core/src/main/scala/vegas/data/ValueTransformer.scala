package vegas.data

import java.text.SimpleDateFormat

/**
  * Base trait for transforming Any values into primitive types that are accepted by vega-lite. Default implementation
  * does a pass through for primitives, converts dates to ISO8601, and uses toString for everything else.
  */
trait ValueTransformer {

  def transform(values: Map[String, Any]): Map[String, Any] = values.map { case(k,v) => (k, transformValue(v)) }

  /**
    * Transforms Any values into one of the supported primitive types
    */
  def transformValue(value: Any): Any

}

object DefaultValueTransformer extends ValueTransformer {
  val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

  def transformValue(v: Any): Any = v match {
    case null => null
    case st if SimpleTypeUtils.isSimpleType(st) => st
    case d: java.sql.Date => d.toString
    case d: java.util.Date => df.format(d)
    case Some(x: Any) => transformValue(x)
    case None => null
    case _ => v.toString
  }

}

