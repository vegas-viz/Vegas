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

  def withData(values: Map[String, Any]*): SpecBuilder = {
    val data = Data(Option(values))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withData(url: String, formatType: FormatType = JSON): SpecBuilder = {
    val data = Data(None, Option(new URI(url)), Option(formatType))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withRowData(values: Seq[Any]*): SpecBuilder = {
    val v = values.map(_.zipWithIndex.map { case(v,i) => (i.toString,v) }.toMap)
    withData(v:  _*)
  }

  /**
    * Wires data structure of Array of Case-Classes to chart
    * @param values: Expects an array of case classes, but no way to enforce this. Uses reflection to pull out
    * fields.
    */
  def withReflectData(values: Product*): SpecBuilder = {
    val v = values.map(extractFields)
    withData(v: _*)
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


