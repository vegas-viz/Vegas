package vegas.DSL

import monocle.macros.GenLens
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


