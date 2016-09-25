package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.Spec._
import io.circe.Json
import io.circe.syntax._

object Vegas {

  def layered(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg) = LayerSpecBuilder(LayerSpec(
    name=name,
    description=description,
    layers = Nil
  ))

  def apply(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg) = ExtendedUnitSpecBuilder(ExtendedUnitSpec(
    name=name,
    description=description,
    mark=MarkEnums.Circle
  ))

}

/**
  * Builds a LayeredSpec
  */
case class LayerSpecBuilder(spec: LayerSpec) extends LayerSpecDSL with BuilderOps {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}

/**
  * Each layer's sub-spec
  */
case class UnitSpecBuilder(spec: UnitSpec) extends UnitSpecDSL with BuilderOps {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}

/**
  * Builds a typical (non-layered) spec.
  */
case class ExtendedUnitSpecBuilder(spec: ExtendedUnitSpec) extends ExtendedUnitSpecDSL with BuilderOps {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}


trait BuilderOps {

  /**
    * Returns a Json string representation of this vega-lite spec
    */
  def toJson: String

  /**
    * Returns a Circe Json object that represents the spec. Also see [[toJson]]
    */
  def asCirceJson: Json

}

trait ExtendedUnitSpecDSL extends EncoderDSL[ExtendedUnitSpecBuilder] with DataDSL[ExtendedUnitSpecBuilder]
  with TransformDSL[ExtendedUnitSpecBuilder] with ConfigDSL[ExtendedUnitSpecBuilder] {

  self: ExtendedUnitSpecBuilder =>

  protected[this] val _spec = GenLens[ExtendedUnitSpecBuilder](_.spec)
  protected[this] def _encoding = _spec composeLens GenLens[ExtendedUnitSpec](_.encoding)
  protected[this] val _data = _spec composeLens GenLens[ExtendedUnitSpec](_.data)
  protected[this] val _transform = _spec composeLens GenLens[ExtendedUnitSpec](_.transform)
  protected[this] val _config = _spec composeLens GenLens[ExtendedUnitSpec](_.config)

  private val _mark = GenLens[ExtendedUnitSpec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(mark)(this)
  }

}

trait LayerSpecDSL {
  self: LayerSpecBuilder =>

  protected[this] val _layers = GenLens[LayerSpec](_.layers)

  def addLayer(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg) = {
    UnitSpecBuilder(UnitSpec(description=description, name=name, mark=MarkEnums.Circle))
  }

}

trait UnitSpecDSL extends DataDSL[UnitSpecBuilder] with TransformDSL[UnitSpecBuilder] with ConfigDSL[UnitSpecBuilder] {
  self: UnitSpecBuilder =>

  protected[this] val _spec = GenLens[UnitSpecBuilder](_.spec)
  protected[this] val _data = _spec composeLens GenLens[UnitSpec](_.data)
  protected[this] val _transform = _spec composeLens GenLens[UnitSpec](_.transform)
  protected[this] val _config = _spec composeLens GenLens[UnitSpec](_.config)

  private val _mark = GenLens[UnitSpec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(mark)(this)
  }

}

