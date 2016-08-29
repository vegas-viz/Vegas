package vegas

import io.circe._
import io.circe.syntax._
import vegas.spec.Spec2._

/**
  * @author Aish Fenton.
  */
package object spec {

  val DropNullJsonPrinter = Printer.spaces2.copy(dropNullKeys = true)

  def toJson(spec: ExtendedUnitSpec) = {
    import Spec2.Implicits._

    spec.asJson.pretty(DropNullJsonPrinter)
  }

}
