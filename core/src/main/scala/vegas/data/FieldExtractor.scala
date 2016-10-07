package vegas.data

/**
  * Extracts fields from a case classes
  */
object FieldExtractor {

  /**
    * Extracts fields from a case classes into a map of field -> value pairs.
    * @param cc A case-class
    * @return A Map[String, Any] where the keys are the field names and the values are field values.
    */
  def extractFields(cc: Product): Map[String, Any] = {
    import scala.reflect.runtime.universe._

    val mirror = runtimeMirror(cc.getClass.getClassLoader)
    val tipe = mirror.reflect(cc).symbol.asType

    val fields = tipe.typeSignature.members.collect {
      case m: MethodSymbol if m.isCaseAccessor => m
    }.toList

    fields.map { ms =>
      ms.name.toString -> mirror.reflect(cc).reflectMethod(ms)()
    }.toMap
  }

}


