package vegas.fixtures

import vegas.DSL.SpecBuilder
import vegas._
import vegas.data.External._

object VegasPlots {

  val ValuePlot =
    Vegas("Plot with hard-coded size value").
      withDataURL(Cars).
      mark(Circle).
      encodeY("Horsepower", Quantitative).
      encodeX("Miles_per_Gallon", Quantitative).
      encodeSize(value=201L)

  val IQRPlot =
    Vegas.layered("Plots both mean and IQR as a background layer").
      withDataURL(Population).
      withLayers(
        Layer().
          mark(Line).
          encodeX("age", Ordinal).
          encodeY("people", aggregate=Mean),
        Layer().
          mark(Area).
          encodeX("age", Ordinal).
          encodeY("people", aggregate=Q1).
          encodeY2("people", aggregate=Q3)
      )

  val plots: List[SpecBuilder] = ValuePlot :: IQRPlot :: Nil

}

