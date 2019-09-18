package vegas

import io.circe._
import io.circe.syntax._

/**
  * @author Aish Fenton.
  */
package object spec {
  val DropNullJsonPrinter = Printer.spaces2.copy(dropNullValues = true)

  def toJson[T : Encoder](spec: T) = {
    spec.asJson.pretty(DropNullJsonPrinter)
  }

}
