package vegas.DSL

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import vegas.JsonMatchers
import vegas.fixtures.BasicPlots

import scala.io.Source

/**
  * @author Aish Fenton.
  */
class AllDSLs extends FlatSpec with Matchers with JsonMatchers {

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

    SimpleBarChart.asCirceJson should beSameJsonAs(examples("bar"))
    AggregateBarChart.asCirceJson should beSameJsonAs(examples("bar_aggregate"))
    GroupedBarChart.asCirceJson should beSameJsonAs(examples("bar_grouped"))
  }

}
