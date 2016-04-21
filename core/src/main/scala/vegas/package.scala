
/**
  * Created by afenton on 4/13/16.
  *
  * Use package object to list public API
  */
package object vegas {

  val Vegas = DSL.Vegas
  type SpecBuilder = DSL.SpecBuilder

  val JSON = spec.JSON
  val CSV = spec.CSV
  val TSV = spec.TSV

  val BAR = spec.BAR
  val CIRCLE = spec.CIRCLE
  val SQAURE = spec.SQUARE
  val TICK = spec.TICK
  val LINE = spec.LINE
  val AREA = spec.AREA
  val POINT = spec.POINT
  val TEXT = spec.TEXT

  val QUANTITATIVE = spec.QUANTITATIVE
  val NOMINAL = spec.NOMINAL

}
