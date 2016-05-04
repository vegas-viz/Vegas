package vegas.DSL

sealed trait OptArg[+T] { def get: T }
case object NoArg extends OptArg[Nothing] { def get = throw new NoSuchElementException("No value in NoOpt") }
case class SomeArg[T](v: T) extends OptArg[T] { def get = v }

object OptArg {

  def apply[T](v: T) = if (v == null) NoArg else SomeArg(v)

  implicit def optToOption[T](o: OptArg[T]) = o match {
    case NoArg => None
    case SomeArg(v) => Option(v)
  }
  implicit def optionToOpt[T](o: Option[T]) = o match {
    case None => NoArg
    case Some(v) => SomeArg(v)
  }
  implicit def anyToOpt[T](v: T) = apply[T](v)


}
