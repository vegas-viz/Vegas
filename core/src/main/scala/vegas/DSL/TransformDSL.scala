package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.Spec2._

trait TransformDSL {
  self: SpecBuilder =>

  private val _transform = GenLens[ExtendedUnitSpec](_.transform)

  private val _calculate = GenLens[Transform](_.calculate)
  private val _filterInvalid = GenLens[Transform](_.filterInvalid)
  private val _filter = GenLens[Transform](_.filter)

  def addTransformCalculation(field: String, expr: String) = {
    val formula = Formula(field, expr)
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _calculate
      composePrism _orElse(Nil)).modify((xs: List[Formula]) => xs :+ formula)(this)
  }

  def transformFilter(filter: String) = {
    val filterU = Transform.FilterString(filter)
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _filter).set(Some(filterU))(this)
  }

  def transformFilterInvalid(filterInvalid: Boolean = true) = {
    (_spec composeLens _transform composePrism _orElse(Transform()) composeLens _filterInvalid).set(Some(filterInvalid))(this)
  }

}
