package vegas.render

import java.util.concurrent.{Callable, FutureTask}

import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.web.WebView
import javafx.embed.swing.JFXPanel

import com.sun.javafx.webkit.WebConsoleListener

import scala.collection.mutable

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

  def show = {
    val _ = WindowRenderer.init
    Platform.runLater { window.load(specJson) }
  }

}

object WindowRenderer {
  lazy val init = new JFXPanel()
}

