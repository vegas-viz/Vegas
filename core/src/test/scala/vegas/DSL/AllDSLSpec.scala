package vegas.DSL

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import vegas.JsonMatchers
import vegas.fixtures.BasicPlots

import scala.io.Source

class AllDSLSpec extends FlatSpec with Matchers with JsonMatchers {

  val examples = new File("core/src/test/resources/example-specs")
    .listFiles.toList
    .filterNot(_.isDirectory)
    .map { file =>
      val json = Source.fromFile(file)
        .getLines.mkString
        // Make URLs absolute
        .replaceAll("data/.*.json", "https://vega.github.io/vega-editor/app/$0")
      (file.getName.stripSuffix(".json"), json)
    }
    .toMap

  "BasicPlots" should "produce their corresponding Json" in {
    import BasicPlots._


    //Please maintain the sorting based on the json filename. That will help to identify what files have been covered.
    SimpleBarChart.asCirceJson should beSameJsonAs(examples("bar"))
    AggregateBarChart.asCirceJson should beSameJsonAs(examples("bar_aggregate"))
    ScatterBinnedPlot.asCirceJson should beSameJsonAs(examples("scatter_binned"))
    ScatterColorPlot.asCirceJson should beSameJsonAs(examples("scatter_color"))
    ScatterBinnedColorPlot.asCirceJson should beSameJsonAs(examples("scatter_binned_color"))
    StackedAreaBinnedPlot.asCirceJson should beSameJsonAs(examples("stacked_area_binned"))
    BinnedChart.asCirceJson should beSameJsonAs(examples("trellis_scatter_binned_row"))
//    GroupedBarChart.asCirceJson should beSameJsonAs(examples("bar_grouped"))
  }

}
