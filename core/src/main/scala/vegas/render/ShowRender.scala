package vegas.render

import vegas.macros.ShowRenderMacros
import scala.language.experimental.macros

import vegas.DSL.SpecBuilder

trait ShowRender extends (SpecBuilder => Unit)

object ShowRender {
  def using(f: SpecBuilder => Unit): ShowRender = new ShowRender {
    def apply(sb: SpecBuilder) = f(sb)
  }

  implicit def default: ShowRender = macro ShowRenderMacros.materializeDefault
}

case class ShowHTML(output: String => Unit) extends ShowRender {
  def apply(sb: SpecBuilder): Unit = output(StaticHTMLRenderer(sb.toJson).frameHTML())
}
