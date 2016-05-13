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

  def configCell(width: OptArg[Int] = NoArg, height: OptArg[Int] = NoArg): SpecBuilder = {
    val cell = Cell(width, height)
    (_spec composeLens _config composePrism _orElse(Config()) composeLens _cell).set(Some(cell))(this)
  }


}
