package vegas.DSL

import monocle.macros.GenLens
import vegas.spec._
import java.net.URI

/**
  * @author Aish Fenton
  */
trait DataDSL extends FieldExtractor {
  self: SpecBuilder =>

  private val _data = GenLens[Spec](_.data)

  def withData(values: Seq[Map[String, Any]]): SpecBuilder = {
    val data = Data(Option(values))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withDataURL(url: String, formatType: FormatType = JSON): SpecBuilder = {
    val data = Data(None, Option(new URI(url)), Option(formatType))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withDataSeq(values: Seq[Any]): SpecBuilder = {
    val data = values.zipWithIndex.map { case(y, i) => Map("x" -> i, "y" -> y) }
    withData(data)
  }

  def withDataXY(values: Seq[(Any, Any)]): SpecBuilder = {
    val data = values.map { case(x, y) => Map("x" -> x, "y" -> y) }
    withData(data)
  }

  def withDataRow(values: Seq[Seq[Any]]): SpecBuilder = {
    val v = values.map(_.zipWithIndex.map { case(v,i) => (i.toString,v) }.toMap)
    withData(v)
  }

  /**
    * Wires data structure of Array of Case-Classes to chart
    * @param values: Expects an array of case classes, but no way to enforce this. Uses reflection to pull out
    * fields.
    */
  def withReflectData(values: Seq[Product]): SpecBuilder = {
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


