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
  val LegendPlot=
    Vegas("Plot with legend on the left and a different title ").
      withDataURL(Cars).
      mark(Point).
      encodeY("Horsepower", Quantitative).
      encodeX("Miles_per_Gallon", Quantitative).
      encodeColor(field="Origin",dataType=Nominal, legend= Legend(orient = "left", title="Place of Origin" )).
      encodeShape(field="Origin",dataType=Nominal, legend= Legend(orient = "left", title="Place of Origin" ,
        titleColor="red"))


  val plots: List[SpecBuilder] = ValuePlot :: IQRPlot :: LegendPlot :: Nil

}

