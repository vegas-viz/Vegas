package vegas.DSL

import vegas.BaseSpec
import vegas.spec.{ Config, Cell }

/**
  * @author Aish Fenton.
  */
class ConfigDSLSpec extends BaseSpec {

  "ConfigDSL Trait" should "set cell config" in {
    val specBuilder = Vegas()
      .configCell(width=10)

    specBuilder.spec.config.get.cell.get should equal(Cell(
      width = Some(10)
    ))
  }

}

