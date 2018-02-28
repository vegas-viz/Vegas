package vegas.DSL

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import vegas.JsonMatchers
import vegas.fixtures.BasicPlots.plotsWithNames

import scala.io.Source

class AllDSLSpec extends FlatSpec with Matchers with JsonMatchers {
  import AllDSLSpec._

  behavior of "BasicPlots"
  for((name, plot) <- plotsWithNames) {
    it should s"produce the correct json as ${name}" in {
      plot.asCirceJson should beSameJsonAs(examples(name))
    }
  }
}

object AllDSLSpec {
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
}
