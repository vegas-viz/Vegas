package vegas

import vegas.spec._

/**
  * @author Aish Fenton.
  */
trait Fixtures {

  def rawData = new {
    val popData = Seq( Map("population" -> 318000000, "country" -> "USA"), Map("population" -> 64000000, "country" -> "UK") )
  }

  def specs = new {
    val popBarSpec = Spec(
      description = Some("Country Pop"),
      data = Some(Data(
        values = Some(rawData.popData)
      )),
      transform = Some(Transform(
        calculate = Some(Seq(Formula(
          field = "pop_millions",
          expr = "datum.population / 1000000"
        )))
      )),
      encoding = Some(Encoding(
        x = Some(ChannelDef(
          field = Some("pop_millions"),
          dataType = Some(QUANTITATIVE)
        )),
        y = Some(ChannelDef(
          field = Some("country"),
          dataType = Some(NOMINAL)
        ))
      )),
      mark = Some(BAR)
    )
  }

}
