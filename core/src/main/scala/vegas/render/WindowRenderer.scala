package vegas.render

import vegas.DSL.{ExtendedUnitSpecBuilder, SpecBuilder}
import vegas.spec.Spec.ExtendedUnitSpec

import scalafx.Includes._
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.web.{WebEngine, WebView}
import javafx.embed.swing.JFXPanel

class Window {

  Platform.implicitExit = false

  var webEngine: WebEngine = null

  private def html(specJson: String) = StaticHTMLRenderer(specJson).pageHTML()

  def load(specJson: String) = {
    webEngine.loadContent(html(specJson))
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

case class WindowRenderer(specJson: String) {
  lazy val window = new Window()

  def show = Platform.runLater { window.load(specJson) }
}

object WindowRenderer {
  new JFXPanel()
  implicit def toWindow(sb: SpecBuilder): WindowRenderer = { WindowRenderer(sb.toJson) }
}

