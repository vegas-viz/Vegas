package vegas

import io.circe._
import io.circe.syntax._
import vegas.spec.Spec._

/**
  * @author Aish Fenton.
  */
package object spec {
  val DropNullJsonPrinter = Printer.spaces2.copy(dropNullKeys = true)

  def toJson[T : Encoder](spec: T) = {
    asJson(spec)
      .pretty(DropNullJsonPrinter)
  }

  def asJson[T : Encoder](spec: T) = {
    spec
      .asJson
      .deepMerge(
        Json.obj(
          ("$schema", Json.fromString("https://vega.github.io/schema/vega-lite/v2.json"))
        )
      )
  }

}
