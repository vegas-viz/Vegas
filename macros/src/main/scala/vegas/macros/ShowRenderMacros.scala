package vegas.macros

import scala.reflect.macros.whitebox
import scala.util.Try

class ShowRenderMacros(val c: whitebox.Context) {
  import c.universe.{Try => TryTree, _}

  private def html(tree: Tree) = Try(c.typecheck(tree)).flatMap {
    checked => Try(c.typecheck(q"vegas.render.ShowHTML($checked)"))
  }

  def materializeDefault: Tree = {
    val possibilities: Try[Tree] =
      html(q"""(str: String) => { org.apache.zeppelin.spark.utils.DisplayUtils.html(str) }""") orElse
      html(q"""(str: String) => { publish.html(str) }""") orElse
      html(q"""(str: String) => { display.html(str) }""") orElse
      html(q"""(str: String) => { kernel.display.content("text/html", str) }""") orElse
      Try(c.typecheck(q"""vegas.render.ShowRender.using(_.window.show)"""))

    possibilities.getOrElse(c.abort(c.enclosingPosition, "No default Vegas renderer could be materialized"))
  }
}
