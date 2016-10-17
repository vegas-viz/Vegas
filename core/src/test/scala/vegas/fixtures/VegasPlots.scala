package vegas.fixtures

import vegas.DSL.SpecBuilder
import vegas._
import vegas.data.External._

object VegasPlots {

  val ValuePlot =
    Vegas("Plot with hard-coded size value").
      withURL(Cars).
      mark(Circle).
      encodeY("Horsepower", Quantitative).
      encodeX("Miles_per_Gallon", Quantitative).
      encodeSize(value=201L)

  val IQRPlot =
    Vegas.layered("Plots both mean and IQR as a background layer").
      withURL(Population).
      withLayers(
        Layer().
          mark(Line).
          encodeX("age", Ordinal).
          encodeY("people", aggregate=AggOps.Mean),
        Layer().
          mark(Area).
          encodeX("age", Ordinal).
          encodeY("people", aggregate=AggOps.Q1).
          encodeY2("people", aggregate=AggOps.Q3)
      )

  val LegendPlot =
    Vegas("Plot with legend on the left and a different title ").
      withURL(Cars).
      mark(Point).
      encodeY("Horsepower", Quantitative).
      encodeX("Miles_per_Gallon", Quantitative).
      encodeColor(field="Origin", dataType=Nominal, legend=Legend(orient = "left", title="Place of Origin" )).
      encodeShape(field="Origin", dataType=Nominal, legend=Legend(orient = "left", title="Place of Origin",
        titleColor="red"))

  val BinnedPlot =
    Vegas("Plot to show Binning options").
      withURL(Movies).
      mark(Bar).
      encodeX("IMDB_Rating", Quantitative, bin=Bin(step=2.0, maxbins=3.0)).
      encodeY(field="*", Quantitative, aggregate=AggOps.Count)

  val BinnedPlotWithSort =
    Vegas("Plot to show Binning options").
      withURL(Movies).
      mark(Bar).
      encodeX("Worldwide_Gross", Quant, bin=Bin(maxbins=20.0), sortOrder=SortOrder.Desc).
      encodeY(field="*", Quant, aggregate=AggOps.Count)

  val ColoredTextScatterPlot =
    Vegas("Plot to show usage of encodeText").
    withURL(Cars).addTransformCalculation("OriginInitial", "datum.Origin[0]").
    mark(Text).
    encodeX("Horsepower", Quantitative).
    encodeY("Miles_per_Gallon", Quantitative).
    encodeColor(field="Origin", dataType= Nominal).
    encodeText(field="OriginInitial", dataType= Nominal)

  val plots: List[SpecBuilder] = ValuePlot :: IQRPlot :: LegendPlot :: BinnedPlot :: BinnedPlotWithSort :: ColoredTextScatterPlot ::Nil

}

