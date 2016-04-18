# Examples

## Population

```scala
import vegas._

val data = rawData.popData
val spec = specs.popBarSpec

val specBuilder = Vegas("Country Pop")
  .addData(data)
  .addTransformCalculation("pop_millions", "datum.population / 1000000")
  .encodeX("pop_millions", QUANTITATIVE)
  .encodeY("country", NOMINAL)
  .mark(BAR)

specBuilder.displayHTML
```
