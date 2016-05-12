# README
[![TravisCI](https://travis-ci.org/aishfenton/Vegas.svg?branch=master)](https://travis-ci.org/aishfenton/Vegas)
[![codecov.io](https://codecov.io/github/aishfenton/Vegas/coverage.svg?branch=master)](https://codecov.io/github/aishfenton/Vegas?branch=master)

Vegas aims to be the missing MatPlotLib for the Scala and Spark world. Vegas wraps around [Vega-Lite](https://vega.github.io/vega-lite/) but provides syntax more familar (and type checked) for use within Scala.

<img src="https://dl.dropboxusercontent.com/u/8245460/gallary.png" width="1021">

## Quick start

```bash
sbt veags/console
```

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
  mark(Bar)

chart.show
```

!["Readme Chart 1"](https://dl.dropboxusercontent.com/u/8245460/readme-chart-1.png)

See further examples [here](http://nbviewer.jupyter.org/github/aishfenton/Vegas/blob/master/docs/Examples.ipynb)

## Renderers

Vegas provides a number of options for rendering charts out to. The primary focus is using Vegas within interactive notebook environments, such as Jupyter and Zeppelin.

### Jupyer notebook

```scala
import vegas._
import vegas.render.HTMLRenderer._
``` 

If you're using [jupyter-scala](https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=jupyter%20scala), then you must also declare this immediately after your import lines:

```scala
implicit val displayer: String => Unit = display.html(_)
``` 

And if you're using [Apache Toree](https://toree.incubator.apache.org/), then you must add this:

```scala
implicit val displayer: String => Unit = display.html(_)
``` 


The last line is required to tell Jupyter to render the output HTML (which is a self contained iframe) rather than treat it as a string. It simply captures Jupyer's display object within a closure, which *.show()* then uses to render the HTML.

See a comprehensive example notebook [here](http://nbviewer.jupyter.org/github/aishfenton/Vegas/blob/master/docs/Examples.ipynb)

### Zeppelin notebook



### Standalone window (using JavaFX)


## Contributing

See TODO







