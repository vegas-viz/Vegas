package vegas.spec

import org.everit.json.schema.ValidationException
import org.everit.json.schema.loader.SchemaLoader
import org.json.{JSONObject, JSONTokener}
import vegas.{Fixtures, BaseSpec}

import scala.collection.JavaConverters._
import argonaut._, Argonaut._

/**
  * @author Aish Fenton.
  */
class SpecSpec extends BaseSpec with Fixtures {

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
    val spec = specs.popBarSpec
    val json = spec.toJson()

    json shouldBe a [String]
    json should startWith ("{")
    json should endWith ("}")
  }

  it should "validate to the vegaLite schema" in {
    val spec = specs.popBarSpec
    noException should be thrownBy checkSchema(spec.toJson(true), "/vega_lite_schema.json")
  }

  it should "print JSON with no nulls included" in {
    val spec = specs.popBarSpec
    spec.toJson() should not include ("null")
  }

}

