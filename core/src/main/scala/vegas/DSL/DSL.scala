package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.Spec._
import io.circe.syntax._

object Vegas {

  def apply(description: OptArg[String] = NoArg) = SpecBuilder(ExtendedUnitSpec(
    description=description,
    mark=MarkEnums.Circle
  ))

}

case class SpecBuilder(spec: ExtendedUnitSpec) extends SpecDSL with EncoderDSL with DataDSL with TransformDSL with ConfigDSL {

  /**
    * Returns a Json string representation of this vega-lite spec
    */
  def toJson = vegas.spec.toJson(spec)

  /**
    * Returns a Circe Json object that represents the spec. Also see [[toJson]]
    */
  def asCirceJson = {
    import vegas.spec.Spec.Implicits._
    spec.asJson
  }

}

trait SpecDSL {
  self: SpecBuilder =>

  protected[this] val _spec = GenLens[SpecBuilder](_.spec)
  private val _mark = GenLens[ExtendedUnitSpec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(mark)(this)
  }

}


