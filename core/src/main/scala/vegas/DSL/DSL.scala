package vegas.DSL

import java.net.URI

import monocle.macros.GenLens
import monocle.Prism
import vegas.spec._

/**
  * @author Aish Fenton.
  */
object Vegas {

  def apply(description: String = "") = SpecBuilder(Spec(description=Some(description)))

}

/**
  * @author Aish Fenton.
  */
case class SpecBuilder(spec: Spec) extends SpecDSL with EncoderDSL with DataDSL with TransformDSL

trait SpecDSL {
  self: SpecBuilder =>

  protected[this] val _spec = GenLens[SpecBuilder](_.spec)

  private val _mark = GenLens[Spec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(Some(mark))(this)
  }

}

trait TransformDSL {
  self: SpecBuilder =>

  private val _transform = GenLens[Spec](_.transform)

  private val _calculate = GenLens[Transform](_.calculate)
  private val _filterNull = GenLens[Transform](_.filterNull)
  private val _filter = GenLens[Transform](_.filter)

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

trait DataDSL extends FieldExtractor {
  self: SpecBuilder =>

  private val _data = GenLens[Spec](_.data)

  def withData(values: Seq[Map[String, Any]]): SpecBuilder = {
    val data = Data(Option(values))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withData(url: String, formatType: FormatType = JSON): SpecBuilder = {
    val data = Data(None, Option(new URI(url)), Option(formatType))
    (_spec composeLens _data).set(Some(data))(this)
  }

  def withData(values: Array[Seq[AnyVal]]): SpecBuilder = {
    val v = values.map(_.zipWithIndex.map { case(v,i) => (i.toString,v) }.toMap)
    withData(values)
  }

  /**
    * Wires data structure of Array of Case-Classes to chart
    * @param values: Really expects an array of case classes, but no way to enforce this. Uses reflection to pull out
    * fields.
    */
  def extractData(values: Seq[Product]): SpecBuilder = {
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
