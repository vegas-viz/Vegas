// To run:
// scala -cp ../core/target/scala-2.11/vegas-assembly-0.1.0.jar ExampleScript.scala

import vegas._
import vegas.render.WindowRenderer._

println("Plotting data with Vegas!")

Vegas("A simple bar chart with embedded data").
  withData(
    Map("a" -> "A", "b" -> 28), Map("a" -> "B", "b" -> 55), Map("a" -> "C", "b" -> 43),
    Map("a" -> "D", "b" -> 91), Map("a" -> "E", "b" -> 81), Map("a" -> "F", "b" -> 53),
    Map("a" -> "G", "b" -> 19), Map("a" -> "H", "b" -> 87), Map("a" -> "I", "b" -> 52)
  ).
  mark(Bar).
  encodeX("a", Ordinal).
  encodeY("b", Quantitative).
  show

val chart = Vegas("A bar chart showing the US population distribution of age groups in 2000.").
  withData("https://vega.github.io/vega-lite/data/population.json", JSON).
  encodeY("age", Ordinal).
  encodeX("people", Quantitative, Sum).
  axisX(title = "population").
  scaleY(bandSize=17).
  mark(Bar)

chart.show

