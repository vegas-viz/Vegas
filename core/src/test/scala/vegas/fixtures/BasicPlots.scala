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
      withURL(Population).
      mark(Bar).
      filter("datum.year == 2000").
      encodeY("age", Ordinal, scale=Scale(rangeStep = 17)).
      encodeX("people", Quantitative, aggregate=AggOps.Sum, axis=Axis(title="population"))

  val GroupedBarChart =
    Vegas().
      withURL(Population).
      mark(Bar).
      addTransformCalculation("gender", """datum.sex == 2 ? "Female" : "Male"""").
      filter("datum.year == 2000").
      encodeColumn("age", Ord, scale=Scale(padding=4.0), axis=Axis(orient=Orient.Bottom, axisWidth=1.0, offset= -8.0)).
      encodeY("people", Quantitative, aggregate=AggOps.Sum, axis=Axis(title="population", grid=false)).
      encodeX("gender", Nominal, scale=Scale(rangeStep = 6.0), hideAxis=true).
      encodeColor("gender", Nominal, scale=Scale(rangeNominals=List("#EA98D2", "#659CCA"))).
      configFacet(cell=CellConfig(strokeWidth = 0))

  val AreaChart =
    Vegas(width=300, height=200).
      withURL(Unemployment).
      mark(Area).
      encodeX("date", Temp, timeUnit=TimeUnit.Yearmonth, axis=Axis(format="%Y")).
      encodeY("count", Quantitative, aggregate=AggOps.Sum, axis=Axis(title="count"))

  val NormalizedStackedBarChart =
    Vegas().
      withURL(Population).
      filter("datum.year == 2000").
      addTransform("gender", "datum.sex == 2 ? \"Female\" : \"Male\"").
      mark(Bar).
      encodeY("people", Quant, AggOps.Sum, axis=Axis(title="population")).
      encodeX("age", Ord, scale=Scale(rangeStep = 17)).
      encodeColor("gender", Nominal, scale=Scale(rangeNominals=List("#EA98D2", "#659CCA"))).
      configMark(stacked=StackOffset.Normalize)

  val BinnedChart =
    Vegas("A trellis scatterplot showing Horsepower and Miles per gallons, faceted by binned values of Acceleration.").
      withURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeRow("Acceleration", Quantitative, enableBin=true)

  val ScatterBinnedPlot =
    Vegas().
      withURL(Movies).
      mark(Point).
      encodeX("IMDB_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeY("Rotten_Tomatoes_Rating", Quantitative, bin=Bin(maxbins=10.0)).
      encodeSize(aggregate=AggOps.Count, field="*", dataType=Quantitative)

  val ScatterColorPlot =
    Vegas().
      withURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeColor(field="Origin", dataType=Nominal)

  val ScatterBinnedColorPlot =
    Vegas("A scatterplot showing horsepower and miles per gallons with binned acceleration on color.").
      withURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quantitative).
      encodeY("Miles_per_Gallon", Quantitative).
      encodeColor(field="Acceleration", dataType=Quantitative, bin=Bin(maxbins=5.0))

  val SortColorPlot =
    Vegas(name="trellis_barley", description="The Trellis display by Becker et al. helped establish small multiples as a “powerful mechanism for understanding interactions in studies of how a response depends on explanatory variables”. Here we reproduce a trellis of Barley yields from the 1930s, complete with main-effects ordering to facilitate comparison.").
      withURL(Barley).
      mark(Point).
      encodeRow("site", Ordinal).
      encodeX("yield", Quantitative, aggregate=AggOps.Median, scale=Scale(zero=false)).
      encodeY(
        "variety", Ordinal,
        sortField=Sort("yield", AggOps.Median, SortOrder.Descending),
        scale=Scale(rangeStep=12.0)).
      encodeColor(field="year", dataType=Nominal)

  val PointShapeCustom =
    Vegas("A scatterplot with custom star shapes.").
      withURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quant).
      encodeY("Miles_per_Gallon", Quant).
      encodeColor("Cylinders", Nom).
      encodeSize("Weight_in_lbs", Quant).
      encodeShape(value="M0,0.2L0.2351,0.3236 0.1902,0.0618 0.3804,-0.1236 0.1175,-0.1618 0,-0.4 -0.1175,-0.1618 -0.3804,-0.1236 -0.1902,0.0618 -0.2351,0.3236 0,0.2Z")

  val ScatterAggregateDetail =
    Vegas("A scatterplot showing average horsepower and displacement for cars from different origins.").
      withURL(Cars).
      mark(Point).
      encodeX("Horsepower", Quant, AggOps.Mean).
      encodeY("Displacement", Quant, AggOps.Mean).
      encodeDetail("Origin")

  val LineDetail =
    Vegas("Stock prices of 5 Tech Companies Over Time.").
      withURL(Stocks, formatType = DataFormat.Csv).
      mark(Line).
      encodeX("date", Temp).
      encodeY("price", Quant).
      encodeDetailFields(Field(field="symbol", dataType=Nominal))

  val GithubPunchCard =
    Vegas().
      withURL(Github).
      mark(Circle).
      encodeX("time", Ordinal, timeUnit = TimeUnit.Hours).
      encodeY("time", Ordinal, timeUnit = TimeUnit.Day).
      encodeSize("count", Quantitative, aggregate = AggOps.Sum)

  val TrellisAnscombe =
    Vegas("Anscombe's Quartet").
      withURL(Anscombe).
      mark(Circle).
      encodeX("X", Quantitative, scale = Scale(zero = false)).
      encodeY("Y", Quantitative, scale = Scale(zero = false)).
      encodeColumn("Series", Nominal).
      encodeOpacity(value = 1)

  val StackedAreaChart =
    Vegas("Area chart showing weight of cars over time.").
      withURL(Unemployment).
      mark(Area).
      encodeX(
        "date", Temporal, timeUnit = TimeUnit.Yearmonth,
        axis = Axis(axisWidth = 0, format = "%Y", labelAngle = 0),
        scale = Scale(nice = spec.Spec.NiceTimeEnums.Month)
      ).
      encodeY("count", Quantitative, aggregate = AggOps.Sum).
      encodeColor("series", Nominal, scale = Scale(rangePreset = Category20b)).
      configCell(width = 300, height = 200)

  val NormalizedStackedAreaChart =
    Vegas().
      withURL(Unemployment).
      mark(Area).
      encodeX(
        "date", Temporal, timeUnit = TimeUnit.Yearmonth,
        axis = Axis(axisWidth=0, format="%Y", labelAngle=0),
        scale = Scale(nice = spec.Spec.NiceTimeEnums.Month)
      ).
      encodeY("count", Quantitative, aggregate = AggOps.Sum, hideAxis = Some(true)).
      encodeColor("series", Nominal, scale = Scale(rangePreset = Category20b)).
      configCell(width = 300, height = 200).
      configMark(stacked = StackOffset.Normalize)

  val Streamgraph =
    Vegas().
      withURL(Unemployment).
      mark(Area).
      encodeX(
        "date", Temporal, timeUnit = TimeUnit.Yearmonth,
        axis = Axis(axisWidth = 0, format = "%Y", labelAngle = 0, tickSize = Some(0.0)),
        scale = Scale(nice = spec.Spec.NiceTimeEnums.Month)
      ).
      encodeY("count", Quantitative, aggregate = AggOps.Sum, hideAxis = Some(true)).
      encodeColor("series", Nominal, scale = Scale(rangePreset = Category20b)).
      configCell(width = 300, height = 200).
      configMark(stacked = StackOffset.Center)

  val StackedBarWeather =
    Vegas().
      withURL(SeattleWeather).
      mark(Bar).
      encodeX("date", Ordinal, timeUnit = TimeUnit.Month, axis = Axis(title = "Month of the year")).
      encodeY(dataType = Quantitative, aggregate = AggOps.Count).
      encodeColor("weather", Nominal, scale = Scale(
        domainNominals = List("sun", "fog", "drizzle", "rain", "snow"),
        rangeNominals = List("#e7ba52", "#c7c7c7", "#aec7e8", "#1f77b4", "#9467bd")),
        legend = Legend(title = "Weather type"))

  val StripPlot =
    Vegas("Shows the relationship between horsepower and the numbver of cylinders using tick marks.").
      withURL(Cars).
      mark(Tick).
      encodeX("Horsepower", Quantitative).
      encodeY("Cylinders", Ordinal)

  // Names (ex. bar, bar_aggregate, etc.) are corresponding to filenames
  //  of `/core/src/test/resources/example-specs/*.vl.json`
  val plotsWithNames: List[(String, SpecBuilder)] = List(
    "bar" -> SimpleBarChart,
    "bar_aggregate" -> AggregateBarChart,
    "bar_grouped" -> GroupedBarChart,
    "area" -> AreaChart,
    "stacked_bar_normalize" -> NormalizedStackedBarChart,
    "scatter_binned" -> ScatterBinnedPlot,
    "scatter_color" -> ScatterColorPlot,
    "scatter_binned_color" -> ScatterBinnedColorPlot,
    "trellis_barley" -> SortColorPlot,
    "trellis_scatter_binned_row" -> BinnedChart,
    "point_shape_custom" -> PointShapeCustom,
    "line_detail" -> LineDetail,
    "circle_github_punchcard" -> GithubPunchCard,
    "trellis_anscombe" -> TrellisAnscombe,
    "stacked_area" -> StackedAreaChart,
    "stacked_area_normalize" -> NormalizedStackedAreaChart,
    "stacked_area_stream" -> Streamgraph,
    "stacked_bar_weather" -> StackedBarWeather,
    "tick_strip" -> StripPlot
  ).sortBy(_._1)

  val plots: List[SpecBuilder] = plotsWithNames.map(_._2)
}
