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

  val BinPlot =
    Vegas("Plot with binning").
      withDataURL(Movies).
      mark(Point).
      encodeY("IMDB_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeX("Rotten_Tomatoes_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeSize(aggregate=Count, field="*", dataType=Quantitative)

  val plots: List[SpecBuilder] = ValuePlot :: IQRPlot :: BinPlot :: Nil

}

