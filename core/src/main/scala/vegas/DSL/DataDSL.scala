package vegas.DSL

import monocle.macros.GenLens
import monocle.Lens
import vegas.spec.Spec._

import vegas.data.{ FieldExtractor, ValueTransformer }

/**
  * @tparam T the base builder type. Needs to be generic since this can be mixed into different places
  */
trait DataDSL[T] {
  self: T =>

  protected[this] def _data: Lens[T, Option[Data]]

  private val _values = GenLens[Data](_.values)

  /**
    * Uses data from an external source as specified by the given URL.
    * @param url The URL for the external data source.
    * @param formatType The type of the data (i.e. DataFormat.Json, DataFormat.Csv, etc).
    */
  def withURL(url: String, formatType: OptArg[DataFormatType] = NoArg): T = {
    val data = Data(
      url = Some(url),
      format = formatType.map( t => DataFormat(`type`= Some(t)))
    )
    _data.set(Some(data))(this)
  }

  /**
    * Specifies data as a Seq of rows, where each row is specified using a Map of column -> value pairs.
    * @param values A Seq of Maps, with each Map specifying the column -> value pairs of a row.
    * @param vt. Since values are of type Any, we need to transform these into something
    *                 vega-lite can handle. By default we turn anything that isn't a primitive type
    *                 into a String, and format Dates as ISO-8601.
    */
  def withData(values: Seq[Map[String, Any]])(implicit vt: ValueTransformer): T = {
    // Transform first
    val data = Data(
      values = Some(values.toList.map { row =>
        val newRow = vt.transform(row)
        Data.Values(newRow)
      })
    )

    _data.set(Some(data))(this)
  }

  /**
    * Specifies data as a Seq of values (i.e. Array(1.2, 4.2, 5,6)). The array indices are used to create a column "x",
    * and the array's values to create a column "y". To encode this data you'd use:
    *
    *   encodeX("x", Ordinal)
    *   encodeX("y", ...)
    *
    * @param values A Seq[Any] containing the values to use.
    */
  def withValues(values: Seq[Any])(implicit vt: ValueTransformer): T = {
    val data = values.zipWithIndex.map { case(y, i) => Map("x" -> i, "y" -> y) }
    withData(data)
  }

  /**
    * Specifies data as a Seq of x,y values represented by the tuple (Any, Any). Each column is named "x", "y". To
    * encode the data you'd use:
    *
    *   encodeX("x", ...).
    *   encodeY("y", ...)
    *
    * @param values A Seq of (Any, Any) tuples
    */
  def withXY(values: Seq[(Any, Any)])(implicit vt: ValueTransformer): T = {
    val data = values.map { case(x, y) => Map("x" -> x, "y" -> y) }
    withData(data)
  }

  /**
    * Specifies data as a Seq of Seq data (i.e Array(Array(1,2,3), Array(4,5,6)), where each inner Seq represents a row of
    * data. Column names within the rows are named after their array indexes (0 based). So, for example, to encode this data
    * you'd write:
    *
    *   encodeX("0", Quant).
    *   encodeY("1", Quant).
    *   encodeSize("2", Ord).
    *
    * @param values A Seq[Seq[Any]] where each inner sequence is treated as a row of data.
    */
  def withSeqValues(values: Seq[Seq[Any]])(implicit vt: ValueTransformer): T = {
    val v = values.map(_.zipWithIndex.map { case(v,i) => (i.toString,v) }.toMap)
    withData(v)
  }

  /**
    * Specifies data as a Seq of case-classes. Each field within the case class becomes a row within the data. And each
    * column is named after the field names within the case class.
    * @param values: Expects an array of case classes, but no way to enforce this. Uses reflection to pull out
    * fields.
    */
  def withCaseClasses(values: Seq[Product])(implicit vt: ValueTransformer): T = {
    val v = values.map(FieldExtractor.extractFields)
    withData(v)
  }

}

