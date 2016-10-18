package vegas.DSL

import monocle.Lens
import monocle.macros.GenLens
import vegas.spec.Spec._

trait TransformDSL[T] {
  self: T =>

  protected[this] def _transform: Lens[T, Option[Transform]]

  private val _calculate = GenLens[Transform](_.calculate)
  private val _filterInvalid = GenLens[Transform](_.filterInvalid)
  private val _filter = GenLens[Transform](_.filter)

  def addTransformCalculation(field: String, expr: String): T = {
    val formula = Formula(field, expr)
    (_transform composePrism _orElse(Transform()) composeLens _calculate
      composePrism _orElse(Nil)).modify((xs: List[Formula]) => xs :+ formula)(this)
  }

  def addTransform(field: String, expr: String) = addTransformCalculation(field, expr)

  def transformFilter(filter: String): T = {
    val filterU = Transform.FilterString(filter)
    (_transform composePrism _orElse(Transform()) composeLens _filter).set(Some(filterU))(this)
  }

  def filter(filter: String) = transformFilter(filter)

  def transformFilterInvalid(filterInvalid: Boolean = true) = {
    (_transform composePrism _orElse(Transform()) composeLens _filterInvalid).set(Some(filterInvalid))(this)
  }

  def filterInvalid(filterInvalid: Boolean) = transformFilterInvalid(filterInvalid)

}
