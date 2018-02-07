package vegas.integration

import org.openqa.selenium.WebDriver
import vegas.WebMatchers
import vegas.fixtures.{BasicPlots, VegasPlots}
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import org.scalatest.selenium.Chrome

class PlotHtml extends FlatSpec with Matchers with WebMatchers with Chrome with BeforeAndAfterAll {

  val scheme = "file://"

  "Basic plots" should "render HTML without error" in {

    BasicPlots.plots.foreach { plot =>
      go to (scheme + mkPage(plot))
      find(tagName("canvas"))
      hasNoJsErrors()
    }

  }

  "Vegas plots" should "render HTML without error" in {

    VegasPlots.plots.foreach { plot =>
      go to (scheme + mkPage(plot))
      find(tagName("canvas"))
      hasNoJsErrors()
    }

  }

  override protected def afterAll() {
    quit()
  }

}
