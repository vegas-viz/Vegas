# README
[![TravisCI](https://travis-ci.org/aishfenton/Vegas.svg?branch=master)](https://travis-ci.org/aishfenton/Vegas)
[![codecov.io](https://codecov.io/github/aishfenton/Vegas/coverage.svg?branch=master)](https://codecov.io/github/aishfenton/Vegas?branch=master)

Vegas is a DSL for Scala and Spark to produce [Vega-Lite](https://vega.github.io/vega-lite/) charts and visualizations.

## Quick start

```scala
import vegas._
import vegas.render.StaticHTMLRenderer._

val chart = Vegas("Country Pop").
  withData(Array("USA", 318000), Array("UK", 64000000)).
  encodeX("population", Quantitive).
  encodeY("country", Nominal).
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







