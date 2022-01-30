import argus.macros._
import org.scalatest.{FlatSpec, Matchers}


class FromSchemaAnnotationSpec extends FlatSpec with Matchers {

  // FIXME: https://github.com/vegas-viz/Vegas/issues/93
  "fromSchemaResource" should "be compiled" ignore {
    """
      @fromSchemaResource(
        path = "/spec/src/main/resources/vega-lite-schema.json",
        name = "Vega",
        outPath = Some("spec/target/scala-2.12/SpecFromSchemaResource.scala")
      )
      object SpecFromSchemaResource
    """ should compile
  }

  "fromSchemaURL" should "be compiled" in {
    """
      @fromSchemaURL(
        url = "https://vega.github.io/schema/vega-lite/v1.2.0.json",
        name = "Vega",
        outPath = Some("spec/target/scala-2.12/SpecFromSchemaURL.scala")
      )
      object SpecFromSchemaURL
    """ should compile
  }
}
