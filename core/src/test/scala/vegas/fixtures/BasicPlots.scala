package vegas.fixtures

import vegas._

object BasicPlots {

  val SimpleBarChart =
    Vegas("A simple bar chart with embedded data").
    withData(Seq(
      Map("a" -> "A", "b" -> 28), Map("a" -> "B", "b" -> 55), Map("a" -> "C", "b" -> 43),
      Map("a" -> "D", "b" -> 91), Map("a" -> "E", "b" -> 81), Map("a" -> "F", "b" -> 53),
      Map("a" -> "G", "b" -> 19), Map("a" -> "H", "b" -> 87), Map("a" -> "I", "b" -> 52)
    )).
    encodeX("a", Nominal).
    encodeY("b", Quantitative).
    mark(Bar)

  val AggregateBarChart =
    Vegas("A bar chart showing the US population distribution of age groups in 2000.").
    withDataURL("https://vega.github.io/vega-editor/app/data/population.json").
    encodeY("age", Ordinal).
    scaleY(bandSize = 17).
    encodeX("people", Quantitative, aggregate=Sum).
    axisX(title = "population").
    mark(Bar)

  val GroupedBarChart =
    Vegas().
      withDataURL("https://vega.github.io/vega-editor/app/data/population.json").
      mark(Bar).
      addTransformCalculation("gender", """ datum.sex == 2 ? "Female" : "Male" """).
      transformFilter("datum.year == 2000").
      encodeColumn("age", Ordinal).
        scaleColumn(padding=4.0).
        axisColumn(orient=Bottom, axisWidth=1.0, offset= -8.0).
      encodeY("people", Quantitative, aggregate=Sum).
        axisY(title="population", grid=false).
      encodeX("gender", Nominal).
        scaleX(bandSize=6.0).
        axisX(false).
      encodeColor("gender", Nominal).
        scaleColor(rangeNominals=List("#EA98D2", "#659CCA"))

  val plots = SimpleBarChart :: AggregateBarChart :: GroupedBarChart :: Nil

}
