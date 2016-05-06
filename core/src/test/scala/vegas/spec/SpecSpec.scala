package vegas.spec

import org.everit.json.schema.ValidationException
import org.everit.json.schema.loader.SchemaLoader
import org.json.{JSONObject, JSONTokener}
import vegas.BaseSpec

import scala.collection.JavaConverters._
import argonaut._, Argonaut._

/**
  * @author Aish Fenton.
  */
class SpecSpec extends BaseSpec {

  import vegas.spec.Encoders._

  val popData = Seq( Map("population" -> 318000000, "country" -> "USA"), Map("population" -> 64000000, "country" -> "UK") )

  val popBarSpec = Spec(
    description = Some("Country Pop"),
    data = Some(Data(
      values = Some(popData)
    )),
    transform = Some(Transform(
      calculate = Some(Seq(Formula(
        field = "pop_millions",
        expr = "datum.population / 1000000"
      )))
    )),
    encoding = Some(Encoding(
      x = Some(ChannelDef(
        field = Some("pop_millions"),
        dataType = Some(Quantitative),
        axis = Some(Axis(hide = Some(true)))
      )),
      y = Some(ChannelDef(
        field = Some("country"),
        dataType = Some(Nominal),
        axis = Some(Axis(orient=Some(Left), axisWidth=Some(1), offset=Some(10))),
        scale = Some(Scale(padding = Some(5)))
      )),
      color = Some(ChannelDef(
        scale = Some(Scale(rangePreset = Some(Category20)))
      ))
    )),
    mark = Some(Bar)
  )

  def checkSchema(json: String, schemaPath: String) = {
    val rawSchema = new JSONObject(new JSONTokener(getClass.getResourceAsStream(schemaPath)))
    val schema = SchemaLoader.load(rawSchema)

    try {
      val json2 = new JSONObject(json)
      schema.validate(json2)
    }
    catch {
      case (e: ValidationException) => {
        println(json)
        e.getCausingExceptions.asScala.map(_.getMessage).foreach(println)
        throw e
      }
    }
  }

  "A Spec" should "encode to a JSON string" in {
    val spec = popBarSpec
    val json = spec.toJson()

    json shouldBe a [String]
    json should startWith ("{")
    json should endWith ("}")
  }

  it should "validate to the vegaLite schema" in {
    val spec = popBarSpec
    noException should be thrownBy checkSchema(spec.toJson(true), "/vega_lite_schema.json")
  }

  it should "print JSON with no nulls included" in {
    val spec = popBarSpec
    spec.toJson() should not include ("null")
  }

  it should "encode an axis as 'false' if remove is true, but encode as Axis otherwise" in {
    val axisSpec = Spec(
      description = Some("Country Pop"),
      encoding = Some(Encoding(
        x = Some(ChannelDef(
          axis = Some(Axis(hide = Some(true)))
        )),
        y = Some(ChannelDef(
          axis = Some(Axis(title = Some("my-title")))
        ))
      ))
    )

    val json = axisSpec.asJson
    (json.acursor --\ "encoding" --\ "x" --\ "axis").focus should equal(Some(Json.jFalse))
    (json.acursor --\ "encoding" --\ "y" --\ "axis" --\ "title").focus should equal(Some(jString("my-title")))

  }

  it should "encode scale.rangePreset as range, overriding any existing range param" in {
    val axisSpec = Spec(
      description = Some("Country Pop"),
      encoding = Some(Encoding(
        x = Some(ChannelDef(
          scale = Some(Scale(range = Some(Seq("a", "b")), rangePreset = Some(Category10)))
        )),
        y = Some(ChannelDef(
          scale = Some(Scale(range = Some(Seq("a", "b"))))
        ))
      ))
    )

    val json = axisSpec.asJson
    (json.acursor --\ "encoding" --\ "x" --\ "scale" --\ "range").focus should equal(Some( jString("category10") ))
    (json.acursor --\ "encoding" --\ "y" --\ "scale" --\ "range").focus should equal(Some( Json.array(jString("a"), jString("b")) ))
  }
}

