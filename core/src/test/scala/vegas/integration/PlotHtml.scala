package vegas.integration

import vegas.WebMatchers
import vegas.fixtures.{BasicPlots, VegasPlots}
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import org.scalatest.selenium.Chrome

class PlotHtml extends FlatSpec with Matchers with WebMatchers with Chrome with BeforeAndAfterAll {

  val scheme = "file://"

  behavior of "Basic plots"
  BasicPlots.plotsWithNames.foreach { case (name, plot) =>
    it should s"render HTML without error ${name}" in {
      go to (scheme + mkPage(plot))
      find(tagName("canvas"))
      hasNoJsErrors()
    }
  }

  behavior of "Vegas plots"
  VegasPlots.plotsWithNames.foreach { case (name, plot) =>
    it should s"render HTML without error ${name}" in {
      go to (scheme + mkPage(plot))
      find(tagName("canvas"))
      hasNoJsErrors()
    }

  }

  override protected def afterAll() {
    quit()
  }

}
