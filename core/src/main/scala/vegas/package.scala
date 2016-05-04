
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

  val Bar = spec.Bar
  val Circle = spec.Circle
  val Square = spec.Square
  val Tick = spec.Tick
  val Line = spec.Line
  val Area = spec.Area
  val Point = spec.Point
  val Text = spec.Text

  val Quantitative = spec.Quantitative
  val Nominal = spec.Nominal
  val Ordinal = spec.Ordinal
  val Temporal = spec.Temporal

  val Count = spec.Count
  val Valid = spec.Valid
  val Missing = spec.Missing
  val Distinct = spec.Distinct
  val Sum = spec.Sum
  val Mean = spec.Mean
  val Average = spec.Average
  val Variance = spec.Variance
  val VarianceP = spec.VarianceP
  val StDev = spec.StDev
  val Median = spec.Median
  val Q1 = spec.Q1
  val Q3 = spec.Q3
  val ModeSkew = spec.ModeSkew
  val Min = spec.Min
  val Max = spec.Max

  val Linear = spec.Linear
  val Log = spec.Log
  val Pow = spec.Pow
  val Sqrt = spec.Sqrt
  val Quantile = spec.Quantile
  val Quantize = spec.Quantize
  val Threshold = spec.Threshold
  val Time = spec.Time
  val OrdinalS = spec.OrdinalS

}
