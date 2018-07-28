package vegas.util

import java.io.{File, FileWriter}

import vegas.DSL.SpecBuilder
import vegas.fixtures._

/**
  * @author Aish Fenton.
  */
trait WebGenerators {

  def mkPage(plots: Seq[SpecBuilder]) = {
    val file = File.createTempFile("vegas", ".html")
    val writer = new FileWriter(file)

    val body = plots.map { plot =>
      plot.html.frameHTML()
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

    val html = plot.html.pageHTML()
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
