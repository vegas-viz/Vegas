package vegas.DSL

import monocle.macros.GenLens
import monocle.Lens
import vegas.spec.Spec._
import java.net.URI

/**
  * @tparam T the base builder type. Needs to be generic since this can be mixed into different places
  */
trait DataDSL[T] extends FieldExtractor {
  self: T =>

  protected[this] def _data: Lens[T, Option[Data]]

  private val _values = GenLens[Data](_.values)

  def withData(values: Seq[Map[String, Any]]): T = {
    val data = Data(
      values = Some(values.toList.map(Data.Values(_)))
    )

    _data.set(Some(data))(this)
  }

  def withDataURL(url: String, formatType: OptArg[DataFormatType] = NoArg): T = {
    val data = Data(
      url = Some(url),
      format = formatType.map( t => DataFormat(`type`= Some(t)))
    )
    _data.set(Some(data))(this)
  }

  def withDataSeq(values: Seq[Any]): T = {
    val data = values.zipWithIndex.map { case(y, i) => Map("x" -> i, "y" -> y) }
    withData(data)
  }

  def withDataXY(values: Seq[(Any, Any)]): T = {
    val data = values.map { case(x, y) => Map("x" -> x, "y" -> y) }
    withData(data)
  }

  def withDataRow(values: Seq[Seq[Any]]): T = {
    val v = values.map(_.zipWithIndex.map { case(v,i) => (i.toString,v) }.toMap)
    withData(v)
  }

  /**
    * Wires data structure of Array of Case-Classes to chart
    * @param values: Expects an array of case classes, but no way to enforce this. Uses reflection to pull out
    * fields.
    */
  def withReflectData(values: Seq[Product]): T = {
    val v = values.map(extractFields)
    withData(v)
  }

}

trait FieldExtractor {

  def extractFields(cc: Product): Map[String, Any] = {
    import scala.reflect.runtime.universe._

    val mirror = runtimeMirror(cc.getClass.getClassLoader)
    val tipe = mirror.reflect(cc).symbol.asType

    val fields = tipe.typeSignature.members.collect {
      case m: MethodSymbol if m.isCaseAccessor => m
    }.toList

    fields.map { ms =>
      ms.name.toString -> mirror.reflect(cc).reflectMethod(ms)()
    }.toMap
  }

}


