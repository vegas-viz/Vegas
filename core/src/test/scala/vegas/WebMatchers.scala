package vegas

import java.awt.Desktop
import java.io.{File, FileWriter}
import java.net.URI

import org.openqa.selenium.chrome.ChromeDriver
import vegas.render.HTMLRenderer
import org.openqa.selenium.logging.LogType
import java.util.logging.Level

import org.scalatest.ShouldMatchers
import vegas.fixtures.{BasicPlots, VegasPlots}

import scala.collection.JavaConverters._

trait WebMatchers extends WebGenerators {
  self: ShouldMatchers =>

  def hasNoJsErrors()(implicit webDriver: ChromeDriver) = {
    val logs = webDriver.manage.logs.get(LogType.BROWSER).filter(Level.WARNING).asScala.toList
    logs should be ('empty)
  }

}

trait WebGenerators {

  def mkPage(plots: Seq[SpecBuilder]) = {
    val file = File.createTempFile("vegas", ".html")
    val writer = new FileWriter(file)

    val body = plots.map { plot =>
      HTMLRenderer.toStaticHTMLRenderer(plot).frameHTML()
    }.mkString

    writer.write(s"""
      <html>
      <head><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script></head>
      </body>$body</body>
      </html>
    """)
    writer.close
    file.getAbsolutePath
  }

  def mkPage(plot: SpecBuilder) = {
    val file = File.createTempFile("vegas", ".html")
    val writer = new FileWriter(file)

    val html = HTMLRenderer.toStaticHTMLRenderer(plot).pageHTML()
    writer.write(html)
    writer.close

    file.getAbsolutePath
  }
}

/**
  * Sometimes automated testing isn't enough. Sometimes you need to see stuff. This little "app" generates all the
  * fixture plots and opens them in the mac browser.
  */
object Look extends App with WebGenerators {
  import scala.sys.process._

  val plots = BasicPlots.plots ++ VegasPlots.plots
  val page = mkPage(plots)

  s"open $page".!!

}
