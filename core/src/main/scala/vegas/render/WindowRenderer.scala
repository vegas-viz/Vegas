package vegas.render

import java.util.concurrent.{Callable, FutureTask}

import vegas.DSL.SpecBuilder

import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.web.{WebEngine, WebView}
import javafx.embed.swing.JFXPanel
import javafx.event.EventHandler
import javafx.scene.web.WebErrorEvent

import com.sun.javafx.webkit.WebConsoleListener

import scala.collection.mutable
import scalafx.scene.control.TextArea

class Window {

  Platform.implicitExit = false

  val jsErrors = mutable.Buffer[String]()
  val webView = new WebView {}
  private val webEngine = webView.engine

  private def html(specJson: String) = StaticHTMLRenderer(specJson).pageHTML()

  def close = stage.close

  def load(specJson: String) = {
    webEngine.loadContent(html(specJson))
  }

  // Log JS errors
  WebConsoleListener.setDefaultListener(new WebConsoleListener {
    def messageAdded(webView: javafx.scene.web.WebView, message: String, lineNumber: Int, sourceId: String) = {
      if (message.contains("Error")) jsErrors.append(message)
      println(jsErrors)
    }
  })

  val stage = new Stage {
    title.value = "Vegas"
    width = 300
    height = 300
    scene = new Scene {
      content = webView
    }
  }

  Platform.runLater {
    stage.showAndWait()
  }

}

case class WindowRenderer(specJson: String) {
  lazy val window = new Window()

  def onUIThread[T](op: => T): T = if (Platform.isFxApplicationThread) {
    op
  } else {
    val futureTask = new FutureTask(new Callable[T] {
      override def call: T = onUIThread(op)
    })
    Platform.runLater(futureTask)
    futureTask.get()
  }

  def errors: List[String] = onUIThread { window.jsErrors.toList }

  def close = onUIThread { window.close }

  def show = Platform.runLater { window.load(specJson) }

}

object WindowRenderer {
  new JFXPanel()
  implicit def toWindow(sb: SpecBuilder): WindowRenderer = { WindowRenderer(sb.toJson) }
}

