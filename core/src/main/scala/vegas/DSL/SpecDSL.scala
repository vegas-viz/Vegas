package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.Spec._
import io.circe.Json
import io.circe.syntax._

object Vegas {

  /**
    * Creates a Builder DSL for typical (non-layered) specs
    */
  def apply(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg, width: OptArg[Double] = NoArg,
            height: OptArg[Double] = NoArg) = ExtendedUnitSpecBuilder(ExtendedUnitSpec(
    width=width,
    height=height,
    name=name,
    description=description,
    mark=MarkEnums.Circle
  ))

  /**
    * Creates a Builder DSL for LayeredSpecs
    */
  def layered(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg, width: OptArg[Double] = NoArg,
              height: OptArg[Double] = NoArg) = LayerSpecBuilder(LayerSpec(
    width=width,
    height=height,
    name=name,
    description=description,
    layers = Nil
  ))


}

object Layer {
  def apply(description: OptArg[String] = NoArg, name: OptArg[String] = NoArg, width: OptArg[Double] = NoArg,
            height: OptArg[Double] = NoArg) = UnitSpecBuilder(UnitSpec(
    width=width,
    height=height,
    name=name,
    description=description,
    mark=MarkEnums.Circle
  ))
}

/**
  * Builds a typical (non-layered) spec.
  */
case class ExtendedUnitSpecBuilder(spec: ExtendedUnitSpec) extends SpecBuilder with ExtendedUnitSpecDSL  {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}

/**
  * Builds a LayeredSpec
  */
case class LayerSpecBuilder(spec: LayerSpec) extends SpecBuilder with LayerSpecDSL {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}

/**
  * Each layer's sub-spec
  */
case class UnitSpecBuilder(spec: UnitSpec) extends SpecBuilder with UnitSpecDSL {
  import vegas.spec.Spec.Implicits._

  def toJson = vegas.spec.toJson(spec)
  def asCirceJson = spec.asJson
}


trait SpecBuilder {

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

trait LayerSpecDSL extends DataDSL[LayerSpecBuilder] with TransformDSL[LayerSpecBuilder] with ConfigDSL[LayerSpecBuilder] {
  self: LayerSpecBuilder =>

  protected[this] val _spec = GenLens[LayerSpecBuilder](_.spec)
  protected[this] val _layers = GenLens[LayerSpec](_.layers)
  protected[this] val _data = _spec composeLens GenLens[LayerSpec](_.data)
  protected[this] val _transform = _spec composeLens GenLens[LayerSpec](_.transform)
  protected[this] val _config = _spec composeLens GenLens[LayerSpec](_.config)

  def withLayers(layers: UnitSpecBuilder*) = {
    val layerSpecs = layers.map(_.spec).toList
    (_spec composeLens _layers).set(layerSpecs)(this)
  }

}

trait UnitSpecDSL extends UnitEncoderDSL[UnitSpecBuilder] with DataDSL[UnitSpecBuilder] with TransformDSL[UnitSpecBuilder]
  with ConfigDSL[UnitSpecBuilder] {
  self: UnitSpecBuilder =>

  protected[this] val _spec = GenLens[UnitSpecBuilder](_.spec)
  protected[this] def _encoding = _spec composeLens GenLens[UnitSpec](_.encoding)
  protected[this] val _data = _spec composeLens GenLens[UnitSpec](_.data)
  protected[this] val _transform = _spec composeLens GenLens[UnitSpec](_.transform)
  protected[this] val _config = _spec composeLens GenLens[UnitSpec](_.config)

  private val _mark = GenLens[UnitSpec](_.mark)

  def mark(mark: Mark) = {
    (_spec composeLens _mark).set(mark)(this)
  }

}

