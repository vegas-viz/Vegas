package vegas.DSL

import vegas.BaseSpec
import vegas.spec.{ Config, Cell }

/**
  * @author Aish Fenton.
  */
class ConfigDSLSpec extends BaseSpec {

  "ConfigDSL Trait" should "set cell config" in {
    val specBuilder = Vegas()
      .configCell(width=1, height=2, fill="#ff00ff", fillOpacity=0.5, stroke="#0000ff",
        strokeOpacity=0.2, strokeWidth=1, strokeDash=Seq(1,2,3), strokeDashOffset=10)

    specBuilder.spec.config.get.cell.get should equal(Cell(
      width = Some(1),
      height = Some(2),
      fill = Some("#ff00ff"),
      fillOpacity = Some(0.5),
      stroke = Some("#0000ff"),
      strokeOpacity = Some(0.2),
      strokeWidth = Some(1),
      strokeDash = Some(Seq(1,2,3)),
      strokeDashOffset = Some(10)
    ))
  }

}

