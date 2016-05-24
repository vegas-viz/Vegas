package vegas.macros

import language.experimental.macros
import scala.annotation.{ StaticAnnotation, compileTimeOnly }
import reflect.macros.blackbox.Context
import monocle.Lens

import macrocompat.bundle

class alias_with_lens(name: String, lens: Lens[_,_]) extends StaticAnnotation

@compileTimeOnly("You must enable the macro paradise plugin.")
class aliased extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro AliasMacros.lensAliasMacroImpl
}

/**
  * Aliases an annotated method using the given name and partially applies using the given lens
  * Hat tip to following for inspiration
  *   http://stackoverflow.com/questions/33279472/use-scala-macros-to-generate-methods
  */
@bundle
class AliasMacros(val c: Context) {
  import c.universe._

  def paramsToArgs(params: List[ValDef]): List[Tree] = {
    params.map { case q"$a val $param: $b = $c" => q"$param" }
  }

  def lensAliasMacroImpl(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._

    val result = annottees map (_.tree) match {

      // Match a trait
      case (traitDef @ q"$mods trait $tpname[..$tparams] extends { ..$earlydefns } with ..$parents { $self => ..$stats }") :: _ => {

        // Loop through all functions with aliases, and great new defs for each using given name and lens
        val aliasedDefs = for {
          q"@..$annots private def $tname[..$tparams](...$paramss): $tpt = $expr" <- stats
          annot <- annots
          Apply(Select(New(Ident(TypeName(aName))), _), annotArgs) = annot
          if (aName == "alias_with_lens")
        } yield {
          val List(Literal(Constant(name: String)), lens) = annotArgs
          val aliasIdent = TermName(name)
          val args = paramss.tail.map(paramsToArgs)
          q"def $aliasIdent[..$tparams](...${ paramss.tail }): $tpt = $tname(..$lens)(...$args)"
        }

        // Now rewrite trait with additional methods
        if(aliasedDefs.nonEmpty) {
          q"""
            $mods trait $tpname[..$tparams] extends { ..$earlydefns } with ..$parents { $self =>
              ..$stats
              ..$aliasedDefs
            }
          """
        } else traitDef

      }

      case _ => c.abort(c.enclosingPosition, "Invalid annotation target: not a trait")

    }

    c.Expr[Any](result)
  }

}

