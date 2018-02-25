package vegas.DSL

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.Inspectors.forAll
import vegas.JsonMatchers

import scala.io.Source

class AllDSLSpec extends FlatSpec with Matchers with JsonMatchers {
  import AllDSLSpec._

  behavior of "BasicPlots"
  for((fileName, plot) <- testCases) {
    it should s"produce the correct json as ${fileName}" in {
      plot.asCirceJson should beSameJsonAs(examples(fileName))
    }
  }
}

object AllDSLSpec {
  import vegas.fixtures.BasicPlots._

  val examples = new File("core/src/test/resources/example-specs")
    .listFiles.toList
    .filter(_.getName.endsWith("json"))
    .map { file =>
      val json = Source.fromFile(file)
        .getLines.mkString
        // Make URLs absolute
        .replaceAll("data/.*.(json|csv|tsv)", "https://vega.github.io/vega-editor/app/$0")
      (file.getName.stripSuffix(".vl.json"), json)
    }
    .toMap

  val testCases = List(
    "bar" -> SimpleBarChart,
    "bar_aggregate" -> AggregateBarChart,
    "bar_grouped" -> GroupedBarChart,
    "area" -> AreaChart,
    "stacked_bar_normalize" -> NormalizedStackedBarChart,
    "scatter_binned" -> ScatterBinnedPlot,
    "scatter_color" -> ScatterColorPlot,
    "scatter_binned_color" -> ScatterBinnedColorPlot,
    "stacked_area_binned" -> StackedAreaBinnedPlot,
    "trellis_barley" -> SortColorPlot,
    "trellis_scatter_binned_row" -> BinnedChart,
    "scatter_shape_custom" -> CustomShapePlot,
    "line_detail" -> LineDetail
  ).sortBy(_._1)
}
