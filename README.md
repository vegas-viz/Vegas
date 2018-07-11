# Vegas 

<img src="https://www.vegas-viz.org/images/logo.png" alt="Vegas" width="250px">

[![TravisCI](https://travis-ci.org/vegas-viz/Vegas.svg?branch=master)](https://travis-ci.org/vegas-viz/Vegas)
[![codecov](https://codecov.io/gh/vegas-viz/Vegas/branch/master/graph/badge.svg)](https://codecov.io/gh/vegas-viz/Vegas)

Vegas aims to be the missing MatPlotLib for the Scala and Spark world. Vegas wraps around [Vega-Lite](https://vega.github.io/vega-lite/) but provides syntax more familiar (and type checked) for use within Scala.

<img src="https://www.vegas-viz.org/images/gallery.png?true" width="1021">

## Quick start

Add the following jar as an SBT dependency

```sbt
libraryDependencies += "org.vegas-viz" %% "vegas" % {vegas-version}
```

And then use the following code to render a plot into a pop-up window (see below for more details on controlling how and where Vegas renders).

```scala
import vegas._
import vegas.render.WindowRenderer._

val plot = Vegas("Country Pop").
  withData(
    Seq(
      Map("country" -> "USA", "population" -> 314),
      Map("country" -> "UK", "population" -> 64),
      Map("country" -> "DK", "population" -> 80)
    )
  ).
  encodeX("country", Nom).
  encodeY("population", Quant).
  mark(Bar)

plot.show
```

!["Readme Chart 1"](https://www.vegas-viz.org/images/readme-chart-1.png)

See further examples [here](http://nbviewer.jupyter.org/github/aishfenton/Vegas/blob/master/notebooks/jupyter_example.ipynb)

## Rendering

Vegas provides several options for rendering plots. The primary focus is using Vegas within interactive notebook environments, such as Jupyter and Zeppelin.
Rendering is provided via an implicit instance of `ShowRender`, which tells Vegas how to display the plot in a particular environment. The default instance
of `ShowRender` uses a macro which attempts to guess your environment, but if for some reason that fails, you can specify your own instance:

```scala
// for outputting HTML, provide a function String => Unit which will receive the HTML for the plot
// and use vegas.render.ShowHTML to create an instance for it
implicit val renderer = vegas.render.ShowHTML(str => println(s"The HTML is $str"))

// to specify a function that receives the SpecBuilder instead, use vegas.render.ShowRender.using
implicit val renderer = vegas.render.ShowRender.using(sb => println(s"The SpecBuilder is $sb"))
```

The following examples describe some common cases; these *should* be handled by the default macro, but are useful to
see (in case you need to construct your own instance of `ShowRender`):

### Notebooks

#### Jupyter - Scala

If you're using [jupyter-scala](https://github.com/alexarchambault/jupyter-scala), then can include the following in your notebook before using Vegas.

```scala
import $ivy.`org.vegas-viz::vegas:{vegas-version}`
```

```scala
implicit val render = vegas.render.ShowHTML(publish(_))
``` 

#### Jupyter - Apache Toree

And if you're using [Apache Toree](https://toree.incubator.apache.org/), then this:

```
%AddDeps org.vegas-viz vegas_2.11 {vegas-version} --transitive
```

```scala
implicit val render = vegas.render.ShowHTML(kernel.display.content("text/html", _))
``` 

#### Zeppelin

If you're using [Apache Zeppelin](https://zeppelin.incubator.apache.org/):

```
%dep
z.load("org.vegas-viz:vegas_2.11:{vegas-version}")
```
```scala
implicit val render = vegas.render.ShowHTML(s => print("%html " + s))
```

The last line in each of the above is required to connect Vegas to the notebook's HTML renderer (so that the returned HTML is rendered instead of displayed as a string). 

See a comprehensive list example notebook of plots  [here](http://nbviewer.jupyter.org/github/aishfenton/Vegas/blob/master/notebooks/jupyter_example.ipynb)

### Standalone

Vegas can also be used to produce standalone HTML or even render plots within a built-in display app (useful if you wanted to display plots for a command-line-app). 

The construction of the plot is **independent from the rendering strategy**: the same plot can be rendered as HTML or in a Window simply by importing a different renderer in the scope. 

*Note that the rendering examples below are wrapped in separate functions to avoid ambiguous implicit conversions if they were imported in the same scope.*

A plot is defined as:

```scala
import vegas._

val plot = Vegas("Country Pop").
  withData(
    Seq(
      Map("country" -> "USA", "population" -> 314),
      Map("country" -> "UK", "population" -> 64),
      Map("country" -> "DK", "population" -> 80)
    )
  ).
  encodeX("country", Nom).
  encodeY("population", Quant).
  mark(Bar)
```

#### HTML

The following renders the plot as HTML (which prints to the console).

```scala
def renderHTML = {
  println(plot.html.pageHTML) // a complete HTML page containing the plot
  println(plot.html.frameHTML("foo")) // an iframe containing the plot
}
```

#### Window

Vegas also contains a self-contained display app for displaying plots (internally it uses JavaFX's HTML renderer). The following demonstrates this and can be used from the command line. 

```scala
def renderWindow = {
  plot.window.show
}
```

Make sure JavaFX is installed on your system or ships with your JDK distribution.

#### JSON 

You can print the JSON containing the Vega-lite spec, without importing any renderer in the scope.

```scala
println(plot.toJson)
```

The output JSON can be copy-pasted into the Vega-lite [editor](https://vega.github.io/vega-editor/?mode=vega-lite&spec=bar).

## Spark integration

Vegas comes with an optional extension package that makes it easier to work with Spark DataFrames. First, you'll need an extra import

```sbt
libraryDependencies += "org.vegas-viz" %% "vegas-spark" % "{vegas-version}"
```

```scala
import vegas.sparkExt._
```

This adds the following new method:

```scala
withDataFrame(df: DataFrame)
```

Each DataFrame column is exposed as a field keyed using the column's name.

## Flink integration

Vegas also comes with an optional extension package that makes it easier to work with Flink DataSets. You'll also need to import:
```sbt
libraryDependencies += "org.vegas-viz" %% "vegas-flink" % "{vegas-version}"
```

To use:
```scala
import vegas.flink.Flink._
```

This adds the following method:

```scala
withData[T <: Product](ds: DataSet[T])
```
Similarly, to the RDD concept in Spark, a DataSet of _case classes_ or _tuples_ is expected and reflection is used to map the case class' fields to fields within Vegas. In the case of tuples you can encode the fields using `"_1", "_2"` and so on.

## Plot Options

TODO

## Contributing

See [the contributing guide](CONTRIB.md) for more information on contributing bug fixes and features.

