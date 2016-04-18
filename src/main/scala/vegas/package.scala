
import argonaut._, Argonaut._
import monocle.Prism

/**
  * Created by afenton on 4/13/16.
  */
package object vegas extends Encoders {

  // Util used for composing Lens with options (and returning a default)
  def _orElse[T](fn: => T) = Prism[Option[T], T]{ o:Option[T] => o.orElse(Some(fn)) }(Some.apply)

}
