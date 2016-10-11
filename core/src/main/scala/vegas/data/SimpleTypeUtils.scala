package vegas.data

object SimpleTypeUtils {

  /**
    * Trys to convert x to a Double. If x is some type of number, then this Some(x: Double) will be returned
    * otherwise None is returned.
    */
  def toDouble(x: Any) = x match {
    case x: Byte => Some(x.toDouble)
    case x: Short => Some(x.toDouble)
    case x: Int => Some(x.toDouble)
    case x: Long => Some(x.toDouble)
    case x: Float => Some(x.toDouble)
    case x: Double => Some(x.toDouble)
    case _ => None
  }

  /**
    * Returns true if x is a number (byte, short, int, long, float, double). NB: Booleans are not defined as being
    * numbers here.
    */
  def isNumber(x: Any) = x match {
    case x: Byte => true
    case x: Short => true
    case x: Int => true
    case x: Long => true
    case x: Float => true
    case x: Double => true
    case _ => false
  }

  /**
    * Returns true if x is a "SimpleType",  otherwise false. SimpleType is defined to be booleans, numbers, and
    * strings; basically the types that Json handles natively.
    */
  def isSimpleType(x: Any) = x match {
    case x if isNumber(x) => true
    case x: Boolean => true
    case x: String => true
    case _ => false
  }

}
