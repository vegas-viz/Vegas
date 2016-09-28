import vegas.spec.Spec

/**
  * Use package object to list public API
  */
package object vegas {

  val Vegas = DSL.Vegas
  val Layer = DSL.Layer
//  type SpecBuilder = { def spec }

  val Axis = vegas.DSL.AxisDSL
  val Scale = vegas.DSL.ScaleDSL
  val Legend = vegas.DSL.LegendDSL
  val Bin = vegas.DSL.BinDSL

  // -------
  // Enums
  // -------

  val Json = Spec.DataFormatTypeEnums.Json
  val CSV = Spec.DataFormatTypeEnums.Csv
  val TSV = Spec.DataFormatTypeEnums.Tsv

  val Bar = Spec.MarkEnums.Bar
  val Circle = Spec.MarkEnums.Circle
  val Square = Spec.MarkEnums.Square
  val Tick = Spec.MarkEnums.Tick
  val Line = Spec.MarkEnums.Line
  val Area = Spec.MarkEnums.Area
  val Point = Spec.MarkEnums.Point
  val Text = Spec.MarkEnums.Text

  val Quantitative = Spec.TypeEnums.Quantitative
  val Nominal = Spec.TypeEnums.Nominal
  val Ordinal = Spec.TypeEnums.Ordinal
  val Temporal = Spec.TypeEnums.Temporal

  val Count = Spec.AggregateOpEnums.Count
  val Valid = Spec.AggregateOpEnums.Valid
  val Missing = Spec.AggregateOpEnums.Missing
  val Distinct = Spec.AggregateOpEnums.Distinct
  val Sum = Spec.AggregateOpEnums.Sum
  val Mean = Spec.AggregateOpEnums.Mean
  val Average = Spec.AggregateOpEnums.Average
  val Variance = Spec.AggregateOpEnums.Variance
  val VarianceP = Spec.AggregateOpEnums.Variancep
  val Stdev = Spec.AggregateOpEnums.Stdev
  val Median = Spec.AggregateOpEnums.Median
  val Q1 = Spec.AggregateOpEnums.Q1
  val Q3 = Spec.AggregateOpEnums.Q3
  val Modeskew = Spec.AggregateOpEnums.Modeskew
  val Min = Spec.AggregateOpEnums.Min
  val Max = Spec.AggregateOpEnums.Max

  val Linear = Spec.ScaleTypeEnums.Linear
  val Log = Spec.ScaleTypeEnums.Log
  val Pow = Spec.ScaleTypeEnums.Pow
  val Sqrt = Spec.ScaleTypeEnums.Sqrt
  val Quantile = Spec.ScaleTypeEnums.Quantile
  val Quantize = Spec.ScaleTypeEnums.Quantize
  val Time = Spec.ScaleTypeEnums.Time
  val OrdinalS = Spec.ScaleTypeEnums.Ordinal

  val Bottom = Spec.AxisOrientEnums.Bottom
  val Top = Spec.AxisOrientEnums.Top
  val Left = Spec.AxisOrientEnums.Left
  val Right = Spec.AxisOrientEnums.Right

  val Category10 = "category10"
  val Category20 = "category20"
  val Category20b = "category20b"
  val Category20c = "category20c"

  val Year = Spec.TimeUnitEnums.Year
  val YearMonth = Spec.TimeUnitEnums.Yearmonth
  val YearMonthDate = Spec.TimeUnitEnums.Yearmonthdate
  val YearQuarter = Spec.TimeUnitEnums.Yearquarter
  val YearQuarterMonth = Spec.TimeUnitEnums.Yearquartermonth
  val YearMonthDateHours = Spec.TimeUnitEnums.Yearmonthdatehours
  val YearMonthDateHoursMinutes = Spec.TimeUnitEnums.Yearmonthdatehoursminutes
  val YearMonthDateHoursMinutesSeconds = Spec.TimeUnitEnums.Yearmonthdatehoursminutesseconds
  val Month = Spec.TimeUnitEnums.Month
  val Day = Spec.TimeUnitEnums.Day
  val Date = Spec.TimeUnitEnums.Date
  val Hours = Spec.TimeUnitEnums.Hours
  val Minutes = Spec.TimeUnitEnums.Minutes
  val Seconds = Spec.TimeUnitEnums.Seconds
  val Milliseconds = Spec.TimeUnitEnums.Milliseconds
  val HoursMinutes = Spec.TimeUnitEnums.Hoursminutes
  val HoursMinutesSeconds = Spec.TimeUnitEnums.Hoursminutesseconds
  val MinutesSeconds = Spec.TimeUnitEnums.Minutesseconds
  val SecondsMilliseconds = Spec.TimeUnitEnums.Secondsmilliseconds

}
