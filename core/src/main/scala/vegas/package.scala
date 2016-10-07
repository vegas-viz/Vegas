import vegas.spec.Spec
import vegas.spec.Spec.{HorizontalAlignEnums, StackOffsetEnums, VerticalAlignEnums}

/**
  * Use package object to list public API
  */
package object vegas {

  val Vegas = DSL.Vegas
  val Layer = DSL.Layer

  implicit val DefaultValueTransformer = vegas.data.DefaultValueTransformer

  val Axis = vegas.DSL.AxisDSL
  val Scale = vegas.DSL.ScaleDSL
  val Legend = vegas.DSL.LegendDSL
  val Bin = vegas.DSL.BinDSL

  // -------
  // Core Enums
  // -------

  val Quantitative = Spec.TypeEnums.Quantitative
  val Quant = Quantitative
  val Nominal = Spec.TypeEnums.Nominal
  val Nom = Nominal
  val Ordinal = Spec.TypeEnums.Ordinal
  val Ord = Ordinal
  val Temporal = Spec.TypeEnums.Temporal
  val Temp = Temporal

  val Bar = Spec.MarkEnums.Bar
  val Circle = Spec.MarkEnums.Circle
  val Square = Spec.MarkEnums.Square
  val Tick = Spec.MarkEnums.Tick
  val Line = Spec.MarkEnums.Line
  val Area = Spec.MarkEnums.Area
  val Point = Spec.MarkEnums.Point
  val Text = Spec.MarkEnums.Text

  val AggOps = Spec.AggregateOpEnums
  val DataFormat = Spec.DataFormatTypeEnums
  val ScaleType = Spec.ScaleTypeEnums
  val Orient = Spec.AxisOrientEnums
  val TimeUnit = Spec.TimeUnitEnums
  val Nice = Spec.NiceTimeEnums

  val Category10 = "category10"
  val Category20 = "category20"
  val Category20b = "category20b"
  val Category20c = "category20c"


  // ---
  // Config Enums
  // ---

  val StackOffset = Spec.StackOffsetEnums
  val MarkOrient = Spec.OrientEnums
  val Interpolate = Spec.InterpolateEnums
  val HorizontalAlign =  Spec.HorizontalAlignEnums
  val VerticalAlign = Spec.VerticalAlignEnums
  val Shape = Spec.ShapeEnums
  val FontStyle = Spec.FontStyleEnums
  val FontWeight = Spec.FontWeightEnums

  val AreaOverlay = Spec.AreaOverlayEnums

  val AxisConfig = vegas.DSL.AxisConfigDSL
  val CellConfig = vegas.DSL.CellConfigDSL
  val MarkConfig = vegas.DSL.MarkConfigDSL

}
