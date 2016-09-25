package vegas.fixtures

import vegas._

object VegasPlots {

  val ValuePlot =
    Vegas("Plot with hard-coded size value").
      withDataURL("https://vega.github.io/vega-editor/app/data/cars.json").
      mark(Circle).
      encodeY("Horsepower", Quantitative).
      encodeX("Miles_per_Gallon", Quantitative).
      encodeSize(value=201L)

  val plots: List[SpecBuilder] = ValuePlot :: Nil

}

