package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.Spec2._

object Vegas {

  def apply(description: OptArg[String] = NoArg) = SpecBuilder(ExtendedUnitSpec(
    description=description,
    mark=MarkEnums.Circle
  ))

}

case class SpecBuilder(spec: ExtendedUnitSpec) extends SpecDSL with EncoderDSL with DataDSL with TransformDSL with ConfigDSL {
  def toJson = vegas.spec.toJson(spec)
}

trait SpecDSL {
  self: SpecBuilder =>

  protected[this] val _spec = GenLens[SpecBuilder](_.spec)
  private val _mark = GenLens[ExtendedUnitSpec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(mark)(this)
  }

}


