package vegas.examples

import java.net.URL

import vegas._
import vegas.spec.{JSON, BAR}

trait Charts {

  val SimpleBarChart = Vegas("Simple Bar Chart")
    .loadData(new URL("json"), JSON)
    .mark(BAR)


}

/**
  * @author Aish Fenton.
  */
object Examples extends App {



}
