package vegas.DSL

import monocle.macros.GenLens
import vegas.spec.{Config, Cell, Spec}

/**
  * @author Aish Fenton.
  */
trait ConfigDSL extends FieldExtractor {
  self: SpecBuilder =>

  private val _config = GenLens[Spec](_.config)
  private val _cell = GenLens[Config](_.cell)

  def configCell(width: OptArg[Int] = NoArg, height: OptArg[Int] = NoArg, fill: OptArg[String] = NoArg,
                 fillOpacity: OptArg[Double] = NoArg, stroke: OptArg[String] = NoArg,
                 strokeOpacity: OptArg[Double] = NoArg, strokeWidth: OptArg[Int] = NoArg,
                 strokeDash: OptArg[Seq[Int]] = NoArg, strokeDashOffset: OptArg[Int] = NoArg) = {

    val cell = Cell(width, height, fill, fillOpacity, stroke, strokeOpacity, strokeWidth, strokeDash, strokeDashOffset)

    (_spec composeLens _config composePrism _orElse(Config()) composeLens _cell).set(Some(cell))(this)
  }

}


