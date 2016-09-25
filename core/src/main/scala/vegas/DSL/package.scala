package vegas

import monocle.Prism

import scala.reflect._

/**
  * @author Aish Fenton.
  */
package object DSL {

  // Util used for composing Lens with options (and returning a default)
  def _orElse[T](fn: => T) = Prism[Option[T], T]{ o:Option[T] => o.orElse(Some(fn)) }(Some.apply)

  /**
    * Trys to convert x to a Double. If it fails then None is returned
    */
  def toDouble(x: Any) = x match {
    case x: Byte => Some(x.toDouble)
    case x: Int => Some(x.toDouble)
    case x: Float => Some(x.toDouble)
    case x: Double => Some(x.toDouble)
    case x: Long => Some(x.toDouble)
    case _ => None
  }

}
