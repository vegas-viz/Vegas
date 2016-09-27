package vegas.DSL

import monocle.Lens
import monocle.macros.GenLens
import vegas.spec.Spec._

/**
  * @author Aish Fenton.
  */
trait ConfigDSL[T] extends FieldExtractor {
  self: T =>

  protected[this] def _config: Lens[T, Option[Config]]
  private val _cell = GenLens[Config](_.cell)

  def configCell(width: OptArg[Double] = NoArg, height: OptArg[Double] = NoArg, fill: OptArg[String] = NoArg,
                 fillOpacity: OptArg[Double] = NoArg, stroke: OptArg[String] = NoArg,
                 strokeOpacity: OptArg[Double] = NoArg, strokeWidth: OptArg[Double] = NoArg,
                 strokeDash: OptArg[List[Double]] = NoArg, strokeDashOffset: OptArg[Double] = NoArg) = {

    val cell = CellConfig(
      width=width, height=height, fill=fill, fillOpacity=fillOpacity, stroke=stroke,
      strokeOpacity=strokeOpacity, strokeWidth=strokeWidth, strokeDash=strokeDash, strokeDashOffset=strokeDashOffset
    )

    (_config composePrism _orElse(Config()) composeLens _cell).set(Some(cell))(this)
  }

}


