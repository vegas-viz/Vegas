package vegas.integration

import org.openqa.selenium.WebDriver
import vegas.WebMatchers
import vegas.fixtures.BasicPlots
import org.scalatest.{FlatSpec, ShouldMatchers}
import org.scalatest.selenium.Chrome

class PlotHtml extends FlatSpec with ShouldMatchers with WebMatchers with Chrome {

  val scheme = "file://"
  val Plots = BasicPlots.plots

  "Basic plots" should "render HTML without error" in {

    Plots.foreach { plot =>
      go to (scheme + mkPage(plot))
      find(tagName("canvas"))
      hasNoJsErrors()
    }

    close()
  }

}
