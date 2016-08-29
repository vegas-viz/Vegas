package vegas.render

import vegas.DSL.SpecBuilder
import vegas.spec.Spec2.ExtendedUnitSpec
import scalafx.Includes._
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.web.{ WebEngine, WebView }
import javafx.embed.swing.JFXPanel

class Window {

  Platform.implicitExit = false

  var webEngine: WebEngine = null

  private def html(spec: ExtendedUnitSpec) = StaticHTMLRenderer(spec).pageHTML()

  def load(spec: ExtendedUnitSpec) = {
    webEngine.loadContent(html(spec))
  }

  def init = {

    val webView = new WebView {}
    webEngine = webView.engine

    Platform.runLater {
      val stage = new Stage {
        title.value = "Vegas"
        width = 300
        height = 300
        scene = new Scene {
          content = webView
        }
      }

      stage.showAndWait()

    }
  }

  init

}

case class WindowRenderer(spec: ExtendedUnitSpec) {
  lazy val window = new Window()

  def show = Platform.runLater { window.load(spec) }

}

object WindowRenderer {
  new JFXPanel()
  implicit def toWindow(sb: SpecBuilder): WindowRenderer = { WindowRenderer(sb.spec) }
}

