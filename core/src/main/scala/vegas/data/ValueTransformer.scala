package vegas.data

import java.text.SimpleDateFormat

trait ValueTransformer {

  def transform(values: Map[String, Any]): Map[String, Any] = values.map { case(k,v) => (k, transform(v)) }

  /**
    * Transforms Any values into one of the supported primitive types
    */
  def transform(value: Any): Any

}

object DefaultValueTransformer extends ValueTransformer {
  val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");

  def transform(v: Any) = v match {
    case st if SimpleTypeUtils.isSimpleType(st) => st
    case d: java.util.Date => df.format(d)
    case _ => v.toString
  }

}

