package vegas

import monocle.Prism

/**
  * @author Aish Fenton.
  */
package object DSL {

  // Util used for composing Lens with options (and returning a default)
  def _orElse[T](fn: => T) = Prism[Option[T], T]{ o:Option[T] => o.orElse(Some(fn)) }(Some.apply)

}
