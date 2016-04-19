package vegas.DSL

import java.net.URL

import monocle.macros.GenLens
import monocle.Prism
import vegas.spec._

/**
  * @author Aish Fenton.
  */
object Vegas {

  def apply(description: String) = SpecBuilder(Spec(description=Some(description)))

  // Util used for composing Lens with options (and returning a default)
  def _orElse[T](fn: => T) = Prism[Option[T], T]{ o:Option[T] => o.orElse(Some(fn)) }(Some.apply)

}



/**
  * @author Aish Fenton.
  */
case class SpecBuilder(spec: Spec) {

  // Util used for composing Lens with options (and returning a default)
  import Vegas._orElse

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

  // Use reflection to grab values from value objects within Array
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

