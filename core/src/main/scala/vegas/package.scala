import vegas.spec.Spec2

/**
  * Use package object to list public API
  */
package object vegas {

  val Vegas = DSL.Vegas
  type SpecBuilder = DSL.SpecBuilder

  val Json = Spec2.DataFormatTypeEnums.Json
  val CSV = Spec2.DataFormatTypeEnums.Csv
  val TSV = Spec2.DataFormatTypeEnums.Tsv

  val Bar = Spec2.MarkEnums.Bar
  val Circle = Spec2.MarkEnums.Circle
  val Square = Spec2.MarkEnums.Square
  val Tick = Spec2.MarkEnums.Tick
  val Line = Spec2.MarkEnums.Line
  val Area = Spec2.MarkEnums.Area
  val Point = Spec2.MarkEnums.Point
  val Text = Spec2.MarkEnums.Text

  val Quantitative = Spec2.TypeEnums.Quantitative
  val Nominal = Spec2.TypeEnums.Nominal
  val Ordinal = Spec2.TypeEnums.Ordinal
  val Temporal = Spec2.TypeEnums.Temporal

  val Count = Spec2.AggregateOpEnums.Count
  val Valid = Spec2.AggregateOpEnums.Valid
  val Missing = Spec2.AggregateOpEnums.Missing
  val Distinct = Spec2.AggregateOpEnums.Distinct
  val Sum = Spec2.AggregateOpEnums.Sum
  val Mean = Spec2.AggregateOpEnums.Mean
  val Average = Spec2.AggregateOpEnums.Average
  val Variance = Spec2.AggregateOpEnums.Variance
  val VarianceP = Spec2.AggregateOpEnums.Variancep
  val Stdev = Spec2.AggregateOpEnums.Stdev
  val Median = Spec2.AggregateOpEnums.Median
  val Q1 = Spec2.AggregateOpEnums.Q1
  val Q3 = Spec2.AggregateOpEnums.Q3
  val Modeskew = Spec2.AggregateOpEnums.Modeskew
  val Min = Spec2.AggregateOpEnums.Min
  val Max = Spec2.AggregateOpEnums.Max

  val Linear = Spec2.ScaleTypeEnums.Linear
  val Log = Spec2.ScaleTypeEnums.Log
  val Pow = Spec2.ScaleTypeEnums.Pow
  val Sqrt = Spec2.ScaleTypeEnums.Sqrt
  val Quantile = Spec2.ScaleTypeEnums.Quantile
  val Quantize = Spec2.ScaleTypeEnums.Quantize
  val Time = Spec2.ScaleTypeEnums.Time
  val OrdinalS = Spec2.ScaleTypeEnums.Ordinal

  val Bottom = Spec2.AxisOrientEnums.Bottom
  val Top = Spec2.AxisOrientEnums.Top
  val Left = Spec2.AxisOrientEnums.Left
  val Right = Spec2.AxisOrientEnums.Right

  val Category10 = "category10"
  val Category20 = "category20"
  val Category20b = "category20b"
  val Category20c = "category20c"

  val Year = Spec2.TimeUnitEnums.Year
  val YearMonth = Spec2.TimeUnitEnums.Yearmonth
  val YearMonthDate = Spec2.TimeUnitEnums.Yearmonthdate
  val YearQuarter = Spec2.TimeUnitEnums.Yearquarter
  val YearQuarterMonth = Spec2.TimeUnitEnums.Yearquartermonth
  val YearMonthDateHours = Spec2.TimeUnitEnums.Yearmonthdatehours
  val YearMonthDateHoursMinutes = Spec2.TimeUnitEnums.Yearmonthdatehoursminutes
  val YearMonthDateHoursMinutesSeconds = Spec2.TimeUnitEnums.Yearmonthdatehoursminutesseconds
  val Month = Spec2.TimeUnitEnums.Month
  val Day = Spec2.TimeUnitEnums.Day
  val Date = Spec2.TimeUnitEnums.Date
  val Hours = Spec2.TimeUnitEnums.Hours
  val Minutes = Spec2.TimeUnitEnums.Minutes
  val Seconds = Spec2.TimeUnitEnums.Seconds
  val Milliseconds = Spec2.TimeUnitEnums.Milliseconds
  val HoursMinutes = Spec2.TimeUnitEnums.Hoursminutes
  val HoursMinutesSeconds = Spec2.TimeUnitEnums.Hoursminutesseconds
  val MinutesSeconds = Spec2.TimeUnitEnums.Minutesseconds
  val SecondsMilliseconds = Spec2.TimeUnitEnums.Secondsmilliseconds

}
