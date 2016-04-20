# README
![TravisCI](https://travis-ci.org/aishfenton/Vegas.svg?branch=master)

Vegas is a DSL for Scala and Spark to produce [Vega-Lite](https://vega.github.io/vega-lite/) charts and visualizations.

## Example

```scala
import vegas._

val chart = Vegas("Country Pop")
  .addData(Array(Map( "population" -> 318000000, "country" -> "USA" )))
  .addTransformCalculation("pop_in_millions", "datum.population / 1000000")
  .encodeX("pop_in_millions", QUANTITATIVE)
  .encodeY("country", NOMINAL)
  .mark(BAR)
```

To display this chart call *chart.displayHTML* to produce HTML ready to be embedded within favorite notebook.
```scala
val html = chart.displayHTML
```


