# README
[![TravisCI](https://travis-ci.org/aishfenton/Vegas.svg?branch=master)](https://travis-ci.org/aishfenton/Vegas)
[![codecov.io](https://codecov.io/github/aishfenton/Vegas/coverage.svg?branch=master)](https://codecov.io/github/aishfenton/Vegas?branch=master)

Vegas is a DSL for Scala and Spark to produce [Vega-Lite](https://vega.github.io/vega-lite/) charts and visualizations.

## Quick start

```scala
import vegas._
import vegas.render.WindowRenderer._

val chart = Vegas("Country Pop").
  withData(
    Map("country" -> "USA", "population" -> 314),
    Map("country" -> "UK", "population" -> 64),
    Map("country" -> "DK", "population" -> 80)
  ).
  encodeX("country", Nominal).
  encodeY("population", Quantitative).
  mark(Bar).
  show
```



## Renderers

### Jupyer notebook

This 

### Zeppelin notebook

### Standalone window (using JavaFX)


## Contributing

See TODO







