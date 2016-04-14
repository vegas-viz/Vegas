package vegas

import org.everit.json.schema.{ValidationException, Schema}
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import argonaut._, Argonaut._
import scala.collection.JavaConverters._


/**
  * @author Aish Fenton.
  */
class SpecSpec extends BaseSpec {

  def fixture = {

    val data = Data(Option(Map("population" -> "318000000", "country" -> "USA")))
    val formula = Formula("f1", "f1 * 2")
    val transform = Transform(Option(Array(formula)))
    val xcd = ChannelDef(Option("f1"), Option(QUANTITATIVE))
    val ycd = ChannelDef(Option("f2"), Option(NOMINAL))
    val encoding = Encoding(Option(xcd), Option(ycd))
    val config = Config("t")
    val mySpec = Spec(Option("myChart"), None, BAR, None, Option(encoding), None)

    new { val spec = mySpec }

  }

  def checkSchema(json: Json, schemaPath: String) = {
    val rawSchema = new JSONObject(new JSONTokener(getClass.getResourceAsStream(schemaPath)))
    val schema = SchemaLoader.load(rawSchema)

    try {
      val json2 = new JSONObject(json.asJson.pretty(vegas.noNulls))
      schema.validate(json2)
    }
    catch {
      case (e: ValidationException) => {
        println(json.asJson.pretty(vegas.noNullSpaces2))
        e.getCausingExceptions.asScala.map(_.getMessage).foreach(println)
        throw e
      }
    }
  }

  "A Spec" should "produce valid JSON" in {
    val spec = fixture.spec
    checkSchema(spec.asJson, "/vega_lite_schema.json")
  }

  it should "" in {

  }

}

