package vegas.spec

import java.io.File

import vegas.BaseSpec
import io.circe._
import io.circe.syntax._

import scala.io.Source
import vegas.JsonMatchers

class SpecSpec extends BaseSpec with JsonMatchers {

  import vegas.spec.Spec2._
  import vegas.spec.Spec2.Implicits._

  val examples = new File("core/src/test/resources/example-specs").listFiles.toList.filterNot(_.isDirectory)

  "Spec" should "provide case-classes for vega-lite objects" in {
    """
    val spec = ExtendedUnitSpec(
      mark=MarkEnums.Line,
      name=Some("Test"),
      encoding=Some(Encoding(
        x=Some(PositionChannelDef(field=Some("foo")))
      ))
    )
    """ should (compile)
  }

  it should "round trip the vega-lite example set" in {
    examples.foreach { example =>
      val json = Source.fromFile(example).getLines.mkString
      val spec = parser.decode[VegaUnion](json)

      spec should be ('isRight)
      spec.toOption.get.asJson should beNoDifferentFrom(json)
    }
  }

}

