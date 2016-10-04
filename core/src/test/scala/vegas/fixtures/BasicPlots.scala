package vegas.fixtures

import vegas._
import vegas.data.External._
import vegas.DSL.SpecBuilder

object BasicPlots {

  val SimpleBarChart =
    Vegas("A simple bar chart with embedded data.").
      withData(Seq(
        Map("a" -> "A", "b" -> 28), Map("a" -> "B", "b" -> 55), Map("a" -> "C", "b" -> 43),
        Map("a" -> "D", "b" -> 91), Map("a" -> "E", "b" -> 81), Map("a" -> "F", "b" -> 53),
        Map("a" -> "G", "b" -> 19), Map("a" -> "H", "b" -> 87), Map("a" -> "I", "b" -> 52)
      )).
      encodeX("a", Ordinal).
      encodeY("b", Quantitative).
      mark(Bar)

  val AggregateBarChart =
    Vegas("A bar chart showing the US population distribution of age groups in 2000.").
      withDataURL(Population).
      mark(Bar).
      transformFilter("datum.year == 2000").
      encodeY("age", Ordinal, scale=Scale(bandSize=17)).
      encodeX("people", Quantitative, aggregate=Sum, axis=Axis(title="population"))

  val GroupedBarChart =
    Vegas("Grouped plot").
      withDataURL(Population).
      mark(Bar).
      addTransformCalculation("gender", """datum.sex == 2 ? "Female" : "Male"""").
      transformFilter("datum.year == 2000").
      encodeColumn("age", Ordinal, scale=Scale(padding=4.0), axis=Axis(orient=Bottom, axisWidth=1.0, offset= -8.0)).
      encodeY("people", Quantitative, aggregate=Sum, axis=Axis(title="population", grid=false)).
      encodeX("gender", Nominal, scale=Scale(bandSize = 6.0), hideAxis=true).
      encodeColor("gender", Nominal, scale=Scale(rangeNominals=List("#EA98D2", "#659CCA")))

  val BinnedChart =
    Vegas("A trellis scatterplot showing Horsepower and Miles per gallons, faceted by binned values of Acceleration.").
      withDataURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeRow("Acceleration", Quantitative, enableBin=true)

  val ScatterBinnedPlot =
    Vegas().
      withDataURL(Movies).
      mark(Point).
      encodeX("IMDB_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeY("Rotten_Tomatoes_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeSize(aggregate=Count, field="*", dataType=Quantitative)

  val ScatterColorPlot =
    Vegas().
      withDataURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeColor(field="Origin", dataType=Nominal)

  val ScatterBinnedColorPlot =
    Vegas("A scatterplot showing horsepower and miles per gallons with binned acceleration on color.").
      withDataURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeColor(field="Acceleration", dataType=Quantitative, bin=Bin(maxbins=5.0))

  val StackedAreaBinnedPlot =
    Vegas().
      withDataURL(Cars).
      mark(Area).
      encodeX("Acceleration", Quantitative, bin=Bin()).
      encodeY("Horsepower", Quantitative, aggregate=Mean, enableBin=false).
      encodeColor(field="Cylinders", dataType=Nominal)

  val plots: List[SpecBuilder] = SimpleBarChart :: AggregateBarChart :: GroupedBarChart :: BinnedChart ::
    ScatterBinnedPlot :: ScatterColorPlot :: ScatterBinnedColorPlot :: StackedAreaBinnedPlot :: Nil

}
