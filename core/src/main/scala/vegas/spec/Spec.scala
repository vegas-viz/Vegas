package vegas.spec

object Spec {
  class enum extends scala.annotation.StaticAnnotation;
  class union extends scala.annotation.StaticAnnotation;
  case class ExtendedUnitSpec(
    width: Option[Double] = None,
    height: Option[Double] = None,
    mark: Mark,
    encoding: Option[Encoding] = None,
    name: Option[String] = None,
    description: Option[String] = None,
    data: Option[Data] = None,
    transform: Option[Transform] = None,
    config: Option[Config] = None);
  @enum sealed trait Mark extends scala.Product with scala.Serializable {
    def json: String
  };
  object MarkEnums {
    case object Area extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"area\""
    };
    case object Bar extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"bar\""
    };
    case object Line extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"line\""
    };
    case object Point extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"point\""
    };
    case object Text extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"text\""
    };
    case object Tick extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"tick\""
    };
    case object Rule extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"rule\""
    };
    case object Circle extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"circle\""
    };
    case object Square extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"square\""
    };
    case object ErrorBar extends Mark with scala.Product with scala.Serializable {
      val json: String = "\"errorBar\""
    }
  };
  case class Encoding(
    row: Option[PositionChannelDef] = None,
    column: Option[PositionChannelDef] = None,
    x: Option[PositionChannelDef] = None,
    y: Option[PositionChannelDef] = None,
    x2: Option[FieldDef] = None,
    y2: Option[FieldDef] = None,
    color: Option[ChannelDefWithLegend] = None,
    opacity: Option[ChannelDefWithLegend] = None,
    size: Option[ChannelDefWithLegend] = None,
    shape: Option[ChannelDefWithLegend] = None,
    detail: Option[Encoding.DetailUnion] = None,
    text: Option[FieldDef] = None,
    label: Option[FieldDef] = None,
    path: Option[Encoding.PathUnion] = None,
    order: Option[Encoding.OrderUnion] = None);
  object Encoding {
    @union sealed trait DetailUnion extends scala.Product with scala.Serializable;
    case class DetailFieldDef(x: FieldDef) extends DetailUnion;
    case class DetailListFieldDef(x: List[FieldDef]) extends DetailUnion;
    @union sealed trait PathUnion extends scala.Product with scala.Serializable;
    case class PathOrderChannelDef(x: OrderChannelDef) extends PathUnion;
    case class PathListOrderChannelDef(x: List[OrderChannelDef]) extends PathUnion;
    @union sealed trait OrderUnion extends scala.Product with scala.Serializable;
    case class OrderOrderChannelDef(x: OrderChannelDef) extends OrderUnion;
    case class OrderListOrderChannelDef(x: List[OrderChannelDef]) extends OrderUnion
  };
  case class PositionChannelDef(
    axis: Option[PositionChannelDef.AxisUnion] = None,
    scale: Option[Scale] = None,
    sort: Option[PositionChannelDef.SortUnion] = None,
    field: Option[String] = None,
    `type`: Option[Type] = None,
    value: Option[PositionChannelDef.ValueUnion] = None,
    timeUnit: Option[TimeUnit] = None,
    bin: Option[PositionChannelDef.BinUnion] = None,
    aggregate: Option[AggregateOp] = None,
    title: Option[String] = None);
  object PositionChannelDef {
    @union sealed trait AxisUnion extends scala.Product with scala.Serializable;
    case class AxisBoolean(x: Boolean) extends AxisUnion;
    case class AxisAxis(x: Axis) extends AxisUnion;
    @union sealed trait SortUnion extends scala.Product with scala.Serializable;
    case class SortSortField(x: SortField) extends SortUnion;
    case class SortSortOrder(x: SortOrder) extends SortUnion;
    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;
    case class ValueDouble(x: Double) extends ValueUnion;
    case class ValueString(x: String) extends ValueUnion;
    case class ValueBoolean(x: Boolean) extends ValueUnion;
    @union sealed trait BinUnion extends scala.Product with scala.Serializable;
    case class BinBoolean(x: Boolean) extends BinUnion;
    case class BinBin(x: Bin) extends BinUnion
  };
  case class Axis(
    labelAngle: Option[Double] = None,
    format: Option[String] = None,
    orient: Option[AxisOrient] = None,
    title: Option[String] = None,
    values: Option[List[Double]] = None,
    axisWidth: Option[Double] = None,
    layer: Option[String] = None,
    offset: Option[Double] = None,
    axisColor: Option[String] = None,
    grid: Option[Boolean] = None,
    gridColor: Option[String] = None,
    gridDash: Option[List[Double]] = None,
    gridOpacity: Option[Double] = None,
    gridWidth: Option[Double] = None,
    labels: Option[Boolean] = None,
    labelAlign: Option[String] = None,
    labelBaseline: Option[String] = None,
    labelMaxLength: Option[Double] = None,
    shortTimeLabels: Option[Boolean] = None,
    subdivide: Option[Double] = None,
    ticks: Option[Double] = None,
    tickColor: Option[String] = None,
    tickLabelColor: Option[String] = None,
    tickLabelFont: Option[String] = None,
    tickLabelFontSize: Option[Double] = None,
    tickPadding: Option[Double] = None,
    tickSize: Option[Double] = None,
    tickSizeMajor: Option[Double] = None,
    tickSizeMinor: Option[Double] = None,
    tickSizeEnd: Option[Double] = None,
    tickWidth: Option[Double] = None,
    titleColor: Option[String] = None,
    titleFont: Option[String] = None,
    titleFontSize: Option[Double] = None,
    titleFontWeight: Option[String] = None,
    titleOffset: Option[Double] = None,
    titleMaxLength: Option[Double] = None,
    characterWidth: Option[Double] = None,
    properties: Option[Axis.Properties] = None);
  object Axis {
    case class Properties(x: Any)
  };
  @enum sealed trait AxisOrient extends scala.Product with scala.Serializable {
    def json: String
  };
  object AxisOrientEnums {
    case object Top extends AxisOrient with scala.Product with scala.Serializable {
      val json: String = "\"top\""
    };
    case object Right extends AxisOrient with scala.Product with scala.Serializable {
      val json: String = "\"right\""
    };
    case object Left extends AxisOrient with scala.Product with scala.Serializable {
      val json: String = "\"left\""
    };
    case object Bottom extends AxisOrient with scala.Product with scala.Serializable {
      val json: String = "\"bottom\""
    }
  };
  case class Scale(
    `type`: Option[ScaleType] = None,
    domain: Option[Scale.DomainUnion] = None,
    range: Option[Scale.RangeUnion] = None,
    round: Option[Boolean] = None,
    rangeStep: Option[Scale.RangeStepUnion] = None,
    padding: Option[Double] = None,
    clamp: Option[Boolean] = None,
    nice: Option[Scale.NiceUnion] = None,
    exponent: Option[Double] = None,
    zero: Option[Boolean] = None,
    useRawDomain: Option[Boolean] = None);
  object Scale {
    @union sealed trait DomainUnion extends scala.Product with scala.Serializable;
    case class DomainListDouble(x: List[Double]) extends DomainUnion;
    case class DomainListString(x: List[String]) extends DomainUnion;
    @union sealed trait RangeUnion extends scala.Product with scala.Serializable;
    case class RangeString(x: String) extends RangeUnion;
    case class RangeListDouble(x: List[Double]) extends RangeUnion;
    case class RangeListString(x: List[String]) extends RangeUnion;
    @union sealed trait RangeStepUnion extends scala.Product with scala.Serializable;
    case class RangeStepDouble(x: Double) extends RangeStepUnion;
    case class RangeStepRangeStep(x: RangeStep) extends RangeStepUnion;
    @union sealed trait NiceUnion extends scala.Product with scala.Serializable;
    case class NiceBoolean(x: Boolean) extends NiceUnion;
    case class NiceNiceTime(x: NiceTime) extends NiceUnion
  };
  @enum sealed trait ScaleType extends scala.Product with scala.Serializable {
    def json: String
  };
  object ScaleTypeEnums {
    case object Linear extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"linear\""
    };
    case object Log extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"log\""
    };
    case object Pow extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"pow\""
    };
    case object Sqrt extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"sqrt\""
    };
    case object Quantile extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"quantile\""
    };
    case object Quantize extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"quantize\""
    };
    case object Ordinal extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"ordinal\""
    };
    case object Time extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"time\""
    };
    case object Utc extends ScaleType with scala.Product with scala.Serializable {
      val json: String = "\"utc\""
    }
  };
  @enum sealed trait RangeStep extends scala.Product with scala.Serializable {
    def json: String
  };
  object RangeStepEnums {
    case object Fit extends RangeStep with scala.Product with scala.Serializable {
      val json: String = "\"fit\""
    }
  };
  @enum sealed trait NiceTime extends scala.Product with scala.Serializable {
    def json: String
  };
  object NiceTimeEnums {
    case object Second extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"second\""
    };
    case object Minute extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"minute\""
    };
    case object Hour extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"hour\""
    };
    case object Day extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"day\""
    };
    case object Week extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"week\""
    };
    case object Month extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"month\""
    };
    case object Year extends NiceTime with scala.Product with scala.Serializable {
      val json: String = "\"year\""
    }
  };
  case class SortField(
    field: String,
    op: AggregateOp,
    order: Option[SortOrder] = None);
  @enum sealed trait AggregateOp extends scala.Product with scala.Serializable {
    def json: String
  };
  object AggregateOpEnums {
    case object Values extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"values\""
    };
    case object Count extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"count\""
    };
    case object Valid extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"valid\""
    };
    case object Missing extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"missing\""
    };
    case object Distinct extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"distinct\""
    };
    case object Sum extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"sum\""
    };
    case object Mean extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"mean\""
    };
    case object Average extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"average\""
    };
    case object Variance extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"variance\""
    };
    case object Variancep extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"variancep\""
    };
    case object Stdev extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"stdev\""
    };
    case object Stdevp extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"stdevp\""
    };
    case object Median extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"median\""
    };
    case object Q1 extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"q1\""
    };
    case object Q3 extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"q3\""
    };
    case object Modeskew extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"modeskew\""
    };
    case object Min extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"min\""
    };
    case object Max extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"max\""
    };
    case object Argmin extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"argmin\""
    };
    case object Argmax extends AggregateOp with scala.Product with scala.Serializable {
      val json: String = "\"argmax\""
    }
  };
  @enum sealed trait SortOrder extends scala.Product with scala.Serializable {
    def json: String
  };
  object SortOrderEnums {
    case object Ascending extends SortOrder with scala.Product with scala.Serializable {
      val json: String = "\"ascending\""
    };
    case object Descending extends SortOrder with scala.Product with scala.Serializable {
      val json: String = "\"descending\""
    };
    case object None extends SortOrder with scala.Product with scala.Serializable {
      val json: String = "\"none\""
    }
  };
  @enum sealed trait Type extends scala.Product with scala.Serializable {
    def json: String
  };
  object TypeEnums {
    case object Quantitative extends Type with scala.Product with scala.Serializable {
      val json: String = "\"quantitative\""
    };
    case object Ordinal extends Type with scala.Product with scala.Serializable {
      val json: String = "\"ordinal\""
    };
    case object Temporal extends Type with scala.Product with scala.Serializable {
      val json: String = "\"temporal\""
    };
    case object Nominal extends Type with scala.Product with scala.Serializable {
      val json: String = "\"nominal\""
    }
  };
  @enum sealed trait TimeUnit extends scala.Product with scala.Serializable {
    def json: String
  };
  object TimeUnitEnums {
    case object Year extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"year\""
    };
    case object Month extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"month\""
    };
    case object Day extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"day\""
    };
    case object Date extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"date\""
    };
    case object Hours extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"hours\""
    };
    case object Minutes extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"minutes\""
    };
    case object Seconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"seconds\""
    };
    case object Milliseconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"milliseconds\""
    };
    case object Yearmonth extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearmonth\""
    };
    case object Yearmonthdate extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearmonthdate\""
    };
    case object Yearmonthdatehours extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearmonthdatehours\""
    };
    case object Yearmonthdatehoursminutes extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearmonthdatehoursminutes\""
    };
    case object Yearmonthdatehoursminutesseconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearmonthdatehoursminutesseconds\""
    };
    case object Hoursminutes extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"hoursminutes\""
    };
    case object Hoursminutesseconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"hoursminutesseconds\""
    };
    case object Minutesseconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"minutesseconds\""
    };
    case object Secondsmilliseconds extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"secondsmilliseconds\""
    };
    case object Quarter extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"quarter\""
    };
    case object Yearquarter extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearquarter\""
    };
    case object Quartermonth extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"quartermonth\""
    };
    case object Yearquartermonth extends TimeUnit with scala.Product with scala.Serializable {
      val json: String = "\"yearquartermonth\""
    }
  };
  case class Bin(
    min: Option[Double] = None,
    max: Option[Double] = None,
    base: Option[Double] = None,
    step: Option[Double] = None,
    steps: Option[List[Double]] = None,
    minstep: Option[Double] = None,
    div: Option[List[Double]] = None,
    maxbins: Option[Double] = None);
  case class FieldDef(
    field: Option[String] = None,
    `type`: Option[Type] = None,
    value: Option[FieldDef.ValueUnion] = None,
    timeUnit: Option[TimeUnit] = None,
    bin: Option[FieldDef.BinUnion] = None,
    aggregate: Option[AggregateOp] = None,
    title: Option[String] = None);
  object FieldDef {
    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;
    case class ValueDouble(x: Double) extends ValueUnion;
    case class ValueString(x: String) extends ValueUnion;
    case class ValueBoolean(x: Boolean) extends ValueUnion;
    @union sealed trait BinUnion extends scala.Product with scala.Serializable;
    case class BinBoolean(x: Boolean) extends BinUnion;
    case class BinBin(x: Bin) extends BinUnion
  };
  case class ChannelDefWithLegend(
    legend: Option[Legend] = None,
    scale: Option[Scale] = None,
    sort: Option[ChannelDefWithLegend.SortUnion] = None,
    field: Option[String] = None,
    `type`: Option[Type] = None,
    value: Option[ChannelDefWithLegend.ValueUnion] = None,
    timeUnit: Option[TimeUnit] = None,
    bin: Option[ChannelDefWithLegend.BinUnion] = None,
    aggregate: Option[AggregateOp] = None,
    title: Option[String] = None);
  object ChannelDefWithLegend {
    @union sealed trait SortUnion extends scala.Product with scala.Serializable;
    case class SortSortField(x: SortField) extends SortUnion;
    case class SortSortOrder(x: SortOrder) extends SortUnion;
    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;
    case class ValueDouble(x: Double) extends ValueUnion;
    case class ValueString(x: String) extends ValueUnion;
    case class ValueBoolean(x: Boolean) extends ValueUnion;
    @union sealed trait BinUnion extends scala.Product with scala.Serializable;
    case class BinBoolean(x: Boolean) extends BinUnion;
    case class BinBin(x: Bin) extends BinUnion
  };
  case class Legend(
    format: Option[String] = None,
    title: Option[String] = None,
    values: Option[List[Legend.Values]] = None,
    orient: Option[String] = None,
    offset: Option[Double] = None,
    padding: Option[Double] = None,
    margin: Option[Double] = None,
    gradientStrokeColor: Option[String] = None,
    gradientStrokeWidth: Option[Double] = None,
    gradientHeight: Option[Double] = None,
    gradientWidth: Option[Double] = None,
    labelAlign: Option[String] = None,
    labelBaseline: Option[String] = None,
    labelColor: Option[String] = None,
    labelFont: Option[String] = None,
    labelFontSize: Option[Double] = None,
    labelOffset: Option[Double] = None,
    shortTimeLabels: Option[Boolean] = None,
    symbolColor: Option[String] = None,
    symbolShape: Option[String] = None,
    symbolSize: Option[Double] = None,
    symbolStrokeWidth: Option[Double] = None,
    titleColor: Option[String] = None,
    titleFont: Option[String] = None,
    titleFontSize: Option[Double] = None,
    titleFontWeight: Option[String] = None,
    properties: Option[Legend.Properties] = None);
  object Legend {
    case class Values(x: Any);
    case class Properties(x: Any)
  };
  case class OrderChannelDef(
    sort: Option[SortOrder] = None,
    field: Option[String] = None,
    `type`: Option[Type] = None,
    value: Option[OrderChannelDef.ValueUnion] = None,
    timeUnit: Option[TimeUnit] = None,
    bin: Option[OrderChannelDef.BinUnion] = None,
    aggregate: Option[AggregateOp] = None,
    title: Option[String] = None);
  object OrderChannelDef {
    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;
    case class ValueDouble(x: Double) extends ValueUnion;
    case class ValueString(x: String) extends ValueUnion;
    case class ValueBoolean(x: Boolean) extends ValueUnion;
    @union sealed trait BinUnion extends scala.Product with scala.Serializable;
    case class BinBoolean(x: Boolean) extends BinUnion;
    case class BinBin(x: Bin) extends BinUnion
  };
  case class Data(
    format: Option[DataFormat] = None,
    url: Option[String] = None,
    values: Option[List[Data.Values]] = None);
  object Data {
    case class Values(x: Any)
  };
  case class DataFormat(
    `type`: Option[DataFormatType] = None,
    property: Option[String] = None,
    feature: Option[String] = None,
    mesh: Option[String] = None);
  @enum sealed trait DataFormatType extends scala.Product with scala.Serializable {
    def json: String
  };
  object DataFormatTypeEnums {
    case object Json extends DataFormatType with scala.Product with scala.Serializable {
      val json: String = "\"json\""
    };
    case object Csv extends DataFormatType with scala.Product with scala.Serializable {
      val json: String = "\"csv\""
    };
    case object Tsv extends DataFormatType with scala.Product with scala.Serializable {
      val json: String = "\"tsv\""
    };
    case object Topojson extends DataFormatType with scala.Product with scala.Serializable {
      val json: String = "\"topojson\""
    }
  };
  case class Transform(
    filter: Option[Transform.FilterUnion] = None,
    filterInvalid: Option[Boolean] = None,
    calculate: Option[List[Formula]] = None);
  object Transform {
    @union sealed trait FilterUnion extends scala.Product with scala.Serializable;
    case class FilterString(x: String) extends FilterUnion;
    case class FilterEqualFilter(x: EqualFilter) extends FilterUnion;
    case class FilterRangeFilter(x: RangeFilter) extends FilterUnion;
    case class FilterOneOfFilter(x: OneOfFilter) extends FilterUnion;
    case class FilterListTransformFilter5Union(x: List[Transform.Filter5Union]) extends FilterUnion;
    @union sealed trait Filter5Union extends scala.Product with scala.Serializable;
    case class Filter5String(x: String) extends Filter5Union;
    case class Filter5EqualFilter(x: EqualFilter) extends Filter5Union;
    case class Filter5RangeFilter(x: RangeFilter) extends Filter5Union;
    case class Filter5OneOfFilter(x: OneOfFilter) extends Filter5Union
  };
  case class EqualFilter(
    timeUnit: Option[TimeUnit] = None,
    field: String,
    equal: EqualFilter.EqualUnion);
  object EqualFilter {
    @union sealed trait EqualUnion extends scala.Product with scala.Serializable;
    case class EqualString(x: String) extends EqualUnion;
    case class EqualDouble(x: Double) extends EqualUnion;
    case class EqualBoolean(x: Boolean) extends EqualUnion;
    case class EqualDateTime(x: DateTime) extends EqualUnion
  };
  case class DateTime(
    year: Option[Double] = None,
    quarter: Option[Double] = None,
    month: Option[DateTime.MonthUnion] = None,
    date: Option[Double] = None,
    day: Option[DateTime.DayUnion] = None,
    hours: Option[Double] = None,
    minutes: Option[Double] = None,
    seconds: Option[Double] = None,
    milliseconds: Option[Double] = None);
  object DateTime {
    @union sealed trait MonthUnion extends scala.Product with scala.Serializable;
    case class MonthDouble(x: Double) extends MonthUnion;
    case class MonthString(x: String) extends MonthUnion;
    @union sealed trait DayUnion extends scala.Product with scala.Serializable;
    case class DayDouble(x: Double) extends DayUnion;
    case class DayString(x: String) extends DayUnion
  };
  case class RangeFilter(
    timeUnit: Option[TimeUnit] = None,
    field: String,
    range: List[RangeFilter.RangeUnion]);
  object RangeFilter {
    @union sealed trait RangeUnion extends scala.Product with scala.Serializable;
    case class RangeDouble(x: Double) extends RangeUnion;
    case class RangeDateTime(x: DateTime) extends RangeUnion
  };
  case class OneOfFilter(
    timeUnit: Option[TimeUnit] = None,
    field: String,
    oneOf: List[OneOfFilter.OneOfUnion]);
  object OneOfFilter {
    @union sealed trait OneOfUnion extends scala.Product with scala.Serializable;
    case class OneOfString(x: String) extends OneOfUnion;
    case class OneOfDouble(x: Double) extends OneOfUnion;
    case class OneOfBoolean(x: Boolean) extends OneOfUnion;
    case class OneOfDateTime(x: DateTime) extends OneOfUnion
  };
  case class Formula(
    field: String,
    expr: String);
  case class Config(
    viewport: Option[Double] = None,
    background: Option[String] = None,
    numberFormat: Option[String] = None,
    timeFormat: Option[String] = None,
    countTitle: Option[String] = None,
    cell: Option[CellConfig] = None,
    mark: Option[MarkConfig] = None,
    overlay: Option[OverlayConfig] = None,
    scale: Option[ScaleConfig] = None,
    axis: Option[AxisConfig] = None,
    legend: Option[LegendConfig] = None,
    facet: Option[FacetConfig] = None);
  case class CellConfig(
    width: Option[Double] = None,
    height: Option[Double] = None,
    clip: Option[Boolean] = None,
    fill: Option[String] = None,
    fillOpacity: Option[Double] = None,
    stroke: Option[String] = None,
    strokeOpacity: Option[Double] = None,
    strokeWidth: Option[Double] = None,
    strokeDash: Option[List[Double]] = None,
    strokeDashOffset: Option[Double] = None);
  case class MarkConfig(
    filled: Option[Boolean] = None,
    color: Option[String] = None,
    fill: Option[String] = None,
    stroke: Option[String] = None,
    opacity: Option[Double] = None,
    fillOpacity: Option[Double] = None,
    strokeOpacity: Option[Double] = None,
    strokeWidth: Option[Double] = None,
    strokeDash: Option[List[Double]] = None,
    strokeDashOffset: Option[Double] = None,
    stacked: Option[StackOffset] = None,
    orient: Option[Orient] = None,
    interpolate: Option[Interpolate] = None,
    tension: Option[Double] = None,
    lineSize: Option[Double] = None,
    ruleSize: Option[Double] = None,
    barSize: Option[Double] = None,
    barThinSize: Option[Double] = None,
    shape: Option[MarkConfig.ShapeUnion] = None,
    size: Option[Double] = None,
    tickSize: Option[Double] = None,
    tickThickness: Option[Double] = None,
    align: Option[HorizontalAlign] = None,
    angle: Option[Double] = None,
    baseline: Option[VerticalAlign] = None,
    dx: Option[Double] = None,
    dy: Option[Double] = None,
    radius: Option[Double] = None,
    theta: Option[Double] = None,
    font: Option[String] = None,
    fontSize: Option[Double] = None,
    fontStyle: Option[FontStyle] = None,
    fontWeight: Option[FontWeight] = None,
    format: Option[String] = None,
    shortTimeLabels: Option[Boolean] = None,
    text: Option[String] = None,
    applyColorToBackground: Option[Boolean] = None);
  object MarkConfig {
    @union sealed trait ShapeUnion extends scala.Product with scala.Serializable;
    case class ShapeShape(x: Shape) extends ShapeUnion;
    case class ShapeString(x: String) extends ShapeUnion
  };
  @enum sealed trait StackOffset extends scala.Product with scala.Serializable {
    def json: String
  };
  object StackOffsetEnums {
    case object Zero extends StackOffset with scala.Product with scala.Serializable {
      val json: String = "\"zero\""
    };
    case object Center extends StackOffset with scala.Product with scala.Serializable {
      val json: String = "\"center\""
    };
    case object Normalize extends StackOffset with scala.Product with scala.Serializable {
      val json: String = "\"normalize\""
    };
    case object None extends StackOffset with scala.Product with scala.Serializable {
      val json: String = "\"none\""
    }
  };
  @enum sealed trait Orient extends scala.Product with scala.Serializable {
    def json: String
  };
  object OrientEnums {
    case object Horizontal extends Orient with scala.Product with scala.Serializable {
      val json: String = "\"horizontal\""
    };
    case object Vertical extends Orient with scala.Product with scala.Serializable {
      val json: String = "\"vertical\""
    }
  };
  @enum sealed trait Interpolate extends scala.Product with scala.Serializable {
    def json: String
  };
  object InterpolateEnums {
    case object Linear extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"linear\""
    };
    case object LinearClosed extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"linear-closed\""
    };
    case object Step extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"step\""
    };
    case object StepBefore extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"step-before\""
    };
    case object StepAfter extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"step-after\""
    };
    case object Basis extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"basis\""
    };
    case object BasisOpen extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"basis-open\""
    };
    case object BasisClosed extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"basis-closed\""
    };
    case object Cardinal extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"cardinal\""
    };
    case object CardinalOpen extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"cardinal-open\""
    };
    case object CardinalClosed extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"cardinal-closed\""
    };
    case object Bundle extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"bundle\""
    };
    case object Monotone extends Interpolate with scala.Product with scala.Serializable {
      val json: String = "\"monotone\""
    }
  };
  @enum sealed trait Shape extends scala.Product with scala.Serializable {
    def json: String
  };
  object ShapeEnums {
    case object Circle extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"circle\""
    };
    case object Square extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"square\""
    };
    case object Cross extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"cross\""
    };
    case object Diamond extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"diamond\""
    };
    case object TriangleUp extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"triangle-up\""
    };
    case object TriangleDown extends Shape with scala.Product with scala.Serializable {
      val json: String = "\"triangle-down\""
    }
  };
  @enum sealed trait HorizontalAlign extends scala.Product with scala.Serializable {
    def json: String
  };
  object HorizontalAlignEnums {
    case object Left extends HorizontalAlign with scala.Product with scala.Serializable {
      val json: String = "\"left\""
    };
    case object Right extends HorizontalAlign with scala.Product with scala.Serializable {
      val json: String = "\"right\""
    };
    case object Center extends HorizontalAlign with scala.Product with scala.Serializable {
      val json: String = "\"center\""
    }
  };
  @enum sealed trait VerticalAlign extends scala.Product with scala.Serializable {
    def json: String
  };
  object VerticalAlignEnums {
    case object Top extends VerticalAlign with scala.Product with scala.Serializable {
      val json: String = "\"top\""
    };
    case object Middle extends VerticalAlign with scala.Product with scala.Serializable {
      val json: String = "\"middle\""
    };
    case object Bottom extends VerticalAlign with scala.Product with scala.Serializable {
      val json: String = "\"bottom\""
    }
  };
  @enum sealed trait FontStyle extends scala.Product with scala.Serializable {
    def json: String
  };
  object FontStyleEnums {
    case object Normal extends FontStyle with scala.Product with scala.Serializable {
      val json: String = "\"normal\""
    };
    case object Italic extends FontStyle with scala.Product with scala.Serializable {
      val json: String = "\"italic\""
    }
  };
  @enum sealed trait FontWeight extends scala.Product with scala.Serializable {
    def json: String
  };
  object FontWeightEnums {
    case object Normal extends FontWeight with scala.Product with scala.Serializable {
      val json: String = "\"normal\""
    };
    case object Bold extends FontWeight with scala.Product with scala.Serializable {
      val json: String = "\"bold\""
    }
  };
  case class OverlayConfig(
    line: Option[Boolean] = None,
    area: Option[AreaOverlay] = None,
    pointStyle: Option[MarkConfig] = None,
    lineStyle: Option[MarkConfig] = None);
  @enum sealed trait AreaOverlay extends scala.Product with scala.Serializable {
    def json: String
  };
  object AreaOverlayEnums {
    case object Line extends AreaOverlay with scala.Product with scala.Serializable {
      val json: String = "\"line\""
    };
    case object Linepoint extends AreaOverlay with scala.Product with scala.Serializable {
      val json: String = "\"linepoint\""
    };
    case object None extends AreaOverlay with scala.Product with scala.Serializable {
      val json: String = "\"none\""
    }
  };
  case class ScaleConfig(
    round: Option[Boolean] = None,
    textBandWidth: Option[Double] = None,
    rangeStep: Option[ScaleConfig.RangeStepUnion] = None,
    opacity: Option[List[Double]] = None,
    padding: Option[Double] = None,
    useRawDomain: Option[Boolean] = None,
    nominalColorRange: Option[ScaleConfig.NominalColorRangeUnion] = None,
    sequentialColorRange: Option[ScaleConfig.SequentialColorRangeUnion] = None,
    shapeRange: Option[ScaleConfig.ShapeRangeUnion] = None,
    barSizeRange: Option[List[Double]] = None,
    fontSizeRange: Option[List[Double]] = None,
    ruleSizeRange: Option[List[Double]] = None,
    tickSizeRange: Option[List[Double]] = None,
    pointSizeRange: Option[List[Double]] = None);
  object ScaleConfig {
    @union sealed trait RangeStepUnion extends scala.Product with scala.Serializable;
    case class RangeStepDouble(x: Double) extends RangeStepUnion;
    case class RangeStepRangeStep(x: RangeStep) extends RangeStepUnion;
    @union sealed trait NominalColorRangeUnion extends scala.Product with scala.Serializable;
    case class NominalColorRangeString(x: String) extends NominalColorRangeUnion;
    case class NominalColorRangeListString(x: List[String]) extends NominalColorRangeUnion;
    @union sealed trait SequentialColorRangeUnion extends scala.Product with scala.Serializable;
    case class SequentialColorRangeString(x: String) extends SequentialColorRangeUnion;
    case class SequentialColorRangeListString(x: List[String]) extends SequentialColorRangeUnion;
    @union sealed trait ShapeRangeUnion extends scala.Product with scala.Serializable;
    case class ShapeRangeString(x: String) extends ShapeRangeUnion;
    case class ShapeRangeListString(x: List[String]) extends ShapeRangeUnion
  };
  case class AxisConfig(
    axisWidth: Option[Double] = None,
    layer: Option[String] = None,
    offset: Option[Double] = None,
    axisColor: Option[String] = None,
    grid: Option[Boolean] = None,
    gridColor: Option[String] = None,
    gridDash: Option[List[Double]] = None,
    gridOpacity: Option[Double] = None,
    gridWidth: Option[Double] = None,
    labels: Option[Boolean] = None,
    labelAngle: Option[Double] = None,
    labelAlign: Option[String] = None,
    labelBaseline: Option[String] = None,
    labelMaxLength: Option[Double] = None,
    shortTimeLabels: Option[Boolean] = None,
    subdivide: Option[Double] = None,
    ticks: Option[Double] = None,
    tickColor: Option[String] = None,
    tickLabelColor: Option[String] = None,
    tickLabelFont: Option[String] = None,
    tickLabelFontSize: Option[Double] = None,
    tickPadding: Option[Double] = None,
    tickSize: Option[Double] = None,
    tickSizeMajor: Option[Double] = None,
    tickSizeMinor: Option[Double] = None,
    tickSizeEnd: Option[Double] = None,
    tickWidth: Option[Double] = None,
    titleColor: Option[String] = None,
    titleFont: Option[String] = None,
    titleFontSize: Option[Double] = None,
    titleFontWeight: Option[String] = None,
    titleOffset: Option[Double] = None,
    titleMaxLength: Option[Double] = None,
    characterWidth: Option[Double] = None,
    properties: Option[AxisConfig.Properties] = None);
  object AxisConfig {
    case class Properties(x: Any)
  };
  case class LegendConfig(
    orient: Option[String] = None,
    offset: Option[Double] = None,
    padding: Option[Double] = None,
    margin: Option[Double] = None,
    gradientStrokeColor: Option[String] = None,
    gradientStrokeWidth: Option[Double] = None,
    gradientHeight: Option[Double] = None,
    gradientWidth: Option[Double] = None,
    labelAlign: Option[String] = None,
    labelBaseline: Option[String] = None,
    labelColor: Option[String] = None,
    labelFont: Option[String] = None,
    labelFontSize: Option[Double] = None,
    labelOffset: Option[Double] = None,
    shortTimeLabels: Option[Boolean] = None,
    symbolColor: Option[String] = None,
    symbolShape: Option[String] = None,
    symbolSize: Option[Double] = None,
    symbolStrokeWidth: Option[Double] = None,
    titleColor: Option[String] = None,
    titleFont: Option[String] = None,
    titleFontSize: Option[Double] = None,
    titleFontWeight: Option[String] = None,
    properties: Option[LegendConfig.Properties] = None);
  object LegendConfig {
    case class Properties(x: Any)
  };
  case class FacetConfig(
    scale: Option[FacetScaleConfig] = None,
    axis: Option[AxisConfig] = None,
    grid: Option[FacetGridConfig] = None,
    cell: Option[CellConfig] = None);
  case class FacetScaleConfig(
    round: Option[Boolean] = None,
    padding: Option[Double] = None);
  case class FacetGridConfig(
    color: Option[String] = None,
    opacity: Option[Double] = None,
    offset: Option[Double] = None);
  case class FacetSpec(
    facet: Facet,
    spec: FacetSpec.SpecUnion,
    name: Option[String] = None,
    description: Option[String] = None,
    data: Option[Data] = None,
    transform: Option[Transform] = None,
    config: Option[Config] = None);
  object FacetSpec {
    @union sealed trait SpecUnion extends scala.Product with scala.Serializable;
    case class SpecLayerSpec(x: LayerSpec) extends SpecUnion;
    case class SpecUnitSpec(x: UnitSpec) extends SpecUnion
  };
  case class Facet(
    row: Option[PositionChannelDef] = None,
    column: Option[PositionChannelDef] = None);
  case class LayerSpec(
    width: Option[Double] = None,
    height: Option[Double] = None,
    layers: List[UnitSpec],
    name: Option[String] = None,
    description: Option[String] = None,
    data: Option[Data] = None,
    transform: Option[Transform] = None,
    config: Option[Config] = None);
  case class UnitSpec(
    width: Option[Double] = None,
    height: Option[Double] = None,
    mark: Mark,
    encoding: Option[UnitEncoding] = None,
    name: Option[String] = None,
    description: Option[String] = None,
    data: Option[Data] = None,
    transform: Option[Transform] = None,
    config: Option[Config] = None);
  case class UnitEncoding(
    x: Option[PositionChannelDef] = None,
    y: Option[PositionChannelDef] = None,
    x2: Option[FieldDef] = None,
    y2: Option[FieldDef] = None,
    color: Option[ChannelDefWithLegend] = None,
    opacity: Option[ChannelDefWithLegend] = None,
    size: Option[ChannelDefWithLegend] = None,
    shape: Option[ChannelDefWithLegend] = None,
    detail: Option[UnitEncoding.DetailUnion] = None,
    text: Option[FieldDef] = None,
    label: Option[FieldDef] = None,
    path: Option[UnitEncoding.PathUnion] = None,
    order: Option[UnitEncoding.OrderUnion] = None);
  object UnitEncoding {
    @union sealed trait DetailUnion extends scala.Product with scala.Serializable;
    case class DetailFieldDef(x: FieldDef) extends DetailUnion;
    case class DetailListFieldDef(x: List[FieldDef]) extends DetailUnion;
    @union sealed trait PathUnion extends scala.Product with scala.Serializable;
    case class PathOrderChannelDef(x: OrderChannelDef) extends PathUnion;
    case class PathListOrderChannelDef(x: List[OrderChannelDef]) extends PathUnion;
    @union sealed trait OrderUnion extends scala.Product with scala.Serializable;
    case class OrderOrderChannelDef(x: OrderChannelDef) extends OrderUnion;
    case class OrderListOrderChannelDef(x: List[OrderChannelDef]) extends OrderUnion
  };
  @union sealed trait VegaUnion extends scala.Product with scala.Serializable;
  case class VegaExtendedUnitSpec(x: ExtendedUnitSpec) extends VegaUnion;
  case class VegaFacetSpec(x: FacetSpec) extends VegaUnion;
  case class VegaLayerSpec(x: LayerSpec) extends VegaUnion;
  trait LowPriorityImplicits {
    import cats.syntax.either._;
    import io.circe._;
    import io.circe.syntax._;
    def anyEncoder: Encoder[Any] = Encoder.instance(((a: Any) => a match {
      case null => Json.Null
      case (b @ ((_): Boolean)) => b.asJson
      case (b @ ((_): Byte)) => b.asJson
      case (s @ ((_): Short)) => s.asJson
      case (i @ ((_): Int)) => i.asJson
      case (l @ ((_): Long)) => l.asJson
      case (f @ ((_): Float)) => f.asJson
      case (d @ ((_): Double)) => d.asJson
      case (s @ ((_): String)) => s.asJson
      case (a @ ((_): Array[Boolean] @unchecked)) => a.asJson
      case (a @ ((_): Array[Byte] @unchecked)) => a.asJson
      case (a @ ((_): Array[Short] @unchecked)) => a.asJson
      case (a @ ((_): Array[Int] @unchecked)) => a.asJson
      case (a @ ((_): Array[Long] @unchecked)) => a.asJson
      case (a @ ((_): Array[Float] @unchecked)) => a.asJson
      case (a @ ((_): Array[Double] @unchecked)) => a.asJson
      case (s @ ((_): Array[Any] @unchecked)) => s.asJson(Encoder.encodeTraversableOnce(
        anyEncoder,
        implicitly))
      case (s @ ((_): Seq[Any] @unchecked)) => s.asJson(Encoder.encodeTraversableOnce(
        anyEncoder,
        implicitly))
      case (ma @ ((_): Map[String, Any] @unchecked)) => ma.asJson(Encoder.encodeMapLike(
        KeyEncoder.encodeKeyString,
        anyEncoder))
    }));
    def anyDecoder: Decoder[Any] = Decoder.instance(((h: HCursor) => h.focus.get match {
      case (n @ _) if n.isNull => null
      case (n @ _) if n.isNumber => n.as[Double]
      case (b @ _) if b.isBoolean => b.as[Boolean]
      case (s @ _) if s.isString => s.as[String]
      case (o @ _) if o.isObject => o.as[Map[String, Any]](Decoder.decodeMapLike(
        KeyDecoder.decodeKeyString,
        anyDecoder,
        Map.canBuildFrom))
      case (a @ _) if a.isArray => a.as[List[Any]](Decoder.decodeCanBuildFrom(
        anyDecoder,
        List.canBuildFrom[Any]))
    }));
    implicit val SpecExtendedUnitSpecEncoder: Encoder[Spec.ExtendedUnitSpec] = Encoder.instance(((cc: Spec.ExtendedUnitSpec) => Json.obj(
      "width".->(cc.width.asJson),
      "height".->(cc.height.asJson),
      "mark".->(cc.mark.asJson),
      "encoding".->(cc.encoding.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val SpecExtendedUnitSpecDecoder: Decoder[Spec.ExtendedUnitSpec] = Decoder.instance { (c: HCursor) =>
      for {
        width <- c.downField("width").as[Option[Double]]
        height <- c.downField("height").as[Option[Double]]
        mark <- c.downField("mark").as[Mark]
        encoding <- c.downField("encoding").as[Option[Encoding]]
        name <- c.downField("name").as[Option[String]]
        description <- c.downField("description").as[Option[String]]
        data <- c.downField("data").as[Option[Data]]
        transform <- c.downField("transform").as[Option[Transform]]
        config <- c.downField("config").as[Option[Config]]
      } yield {
        Spec.ExtendedUnitSpec(
          width,
          height,
          mark,
          encoding,
          name,
          description,
          data,
          transform,
          config)
      }
    }
    implicit val SpecMarkEncoder: Encoder[Spec.Mark] = Encoder.instance(((e: Spec.Mark) => parser.parse(e.json).toOption.get));
    implicit val SpecMarkDecoder: Decoder[Spec.Mark] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"area\"").toOption.get) => Either.right(Spec.MarkEnums.Area)
        case (j @ _) if j.==(parser.parse("\"bar\"").toOption.get) => Either.right(Spec.MarkEnums.Bar)
        case (j @ _) if j.==(parser.parse("\"line\"").toOption.get) => Either.right(Spec.MarkEnums.Line)
        case (j @ _) if j.==(parser.parse("\"point\"").toOption.get) => Either.right(Spec.MarkEnums.Point)
        case (j @ _) if j.==(parser.parse("\"text\"").toOption.get) => Either.right(Spec.MarkEnums.Text)
        case (j @ _) if j.==(parser.parse("\"tick\"").toOption.get) => Either.right(Spec.MarkEnums.Tick)
        case (j @ _) if j.==(parser.parse("\"rule\"").toOption.get) => Either.right(Spec.MarkEnums.Rule)
        case (j @ _) if j.==(parser.parse("\"circle\"").toOption.get) => Either.right(Spec.MarkEnums.Circle)
        case (j @ _) if j.==(parser.parse("\"square\"").toOption.get) => Either.right(Spec.MarkEnums.Square)
        case (j @ _) if j.==(parser.parse("\"errorBar\"").toOption.get) => Either.right(Spec.MarkEnums.ErrorBar)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecEncodingEncoder: Encoder[Spec.Encoding] = Encoder.instance(((cc: Spec.Encoding) => Json.obj(
      "row".->(cc.row.asJson),
      "column".->(cc.column.asJson),
      "x".->(cc.x.asJson),
      "y".->(cc.y.asJson),
      "x2".->(cc.x2.asJson),
      "y2".->(cc.y2.asJson),
      "color".->(cc.color.asJson),
      "opacity".->(cc.opacity.asJson),
      "size".->(cc.size.asJson),
      "shape".->(cc.shape.asJson),
      "detail".->(cc.detail.asJson),
      "text".->(cc.text.asJson),
      "label".->(cc.label.asJson),
      "path".->(cc.path.asJson),
      "order".->(cc.order.asJson))));
    implicit val SpecEncodingDecoder: Decoder[Spec.Encoding] = Decoder.instance { (c: HCursor) =>
      for {
        row <- c.downField("row").as[Option[PositionChannelDef]]
        column <- c.downField("column").as[Option[PositionChannelDef]]
        x <- c.downField("x").as[Option[PositionChannelDef]]
        y <- c.downField("y").as[Option[PositionChannelDef]]
        x2 <- c.downField("x2").as[Option[FieldDef]]
        y2 <- c.downField("y2").as[Option[FieldDef]]
        color <- c.downField("color").as[Option[ChannelDefWithLegend]]
        opacity <- c.downField("opacity").as[Option[ChannelDefWithLegend]]
        size <- c.downField("size").as[Option[ChannelDefWithLegend]]
        shape <- c.downField("shape").as[Option[ChannelDefWithLegend]]
        detail <- c.downField("detail").as[Option[Encoding.DetailUnion]]
        text <- c.downField("text").as[Option[FieldDef]]
        label <- c.downField("label").as[Option[FieldDef]]
        path <- c.downField("path").as[Option[Encoding.PathUnion]]
        order <- c.downField("order").as[Option[Encoding.OrderUnion]]
      } yield {
        Spec.Encoding(
          row,
          column,
          x,
          y,
          x2,
          y2,
          color,
          opacity,
          size,
          shape,
          detail,
          text,
          label,
          path,
          order)
      }
    }
    implicit val SpecEncodingDetailUnionEncoder: Encoder[Spec.Encoding.DetailUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Encoding.DetailFieldDef)) => ut.x.asJson
      case (ut @ ((_): Spec.Encoding.DetailListFieldDef)) => ut.x.asJson
    });
    implicit val SpecEncodingDetailUnionDecoder: Decoder[Spec.Encoding.DetailUnion] = Decoder.instance(((c: HCursor) => c.as[FieldDef].map(((x) => Spec.Encoding.DetailFieldDef(x))).orElse(c.as[List[FieldDef]].map(((x) => Spec.Encoding.DetailListFieldDef(x))))));
    implicit val SpecEncodingPathUnionEncoder: Encoder[Spec.Encoding.PathUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Encoding.PathOrderChannelDef)) => ut.x.asJson
      case (ut @ ((_): Spec.Encoding.PathListOrderChannelDef)) => ut.x.asJson
    });
    implicit val SpecEncodingPathUnionDecoder: Decoder[Spec.Encoding.PathUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec.Encoding.PathOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec.Encoding.PathListOrderChannelDef(x))))));
    implicit val SpecEncodingOrderUnionEncoder: Encoder[Spec.Encoding.OrderUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Encoding.OrderOrderChannelDef)) => ut.x.asJson
      case (ut @ ((_): Spec.Encoding.OrderListOrderChannelDef)) => ut.x.asJson
    });
    implicit val SpecEncodingOrderUnionDecoder: Decoder[Spec.Encoding.OrderUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec.Encoding.OrderOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec.Encoding.OrderListOrderChannelDef(x))))));
    implicit val SpecPositionChannelDefEncoder: Encoder[Spec.PositionChannelDef] = Encoder.instance(((cc: Spec.PositionChannelDef) => Json.obj(
      "axis".->(cc.axis.asJson),
      "scale".->(cc.scale.asJson),
      "sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val SpecPositionChannelDefDecoder: Decoder[Spec.PositionChannelDef] = Decoder.instance { (c: HCursor) =>
      for {
        axis <- c.downField("axis").as[Option[PositionChannelDef.AxisUnion]]
        scale <- c.downField("scale").as[Option[Scale]]
        sort <- c.downField("sort").as[Option[PositionChannelDef.SortUnion]]
        field <- c.downField("field").as[Option[String]]
        `type` <- c.downField("type").as[Option[Type]]
        value <- c.downField("value").as[Option[PositionChannelDef.ValueUnion]]
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        bin <- c.downField("bin").as[Option[PositionChannelDef.BinUnion]]
        aggregate <- c.downField("aggregate").as[Option[AggregateOp]]
        title <- c.downField("title").as[Option[String]]
      } yield {
        Spec.PositionChannelDef(
          axis,
          scale,
          sort,
          field,
          `type`,
          value,
          timeUnit,
          bin,
          aggregate,
          title)
      }
    }
    implicit val SpecPositionChannelDefAxisUnionEncoder: Encoder[Spec.PositionChannelDef.AxisUnion] = Encoder.instance({
      case (ut @ ((_): Spec.PositionChannelDef.AxisBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.PositionChannelDef.AxisAxis)) => ut.x.asJson
    });
    implicit val SpecPositionChannelDefAxisUnionDecoder: Decoder[Spec.PositionChannelDef.AxisUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.PositionChannelDef.AxisBoolean(x))).orElse(c.as[Axis].map(((x) => Spec.PositionChannelDef.AxisAxis(x))))));
    implicit val SpecPositionChannelDefSortUnionEncoder: Encoder[Spec.PositionChannelDef.SortUnion] = Encoder.instance({
      case (ut @ ((_): Spec.PositionChannelDef.SortSortField)) => ut.x.asJson
      case (ut @ ((_): Spec.PositionChannelDef.SortSortOrder)) => ut.x.asJson
    });
    implicit val SpecPositionChannelDefSortUnionDecoder: Decoder[Spec.PositionChannelDef.SortUnion] = Decoder.instance(((c: HCursor) => c.as[SortField].map(((x) => Spec.PositionChannelDef.SortSortField(x))).orElse(c.as[SortOrder].map(((x) => Spec.PositionChannelDef.SortSortOrder(x))))));
    implicit val SpecPositionChannelDefValueUnionEncoder: Encoder[Spec.PositionChannelDef.ValueUnion] = Encoder.instance({
      case (ut @ ((_): Spec.PositionChannelDef.ValueDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.PositionChannelDef.ValueString)) => ut.x.asJson
      case (ut @ ((_): Spec.PositionChannelDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val SpecPositionChannelDefValueUnionDecoder: Decoder[Spec.PositionChannelDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.PositionChannelDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec.PositionChannelDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec.PositionChannelDef.ValueBoolean(x))))));
    implicit val SpecPositionChannelDefBinUnionEncoder: Encoder[Spec.PositionChannelDef.BinUnion] = Encoder.instance({
      case (ut @ ((_): Spec.PositionChannelDef.BinBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.PositionChannelDef.BinBin)) => ut.x.asJson
    });
    implicit val SpecPositionChannelDefBinUnionDecoder: Decoder[Spec.PositionChannelDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.PositionChannelDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec.PositionChannelDef.BinBin(x))))));
    implicit val SpecAxisEncoder: Encoder[Spec.Axis] = Encoder.instance { (cc: Spec.Axis) =>
      Json.obj(
        "labelAngle".->(cc.labelAngle.asJson),
        "format".->(cc.format.asJson),
        "orient".->(cc.orient.asJson),
        "title".->(cc.title.asJson),
        "values".->(cc.values.asJson),
        "axisWidth".->(cc.axisWidth.asJson),
        "layer".->(cc.layer.asJson),
        "offset".->(cc.offset.asJson),
        "axisColor".->(cc.axisColor.asJson),
        "grid".->(cc.grid.asJson),
        "gridColor".->(cc.gridColor.asJson),
        "gridDash".->(cc.gridDash.asJson),
        "gridOpacity".->(cc.gridOpacity.asJson),
        "gridWidth".->(cc.gridWidth.asJson),
        "labels".->(cc.labels.asJson),
        "labelAlign".->(cc.labelAlign.asJson),
        "labelBaseline".->(cc.labelBaseline.asJson),
        "labelMaxLength".->(cc.labelMaxLength.asJson),
        "shortTimeLabels".->(cc.shortTimeLabels.asJson),
        "subdivide".->(cc.subdivide.asJson),
        "ticks".->(cc.ticks.asJson),
        "tickColor".->(cc.tickColor.asJson),
        "tickLabelColor".->(cc.tickLabelColor.asJson),
        "tickLabelFont".->(cc.tickLabelFont.asJson),
        "tickLabelFontSize".->(cc.tickLabelFontSize.asJson),
        "tickPadding".->(cc.tickPadding.asJson),
        "tickSize".->(cc.tickSize.asJson),
        "tickSizeMajor".->(cc.tickSizeMajor.asJson),
        "tickSizeMinor".->(cc.tickSizeMinor.asJson),
        "tickSizeEnd".->(cc.tickSizeEnd.asJson),
        "tickWidth".->(cc.tickWidth.asJson),
        "titleColor".->(cc.titleColor.asJson),
        "titleFont".->(cc.titleFont.asJson),
        "titleFontSize".->(cc.titleFontSize.asJson),
        "titleFontWeight".->(cc.titleFontWeight.asJson),
        "titleOffset".->(cc.titleOffset.asJson),
        "titleMaxLength".->(cc.titleMaxLength.asJson),
        "characterWidth".->(cc.characterWidth.asJson),
        "properties".->(cc.properties.asJson))
    }
    implicit val SpecAxisDecoder: Decoder[Spec.Axis] = Decoder.instance { (c: HCursor) =>
      for {
        labelAngle <- c.downField("labelAngle").as[Option[Double]]
        format <- c.downField("format").as[Option[String]]
        orient <- c.downField("orient").as[Option[AxisOrient]]
        title <- c.downField("title").as[Option[String]]
        values <- c.downField("values").as[Option[List[Double]]]
        axisWidth <- c.downField("axisWidth").as[Option[Double]]
        layer <- c.downField("layer").as[Option[String]]
        offset <- c.downField("offset").as[Option[Double]]
        axisColor <- c.downField("axisColor").as[Option[String]]
        grid <- c.downField("grid").as[Option[Boolean]]
        gridColor <- c.downField("gridColor").as[Option[String]]
        gridDash <- c.downField("gridDash").as[Option[List[Double]]]
        gridOpacity <- c.downField("gridOpacity").as[Option[Double]]
        gridWidth <- c.downField("gridWidth").as[Option[Double]]
        labels <- c.downField("labels").as[Option[Boolean]]
        labelAlign <- c.downField("labelAlign").as[Option[String]]
        labelBaseline <- c.downField("labelBaseline").as[Option[String]]
        labelMaxLength <- c.downField("labelMaxLength").as[Option[Double]]
        shortTimeLabels <- c.downField("shortTimeLabels").as[Option[Boolean]]
        subdivide <- c.downField("subdivide").as[Option[Double]]
        ticks <- c.downField("ticks").as[Option[Double]]
        tickColor <- c.downField("tickColor").as[Option[String]]
        tickLabelColor <- c.downField("tickLabelColor").as[Option[String]]
        tickLabelFont <- c.downField("tickLabelFont").as[Option[String]]
        tickLabelFontSize <- c.downField("tickLabelFontSize").as[Option[Double]]
        tickPadding <- c.downField("tickPadding").as[Option[Double]]
        tickSize <- c.downField("tickSize").as[Option[Double]]
        tickSizeMajor <- c.downField("tickSizeMajor").as[Option[Double]]
        tickSizeMinor <- c.downField("tickSizeMinor").as[Option[Double]]
        tickSizeEnd <- c.downField("tickSizeEnd").as[Option[Double]]
        tickWidth <- c.downField("tickWidth").as[Option[Double]]
        titleColor <- c.downField("titleColor").as[Option[String]]
        titleFont <- c.downField("titleFont").as[Option[String]]
        titleFontSize <- c.downField("titleFontSize").as[Option[Double]]
        titleFontWeight <- c.downField("titleFontWeight").as[Option[String]]
        titleOffset <- c.downField("titleOffset").as[Option[Double]]
        titleMaxLength <- c.downField("titleMaxLength").as[Option[Double]]
        characterWidth <- c.downField("characterWidth").as[Option[Double]]
        properties <- c.downField("properties").as[Option[Axis.Properties]]
      } yield {
        Spec.Axis(
          labelAngle,
          format,
          orient,
          title,
          values,
          axisWidth,
          layer,
          offset,
          axisColor,
          grid,
          gridColor,
          gridDash,
          gridOpacity,
          gridWidth,
          labels,
          labelAlign,
          labelBaseline,
          labelMaxLength,
          shortTimeLabels,
          subdivide,
          ticks,
          tickColor,
          tickLabelColor,
          tickLabelFont,
          tickLabelFontSize,
          tickPadding,
          tickSize,
          tickSizeMajor,
          tickSizeMinor,
          tickSizeEnd,
          tickWidth,
          titleColor,
          titleFont,
          titleFontSize,
          titleFontWeight,
          titleOffset,
          titleMaxLength,
          characterWidth,
          properties)
      }
    }

    implicit val SpecAxisPropertiesEncoder: Encoder[Spec.Axis.Properties] = Encoder.instance(((wrapper: Spec.Axis.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecAxisPropertiesDecoder: Decoder[Spec.Axis.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$1) => Spec.Axis.Properties(x$1)))));
    implicit val SpecAxisOrientEncoder: Encoder[Spec.AxisOrient] = Encoder.instance(((e: Spec.AxisOrient) => parser.parse(e.json).toOption.get));
    implicit val SpecAxisOrientDecoder: Decoder[Spec.AxisOrient] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"top\"").toOption.get) => Either.right(Spec.AxisOrientEnums.Top)
        case (j @ _) if j.==(parser.parse("\"right\"").toOption.get) => Either.right(Spec.AxisOrientEnums.Right)
        case (j @ _) if j.==(parser.parse("\"left\"").toOption.get) => Either.right(Spec.AxisOrientEnums.Left)
        case (j @ _) if j.==(parser.parse("\"bottom\"").toOption.get) => Either.right(Spec.AxisOrientEnums.Bottom)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecScaleEncoder: Encoder[Spec.Scale] = Encoder.instance(((cc: Spec.Scale) => Json.obj(
      "type".->(cc.`type`.asJson),
      "domain".->(cc.domain.asJson),
      "range".->(cc.range.asJson),
      "round".->(cc.round.asJson),
      "rangeStep".->(cc.rangeStep.asJson),
      "padding".->(cc.padding.asJson),
      "clamp".->(cc.clamp.asJson),
      "nice".->(cc.nice.asJson),
      "exponent".->(cc.exponent.asJson),
      "zero".->(cc.zero.asJson),
      "useRawDomain".->(cc.useRawDomain.asJson))));
    implicit val SpecScaleDecoder: Decoder[Spec.Scale] = Decoder.instance { (c: HCursor) =>
      for {
        `type` <- c.downField("type").as[Option[ScaleType]]
        domain <- c.downField("domain").as[Option[Scale.DomainUnion]]
        range <- c.downField("range").as[Option[Scale.RangeUnion]]
        round <- c.downField("round").as[Option[Boolean]]
        rangeStep <- c.downField("rangeStep").as[Option[Scale.RangeStepUnion]]
        padding <- c.downField("padding").as[Option[Double]]
        clamp <- c.downField("clamp").as[Option[Boolean]]
        nice <- c.downField("nice").as[Option[Scale.NiceUnion]]
        exponent <- c.downField("exponent").as[Option[Double]]
        zero <- c.downField("zero").as[Option[Boolean]]
        useRawDomain <- c.downField("useRawDomain").as[Option[Boolean]]
      } yield {
        Spec.Scale(
          `type`,
          domain,
          range,
          round,
          rangeStep,
          padding,
          clamp,
          nice,
          exponent,
          zero,
          useRawDomain)
      }
    }
    implicit val SpecScaleDomainUnionEncoder: Encoder[Spec.Scale.DomainUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Scale.DomainListDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.Scale.DomainListString)) => ut.x.asJson
    });
    implicit val SpecScaleDomainUnionDecoder: Decoder[Spec.Scale.DomainUnion] = Decoder.instance(((c: HCursor) => c.as[List[Double]].map(((x) => Spec.Scale.DomainListDouble(x))).orElse(c.as[List[String]].map(((x) => Spec.Scale.DomainListString(x))))));
    implicit val SpecScaleRangeUnionEncoder: Encoder[Spec.Scale.RangeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Scale.RangeString)) => ut.x.asJson
      case (ut @ ((_): Spec.Scale.RangeListDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.Scale.RangeListString)) => ut.x.asJson
    });
    implicit val SpecScaleRangeUnionDecoder: Decoder[Spec.Scale.RangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.Scale.RangeString(x))).orElse(c.as[List[Double]].map(((x) => Spec.Scale.RangeListDouble(x)))).orElse(c.as[List[String]].map(((x) => Spec.Scale.RangeListString(x))))));
    implicit val SpecScaleRangeStepUnionEncoder: Encoder[Spec.Scale.RangeStepUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Scale.RangeStepDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.Scale.RangeStepRangeStep)) => ut.x.asJson
    });
    implicit val SpecScaleRangeStepUnionDecoder: Decoder[Spec.Scale.RangeStepUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.Scale.RangeStepDouble(x))).orElse(c.as[RangeStep].map(((x) => Spec.Scale.RangeStepRangeStep(x))))));
    implicit val SpecScaleNiceUnionEncoder: Encoder[Spec.Scale.NiceUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Scale.NiceBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.Scale.NiceNiceTime)) => ut.x.asJson
    });
    implicit val SpecScaleNiceUnionDecoder: Decoder[Spec.Scale.NiceUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.Scale.NiceBoolean(x))).orElse(c.as[NiceTime].map(((x) => Spec.Scale.NiceNiceTime(x))))));
    implicit val SpecScaleTypeEncoder: Encoder[Spec.ScaleType] = Encoder.instance(((e: Spec.ScaleType) => parser.parse(e.json).toOption.get));
    implicit val SpecScaleTypeDecoder: Decoder[Spec.ScaleType] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"linear\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Linear)
        case (j @ _) if j.==(parser.parse("\"log\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Log)
        case (j @ _) if j.==(parser.parse("\"pow\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Pow)
        case (j @ _) if j.==(parser.parse("\"sqrt\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Sqrt)
        case (j @ _) if j.==(parser.parse("\"quantile\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Quantile)
        case (j @ _) if j.==(parser.parse("\"quantize\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Quantize)
        case (j @ _) if j.==(parser.parse("\"ordinal\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Ordinal)
        case (j @ _) if j.==(parser.parse("\"time\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Time)
        case (j @ _) if j.==(parser.parse("\"utc\"").toOption.get) => Either.right(Spec.ScaleTypeEnums.Utc)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecRangeStepEncoder: Encoder[Spec.RangeStep] = Encoder.instance(((e: Spec.RangeStep) => parser.parse(e.json).toOption.get));
    implicit val SpecRangeStepDecoder: Decoder[Spec.RangeStep] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"fit\"").toOption.get) => Either.right(Spec.RangeStepEnums.Fit)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecNiceTimeEncoder: Encoder[Spec.NiceTime] = Encoder.instance(((e: Spec.NiceTime) => parser.parse(e.json).toOption.get));
    implicit val SpecNiceTimeDecoder: Decoder[Spec.NiceTime] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"second\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Second)
        case (j @ _) if j.==(parser.parse("\"minute\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Minute)
        case (j @ _) if j.==(parser.parse("\"hour\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Hour)
        case (j @ _) if j.==(parser.parse("\"day\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Day)
        case (j @ _) if j.==(parser.parse("\"week\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Week)
        case (j @ _) if j.==(parser.parse("\"month\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Month)
        case (j @ _) if j.==(parser.parse("\"year\"").toOption.get) => Either.right(Spec.NiceTimeEnums.Year)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecSortFieldEncoder: Encoder[Spec.SortField] = Encoder.instance(((cc: Spec.SortField) => Json.obj(
      "field".->(cc.field.asJson),
      "op".->(cc.op.asJson),
      "order".->(cc.order.asJson))));
    implicit val SpecSortFieldDecoder: Decoder[Spec.SortField] = Decoder.instance { (c: HCursor) =>
      for {
        field <- c.downField("field").as[String]
        op <- c.downField("op").as[AggregateOp]
        order <- c.downField("order").as[Option[SortOrder]]
      } yield {
        Spec.SortField(
          field,
          op,
          order)
      }
    }
    implicit val SpecAggregateOpEncoder: Encoder[Spec.AggregateOp] = Encoder.instance(((e: Spec.AggregateOp) => parser.parse(e.json).toOption.get));
    implicit val SpecAggregateOpDecoder: Decoder[Spec.AggregateOp] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"values\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Values)
        case (j @ _) if j.==(parser.parse("\"count\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Count)
        case (j @ _) if j.==(parser.parse("\"valid\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Valid)
        case (j @ _) if j.==(parser.parse("\"missing\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Missing)
        case (j @ _) if j.==(parser.parse("\"distinct\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Distinct)
        case (j @ _) if j.==(parser.parse("\"sum\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Sum)
        case (j @ _) if j.==(parser.parse("\"mean\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Mean)
        case (j @ _) if j.==(parser.parse("\"average\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Average)
        case (j @ _) if j.==(parser.parse("\"variance\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Variance)
        case (j @ _) if j.==(parser.parse("\"variancep\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Variancep)
        case (j @ _) if j.==(parser.parse("\"stdev\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Stdev)
        case (j @ _) if j.==(parser.parse("\"stdevp\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Stdevp)
        case (j @ _) if j.==(parser.parse("\"median\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Median)
        case (j @ _) if j.==(parser.parse("\"q1\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Q1)
        case (j @ _) if j.==(parser.parse("\"q3\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Q3)
        case (j @ _) if j.==(parser.parse("\"modeskew\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Modeskew)
        case (j @ _) if j.==(parser.parse("\"min\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Min)
        case (j @ _) if j.==(parser.parse("\"max\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Max)
        case (j @ _) if j.==(parser.parse("\"argmin\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Argmin)
        case (j @ _) if j.==(parser.parse("\"argmax\"").toOption.get) => Either.right(Spec.AggregateOpEnums.Argmax)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecSortOrderEncoder: Encoder[Spec.SortOrder] = Encoder.instance(((e: Spec.SortOrder) => parser.parse(e.json).toOption.get));
    implicit val SpecSortOrderDecoder: Decoder[Spec.SortOrder] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"ascending\"").toOption.get) => Either.right(Spec.SortOrderEnums.Ascending)
        case (j @ _) if j.==(parser.parse("\"descending\"").toOption.get) => Either.right(Spec.SortOrderEnums.Descending)
        case (j @ _) if j.==(parser.parse("\"none\"").toOption.get) => Either.right(Spec.SortOrderEnums.None)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecTypeEncoder: Encoder[Spec.Type] = Encoder.instance(((e: Spec.Type) => parser.parse(e.json).toOption.get));
    implicit val SpecTypeDecoder: Decoder[Spec.Type] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"quantitative\"").toOption.get) => Either.right(Spec.TypeEnums.Quantitative)
        case (j @ _) if j.==(parser.parse("\"ordinal\"").toOption.get) => Either.right(Spec.TypeEnums.Ordinal)
        case (j @ _) if j.==(parser.parse("\"temporal\"").toOption.get) => Either.right(Spec.TypeEnums.Temporal)
        case (j @ _) if j.==(parser.parse("\"nominal\"").toOption.get) => Either.right(Spec.TypeEnums.Nominal)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecTimeUnitEncoder: Encoder[Spec.TimeUnit] = Encoder.instance(((e: Spec.TimeUnit) => parser.parse(e.json).toOption.get));
    implicit val SpecTimeUnitDecoder: Decoder[Spec.TimeUnit] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"year\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Year)
        case (j @ _) if j.==(parser.parse("\"month\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Month)
        case (j @ _) if j.==(parser.parse("\"day\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Day)
        case (j @ _) if j.==(parser.parse("\"date\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Date)
        case (j @ _) if j.==(parser.parse("\"hours\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Hours)
        case (j @ _) if j.==(parser.parse("\"minutes\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Minutes)
        case (j @ _) if j.==(parser.parse("\"seconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Seconds)
        case (j @ _) if j.==(parser.parse("\"milliseconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Milliseconds)
        case (j @ _) if j.==(parser.parse("\"yearmonth\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearmonth)
        case (j @ _) if j.==(parser.parse("\"yearmonthdate\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearmonthdate)
        case (j @ _) if j.==(parser.parse("\"yearmonthdatehours\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearmonthdatehours)
        case (j @ _) if j.==(parser.parse("\"yearmonthdatehoursminutes\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearmonthdatehoursminutes)
        case (j @ _) if j.==(parser.parse("\"yearmonthdatehoursminutesseconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearmonthdatehoursminutesseconds)
        case (j @ _) if j.==(parser.parse("\"hoursminutes\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Hoursminutes)
        case (j @ _) if j.==(parser.parse("\"hoursminutesseconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Hoursminutesseconds)
        case (j @ _) if j.==(parser.parse("\"minutesseconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Minutesseconds)
        case (j @ _) if j.==(parser.parse("\"secondsmilliseconds\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Secondsmilliseconds)
        case (j @ _) if j.==(parser.parse("\"quarter\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Quarter)
        case (j @ _) if j.==(parser.parse("\"yearquarter\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearquarter)
        case (j @ _) if j.==(parser.parse("\"quartermonth\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Quartermonth)
        case (j @ _) if j.==(parser.parse("\"yearquartermonth\"").toOption.get) => Either.right(Spec.TimeUnitEnums.Yearquartermonth)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecBinEncoder: Encoder[Spec.Bin] = Encoder.instance(((cc: Spec.Bin) => Json.obj(
      "min".->(cc.min.asJson),
      "max".->(cc.max.asJson),
      "base".->(cc.base.asJson),
      "step".->(cc.step.asJson),
      "steps".->(cc.steps.asJson),
      "minstep".->(cc.minstep.asJson),
      "div".->(cc.div.asJson),
      "maxbins".->(cc.maxbins.asJson))));
    implicit val SpecBinDecoder: Decoder[Spec.Bin] = Decoder.instance { (c: HCursor) =>
      for {
        min <- c.downField("min").as[Option[Double]]
        max <- c.downField("max").as[Option[Double]]
        base <- c.downField("base").as[Option[Double]]
        step <- c.downField("step").as[Option[Double]]
        steps <- c.downField("steps").as[Option[List[Double]]]
        minstep <- c.downField("minstep").as[Option[Double]]
        div <- c.downField("div").as[Option[List[Double]]]
        maxbins <- c.downField("maxbins").as[Option[Double]]
      } yield {
        Spec.Bin(
          min,
          max,
          base,
          step,
          steps,
          minstep,
          div,
          maxbins)
      }
    }
    implicit val SpecFieldDefEncoder: Encoder[Spec.FieldDef] = Encoder.instance(((cc: Spec.FieldDef) => Json.obj(
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val SpecFieldDefDecoder: Decoder[Spec.FieldDef] = Decoder.instance { (c: HCursor) =>
      for {
        field <- c.downField("field").as[Option[String]]
        `type` <- c.downField("type").as[Option[Type]]
        value <- c.downField("value").as[Option[FieldDef.ValueUnion]]
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        bin <- c.downField("bin").as[Option[FieldDef.BinUnion]]
        aggregate <- c.downField("aggregate").as[Option[AggregateOp]]
        title <- c.downField("title").as[Option[String]]
      } yield {
        Spec.FieldDef(
          field,
          `type`,
          value,
          timeUnit,
          bin,
          aggregate,
          title)
      }
    }

    implicit val SpecFieldDefValueUnionEncoder: Encoder[Spec.FieldDef.ValueUnion] = Encoder.instance({
      case (ut @ ((_): Spec.FieldDef.ValueDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.FieldDef.ValueString)) => ut.x.asJson
      case (ut @ ((_): Spec.FieldDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val SpecFieldDefValueUnionDecoder: Decoder[Spec.FieldDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.FieldDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec.FieldDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec.FieldDef.ValueBoolean(x))))));
    implicit val SpecFieldDefBinUnionEncoder: Encoder[Spec.FieldDef.BinUnion] = Encoder.instance({
      case (ut @ ((_): Spec.FieldDef.BinBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.FieldDef.BinBin)) => ut.x.asJson
    });
    implicit val SpecFieldDefBinUnionDecoder: Decoder[Spec.FieldDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.FieldDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec.FieldDef.BinBin(x))))));
    implicit val SpecChannelDefWithLegendEncoder: Encoder[Spec.ChannelDefWithLegend] = Encoder.instance(((cc: Spec.ChannelDefWithLegend) => Json.obj(
      "legend".->(cc.legend.asJson),
      "scale".->(cc.scale.asJson),
      "sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val SpecChannelDefWithLegendDecoder: Decoder[Spec.ChannelDefWithLegend] = Decoder.instance { (c: HCursor) =>
      for {
        legend <- c.downField("legend").as[Option[Legend]]
        scale <- c.downField("scale").as[Option[Scale]]
        sort <- c.downField("sort").as[Option[ChannelDefWithLegend.SortUnion]]
        field <- c.downField("field").as[Option[String]]
        type_ <- c.downField("type").as[Option[Type]]
        value <- c.downField("value").as[Option[ChannelDefWithLegend.ValueUnion]]
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        bin <- c.downField("bin").as[Option[ChannelDefWithLegend.BinUnion]]
        aggregate <- c.downField("aggregate").as[Option[AggregateOp]]
        title <- c.downField("title").as[Option[String]]
      } yield {
        Spec.ChannelDefWithLegend(
          legend,
          scale,
          sort,
          field,
          type_,
          value,
          timeUnit,
          bin,
          aggregate,
          title)
      }
    }
    implicit val SpecChannelDefWithLegendSortUnionEncoder: Encoder[Spec.ChannelDefWithLegend.SortUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ChannelDefWithLegend.SortSortField)) => ut.x.asJson
      case (ut @ ((_): Spec.ChannelDefWithLegend.SortSortOrder)) => ut.x.asJson
    });
    implicit val SpecChannelDefWithLegendSortUnionDecoder: Decoder[Spec.ChannelDefWithLegend.SortUnion] = Decoder.instance(((c: HCursor) => c.as[SortField].map(((x) => Spec.ChannelDefWithLegend.SortSortField(x))).orElse(c.as[SortOrder].map(((x) => Spec.ChannelDefWithLegend.SortSortOrder(x))))));
    implicit val SpecChannelDefWithLegendValueUnionEncoder: Encoder[Spec.ChannelDefWithLegend.ValueUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ChannelDefWithLegend.ValueDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.ChannelDefWithLegend.ValueString)) => ut.x.asJson
      case (ut @ ((_): Spec.ChannelDefWithLegend.ValueBoolean)) => ut.x.asJson
    });
    implicit val SpecChannelDefWithLegendValueUnionDecoder: Decoder[Spec.ChannelDefWithLegend.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.ChannelDefWithLegend.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec.ChannelDefWithLegend.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec.ChannelDefWithLegend.ValueBoolean(x))))));
    implicit val SpecChannelDefWithLegendBinUnionEncoder: Encoder[Spec.ChannelDefWithLegend.BinUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ChannelDefWithLegend.BinBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.ChannelDefWithLegend.BinBin)) => ut.x.asJson
    });
    implicit val SpecChannelDefWithLegendBinUnionDecoder: Decoder[Spec.ChannelDefWithLegend.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.ChannelDefWithLegend.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec.ChannelDefWithLegend.BinBin(x))))));
    implicit val SpecLegendEncoder: Encoder[Spec.Legend] = Encoder.instance(((cc: Spec.Legend) => Json.obj(
      "format".->(cc.format.asJson),
      "title".->(cc.title.asJson),
      "values".->(cc.values.asJson),
      "orient".->(cc.orient.asJson),
      "offset".->(cc.offset.asJson),
      "padding".->(cc.padding.asJson),
      "margin".->(cc.margin.asJson),
      "gradientStrokeColor".->(cc.gradientStrokeColor.asJson),
      "gradientStrokeWidth".->(cc.gradientStrokeWidth.asJson),
      "gradientHeight".->(cc.gradientHeight.asJson),
      "gradientWidth".->(cc.gradientWidth.asJson),
      "labelAlign".->(cc.labelAlign.asJson),
      "labelBaseline".->(cc.labelBaseline.asJson),
      "labelColor".->(cc.labelColor.asJson),
      "labelFont".->(cc.labelFont.asJson),
      "labelFontSize".->(cc.labelFontSize.asJson),
      "labelOffset".->(cc.labelOffset.asJson),
      "shortTimeLabels".->(cc.shortTimeLabels.asJson),
      "symbolColor".->(cc.symbolColor.asJson),
      "symbolShape".->(cc.symbolShape.asJson),
      "symbolSize".->(cc.symbolSize.asJson),
      "symbolStrokeWidth".->(cc.symbolStrokeWidth.asJson),
      "titleColor".->(cc.titleColor.asJson),
      "titleFont".->(cc.titleFont.asJson),
      "titleFontSize".->(cc.titleFontSize.asJson),
      "titleFontWeight".->(cc.titleFontWeight.asJson),
      "properties".->(cc.properties.asJson))));
    implicit val SpecLegendDecoder: Decoder[Spec.Legend] = Decoder.instance { (c: HCursor) =>
      for {
        format <- c.downField("format").as[Option[String]]
        title <- c.downField("title").as[Option[String]]
        values <- c.downField("values").as[Option[List[Legend.Values]]]
        orient <- c.downField("orient").as[Option[String]]
        offset <- c.downField("offset").as[Option[Double]]
        padding <- c.downField("padding").as[Option[Double]]
        margin <- c.downField("margin").as[Option[Double]]
        gradientStrokeColor <- c.downField("gradientStrokeColor").as[Option[String]]
        gradientStrokeWidth <- c.downField("gradientStrokeWidth").as[Option[Double]]
        gradientHeight <- c.downField("gradientHeight").as[Option[Double]]
        gradientWidth <- c.downField("gradientWidth").as[Option[Double]]
        labelAlign <- c.downField("labelAlign").as[Option[String]]
        labelBaseline <- c.downField("labelBaseline").as[Option[String]]
        labelColor <- c.downField("labelColor").as[Option[String]]
        labelFont <- c.downField("labelFont").as[Option[String]]
        labelFontSize <- c.downField("labelFontSize").as[Option[Double]]
        labelOffset <- c.downField("labelOffset").as[Option[Double]]
        shortTimeLabels <- c.downField("shortTimeLabels").as[Option[Boolean]]
        symbolColor <- c.downField("symbolColor").as[Option[String]]
        symbolShape <- c.downField("symbolShape").as[Option[String]]
        symbolSize <- c.downField("symbolSize").as[Option[Double]]
        symbolStrokeWidth <- c.downField("symbolStrokeWidth").as[Option[Double]]
        titleColor <- c.downField("titleColor").as[Option[String]]
        titleFont <- c.downField("titleFont").as[Option[String]]
        titleFontSize <- c.downField("titleFontSize").as[Option[Double]]
        titleFontWeight <- c.downField("titleFontWeight").as[Option[String]]
        properties <- c.downField("properties").as[Option[Legend.Properties]]
      } yield {
        Spec.Legend(
          format,
          title,
          values,
          orient,
          offset,
          padding,
          margin,
          gradientStrokeColor,
          gradientStrokeWidth,
          gradientHeight,
          gradientWidth,
          labelAlign,
          labelBaseline,
          labelColor,
          labelFont,
          labelFontSize,
          labelOffset,
          shortTimeLabels,
          symbolColor,
          symbolShape,
          symbolSize,
          symbolStrokeWidth,
          titleColor,
          titleFont,
          titleFontSize,
          titleFontWeight,
          properties)
      }
    }
    implicit val SpecLegendValuesEncoder: Encoder[Spec.Legend.Values] = Encoder.instance(((wrapper: Spec.Legend.Values) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecLegendValuesDecoder: Decoder[Spec.Legend.Values] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$2) => Spec.Legend.Values(x$2)))));
    implicit val SpecLegendPropertiesEncoder: Encoder[Spec.Legend.Properties] = Encoder.instance(((wrapper: Spec.Legend.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecLegendPropertiesDecoder: Decoder[Spec.Legend.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$3) => Spec.Legend.Properties(x$3)))));
    implicit val SpecOrderChannelDefEncoder: Encoder[Spec.OrderChannelDef] = Encoder.instance(((cc: Spec.OrderChannelDef) => Json.obj(
      "sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val SpecOrderChannelDefDecoder: Decoder[Spec.OrderChannelDef] = Decoder.instance { (c: HCursor) =>
      for {
        sort <- c.downField("sort").as[Option[SortOrder]]
        field <- c.downField("field").as[Option[String]]
        `type` <- c.downField("type").as[Option[Type]]
        value <- c.downField("value").as[Option[OrderChannelDef.ValueUnion]]
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        bin <- c.downField("bin").as[Option[OrderChannelDef.BinUnion]]
        aggregate <- c.downField("aggregate").as[Option[AggregateOp]]
        title <- c.downField("title").as[Option[String]]
      } yield {
        Spec.OrderChannelDef(
          sort,
          field,
          `type`,
          value,
          timeUnit,
          bin,
          aggregate,
          title)
      }
    }
    implicit val SpecOrderChannelDefValueUnionEncoder: Encoder[Spec.OrderChannelDef.ValueUnion] = Encoder.instance({
      case (ut @ ((_): Spec.OrderChannelDef.ValueDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.OrderChannelDef.ValueString)) => ut.x.asJson
      case (ut @ ((_): Spec.OrderChannelDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val SpecOrderChannelDefValueUnionDecoder: Decoder[Spec.OrderChannelDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.OrderChannelDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec.OrderChannelDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec.OrderChannelDef.ValueBoolean(x))))));
    implicit val SpecOrderChannelDefBinUnionEncoder: Encoder[Spec.OrderChannelDef.BinUnion] = Encoder.instance({
      case (ut @ ((_): Spec.OrderChannelDef.BinBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.OrderChannelDef.BinBin)) => ut.x.asJson
    });
    implicit val SpecOrderChannelDefBinUnionDecoder: Decoder[Spec.OrderChannelDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec.OrderChannelDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec.OrderChannelDef.BinBin(x))))));
    implicit val SpecDataEncoder: Encoder[Spec.Data] = Encoder.instance(((cc: Spec.Data) => Json.obj(
      "format".->(cc.format.asJson),
      "url".->(cc.url.asJson),
      "values".->(cc.values.asJson))));
    implicit val SpecDataDecoder: Decoder[Spec.Data] = Decoder.instance(((c: HCursor) => c.downField("format").as[Option[DataFormat]]
      .flatMap(((format) => c.downField("url").as[Option[String]]
        .flatMap(((url) => c.downField("values").as[Option[List[Data.Values]]].map(((values) => Spec.Data(
          format,
          url,
          values)))))))));
    implicit val SpecDataValuesEncoder: Encoder[Spec.Data.Values] = Encoder.instance(((wrapper: Spec.Data.Values) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecDataValuesDecoder: Decoder[Spec.Data.Values] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$4) => Spec.Data.Values(x$4)))));
    implicit val SpecDataFormatEncoder: Encoder[Spec.DataFormat] = Encoder.instance(((cc: Spec.DataFormat) => Json.obj(
      "type".->(cc.`type`.asJson),
      "property".->(cc.property.asJson),
      "feature".->(cc.feature.asJson),
      "mesh".->(cc.mesh.asJson))));
    implicit val SpecDataFormatDecoder: Decoder[Spec.DataFormat] = Decoder.instance(((c: HCursor) => c.downField("type").as[Option[DataFormatType]]
      .flatMap(((`type`) => c.downField("property").as[Option[String]]
        .flatMap(((property) => c.downField("feature").as[Option[String]]
          .flatMap(((feature) => c.downField("mesh").as[Option[String]].map(((mesh) => Spec.DataFormat(
            `type`,
            property,
            feature,
            mesh)))))))))));
    implicit val SpecDataFormatTypeEncoder: Encoder[Spec.DataFormatType] = Encoder.instance(((e: Spec.DataFormatType) => parser.parse(e.json).toOption.get));
    implicit val SpecDataFormatTypeDecoder: Decoder[Spec.DataFormatType] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"json\"").toOption.get) => Either.right(Spec.DataFormatTypeEnums.Json)
        case (j @ _) if j.==(parser.parse("\"csv\"").toOption.get) => Either.right(Spec.DataFormatTypeEnums.Csv)
        case (j @ _) if j.==(parser.parse("\"tsv\"").toOption.get) => Either.right(Spec.DataFormatTypeEnums.Tsv)
        case (j @ _) if j.==(parser.parse("\"topojson\"").toOption.get) => Either.right(Spec.DataFormatTypeEnums.Topojson)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecTransformEncoder: Encoder[Spec.Transform] = Encoder.instance(((cc: Spec.Transform) => Json.obj(
      "filter".->(cc.filter.asJson),
      "filterInvalid".->(cc.filterInvalid.asJson),
      "calculate".->(cc.calculate.asJson))));
    implicit val SpecTransformDecoder: Decoder[Spec.Transform] = Decoder.instance { (c: HCursor) =>
      for {
        filter <- c.downField("filter").as[Option[Transform.FilterUnion]]
        filterInvalid <- c.downField("filterInvalid").as[Option[Boolean]]
        calculate <- c.downField("calculate").as[Option[List[Formula]]]
      } yield {
        Spec.Transform(
          filter,
          filterInvalid,
          calculate)
      }
    }
    implicit val SpecTransformFilterUnionEncoder: Encoder[Spec.Transform.FilterUnion] = Encoder.instance({
      case (ut @ ((_): Spec.Transform.FilterString)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.FilterEqualFilter)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.FilterRangeFilter)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.FilterOneOfFilter)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.FilterListTransformFilter5Union)) => ut.x.asJson
    });
    implicit val SpecTransformFilterUnionDecoder: Decoder[Spec.Transform.FilterUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.Transform.FilterString(x))).orElse(c.as[EqualFilter].map(((x) => Spec.Transform.FilterEqualFilter(x)))).orElse(c.as[RangeFilter].map(((x) => Spec.Transform.FilterRangeFilter(x)))).orElse(c.as[OneOfFilter].map(((x) => Spec.Transform.FilterOneOfFilter(x)))).orElse(c.as[List[Transform.Filter5Union]].map(((x) => Spec.Transform.FilterListTransformFilter5Union(x))))));
    implicit val SpecTransformFilter5UnionEncoder: Encoder[Spec.Transform.Filter5Union] = Encoder.instance({
      case (ut @ ((_): Spec.Transform.Filter5String)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.Filter5EqualFilter)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.Filter5RangeFilter)) => ut.x.asJson
      case (ut @ ((_): Spec.Transform.Filter5OneOfFilter)) => ut.x.asJson
    });
    implicit val SpecTransformFilter5UnionDecoder: Decoder[Spec.Transform.Filter5Union] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.Transform.Filter5String(x))).orElse(c.as[EqualFilter].map(((x) => Spec.Transform.Filter5EqualFilter(x)))).orElse(c.as[RangeFilter].map(((x) => Spec.Transform.Filter5RangeFilter(x)))).orElse(c.as[OneOfFilter].map(((x) => Spec.Transform.Filter5OneOfFilter(x))))));
    implicit val SpecEqualFilterEncoder: Encoder[Spec.EqualFilter] = Encoder.instance(((cc: Spec.EqualFilter) => Json.obj(
      "timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "equal".->(cc.equal.asJson))));
    implicit val SpecEqualFilterDecoder: Decoder[Spec.EqualFilter] = Decoder.instance { (c: HCursor) =>
      for {
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        field <- c.downField("field").as[String]
        equal <- c.downField("equal").as[EqualFilter.EqualUnion]
      } yield {
        Spec.EqualFilter(
          timeUnit,
          field,
          equal)
      }
    }
    implicit val SpecEqualFilterEqualUnionEncoder: Encoder[Spec.EqualFilter.EqualUnion] = Encoder.instance({
      case (ut @ ((_): Spec.EqualFilter.EqualString)) => ut.x.asJson
      case (ut @ ((_): Spec.EqualFilter.EqualDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.EqualFilter.EqualBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.EqualFilter.EqualDateTime)) => ut.x.asJson
    });
    implicit val SpecEqualFilterEqualUnionDecoder: Decoder[Spec.EqualFilter.EqualUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.EqualFilter.EqualString(x))).orElse(c.as[Double].map(((x) => Spec.EqualFilter.EqualDouble(x)))).orElse(c.as[Boolean].map(((x) => Spec.EqualFilter.EqualBoolean(x)))).orElse(c.as[DateTime].map(((x) => Spec.EqualFilter.EqualDateTime(x))))));
    implicit val SpecDateTimeEncoder: Encoder[Spec.DateTime] = Encoder.instance(((cc: Spec.DateTime) => Json.obj(
      "year".->(cc.year.asJson),
      "quarter".->(cc.quarter.asJson),
      "month".->(cc.month.asJson),
      "date".->(cc.date.asJson),
      "day".->(cc.day.asJson),
      "hours".->(cc.hours.asJson),
      "minutes".->(cc.minutes.asJson),
      "seconds".->(cc.seconds.asJson),
      "milliseconds".->(cc.milliseconds.asJson))));
    implicit val SpecDateTimeDecoder: Decoder[Spec.DateTime] = Decoder.instance { (c: HCursor) =>
      for {
        year <- c.downField("year").as[Option[Double]]
        quarter <- c.downField("quarter").as[Option[Double]]
        month <- c.downField("month").as[Option[DateTime.MonthUnion]]
        date <- c.downField("date").as[Option[Double]]
        day <- c.downField("day").as[Option[DateTime.DayUnion]]
        hours <- c.downField("hours").as[Option[Double]]
        minutes <- c.downField("minutes").as[Option[Double]]
        seconds <- c.downField("seconds").as[Option[Double]]
        milliseconds <- c.downField("milliseconds").as[Option[Double]]
      } yield {
        Spec.DateTime(
          year,
          quarter,
          month,
          date,
          day,
          hours,
          minutes,
          seconds,
          milliseconds)
      }
    }
    implicit val SpecDateTimeMonthUnionEncoder: Encoder[Spec.DateTime.MonthUnion] = Encoder.instance({
      case (ut @ ((_): Spec.DateTime.MonthDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.DateTime.MonthString)) => ut.x.asJson
    });
    implicit val SpecDateTimeMonthUnionDecoder: Decoder[Spec.DateTime.MonthUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.DateTime.MonthDouble(x))).orElse(c.as[String].map(((x) => Spec.DateTime.MonthString(x))))));
    implicit val SpecDateTimeDayUnionEncoder: Encoder[Spec.DateTime.DayUnion] = Encoder.instance({
      case (ut @ ((_): Spec.DateTime.DayDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.DateTime.DayString)) => ut.x.asJson
    });
    implicit val SpecDateTimeDayUnionDecoder: Decoder[Spec.DateTime.DayUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.DateTime.DayDouble(x))).orElse(c.as[String].map(((x) => Spec.DateTime.DayString(x))))));
    implicit val SpecRangeFilterEncoder: Encoder[Spec.RangeFilter] = Encoder.instance(((cc: Spec.RangeFilter) => Json.obj(
      "timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "range".->(cc.range.asJson))));
    implicit val SpecRangeFilterDecoder: Decoder[Spec.RangeFilter] = Decoder.instance { (c: HCursor) =>
      for {
        timeUnit <- c.downField("timeUnit").as[Option[TimeUnit]]
        field <- c.downField("field").as[String]
        range <- c.downField("range").as[List[RangeFilter.RangeUnion]]
      } yield {
        Spec.RangeFilter(
          timeUnit,
          field,
          range)
      }
    }
    implicit val SpecRangeFilterRangeUnionEncoder: Encoder[Spec.RangeFilter.RangeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.RangeFilter.RangeDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.RangeFilter.RangeDateTime)) => ut.x.asJson
    });
    implicit val SpecRangeFilterRangeUnionDecoder: Decoder[Spec.RangeFilter.RangeUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.RangeFilter.RangeDouble(x))).orElse(c.as[DateTime].map(((x) => Spec.RangeFilter.RangeDateTime(x))))));
    implicit val SpecOneOfFilterEncoder: Encoder[Spec.OneOfFilter] = Encoder.instance(((cc: Spec.OneOfFilter) => Json.obj(
      "timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "oneOf".->(cc.oneOf.asJson))));
    implicit val SpecOneOfFilterDecoder: Decoder[Spec.OneOfFilter] = Decoder.instance(((c: HCursor) => c.downField("timeUnit").as[Option[TimeUnit]]
      .flatMap(((timeUnit) => c.downField("field").as[String]
        .flatMap(((field) => c.downField("oneOf").as[List[OneOfFilter.OneOfUnion]].map(((oneOf) => Spec.OneOfFilter(
          timeUnit,
          field,
          oneOf)))))))));
    implicit val SpecOneOfFilterOneOfUnionEncoder: Encoder[Spec.OneOfFilter.OneOfUnion] = Encoder.instance({
      case (ut: Spec.OneOfFilter.OneOfString) => ut.x.asJson
      case (ut @ ((_): Spec.OneOfFilter.OneOfDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.OneOfFilter.OneOfBoolean)) => ut.x.asJson
      case (ut @ ((_): Spec.OneOfFilter.OneOfDateTime)) => ut.x.asJson
    });
    implicit val SpecOneOfFilterOneOfUnionDecoder: Decoder[Spec.OneOfFilter.OneOfUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.OneOfFilter.OneOfString(x))).orElse(c.as[Double].map(((x) => Spec.OneOfFilter.OneOfDouble(x)))).orElse(c.as[Boolean].map(((x) => Spec.OneOfFilter.OneOfBoolean(x)))).orElse(c.as[DateTime].map(((x) => Spec.OneOfFilter.OneOfDateTime(x))))));
    implicit val SpecFormulaEncoder: Encoder[Spec.Formula] = Encoder.instance(((cc: Spec.Formula) => Json.obj(
      "field".->(cc.field.asJson),
      "expr".->(cc.expr.asJson))));
    implicit val SpecFormulaDecoder: Decoder[Spec.Formula] = Decoder.instance(((c: HCursor) => c.downField("field").as[String]
      .flatMap(((field) => c.downField("expr").as[String].map(((expr) => Spec.Formula(
        field,
        expr)))))));
    implicit val SpecConfigEncoder: Encoder[Spec.Config] = Encoder.instance(((cc: Spec.Config) => Json.obj(
      "viewport".->(cc.viewport.asJson),
      "background".->(cc.background.asJson),
      "numberFormat".->(cc.numberFormat.asJson),
      "timeFormat".->(cc.timeFormat.asJson),
      "countTitle".->(cc.countTitle.asJson),
      "cell".->(cc.cell.asJson),
      "mark".->(cc.mark.asJson),
      "overlay".->(cc.overlay.asJson),
      "scale".->(cc.scale.asJson),
      "axis".->(cc.axis.asJson),
      "legend".->(cc.legend.asJson),
      "facet".->(cc.facet.asJson))));
    implicit val SpecConfigDecoder: Decoder[Spec.Config] = Decoder.instance { (c: HCursor) =>
      for {
        viewport <- c.downField("viewport").as[Option[Double]]
        background <- c.downField("background").as[Option[String]]
        numberFormat <- c.downField("numberFormat").as[Option[String]]
        timeFormat <- c.downField("timeFormat").as[Option[String]]
        countTitle <- c.downField("countTitle").as[Option[String]]
        cell <- c.downField("cell").as[Option[CellConfig]]
        mark <- c.downField("mark").as[Option[MarkConfig]]
        overlay <- c.downField("overlay").as[Option[OverlayConfig]]
        scale <- c.downField("scale").as[Option[ScaleConfig]]
        axis <- c.downField("axis").as[Option[AxisConfig]]
        legend <- c.downField("legend").as[Option[LegendConfig]]
        facet <- c.downField("facet").as[Option[FacetConfig]]
      } yield {
        Spec.Config(
          viewport,
          background,
          numberFormat,
          timeFormat,
          countTitle,
          cell,
          mark,
          overlay,
          scale,
          axis,
          legend,
          facet)
      }
    }
    implicit val SpecCellConfigEncoder: Encoder[Spec.CellConfig] = Encoder.instance(((cc: Spec.CellConfig) => Json.obj(
      "width".->(cc.width.asJson),
      "height".->(cc.height.asJson),
      "clip".->(cc.clip.asJson),
      "fill".->(cc.fill.asJson),
      "fillOpacity".->(cc.fillOpacity.asJson),
      "stroke".->(cc.stroke.asJson),
      "strokeOpacity".->(cc.strokeOpacity.asJson),
      "strokeWidth".->(cc.strokeWidth.asJson),
      "strokeDash".->(cc.strokeDash.asJson),
      "strokeDashOffset".->(cc.strokeDashOffset.asJson))));
    implicit val SpecCellConfigDecoder: Decoder[Spec.CellConfig] = Decoder.instance { (c: HCursor) =>
      for {
        width <- c.downField("width").as[Option[Double]]
        height <- c.downField("height").as[Option[Double]]
        clip <- c.downField("clip").as[Option[Boolean]]
        fill <- c.downField("fill").as[Option[String]]
        fillOpacity <- c.downField("fillOpacity").as[Option[Double]]
        stroke <- c.downField("stroke").as[Option[String]]
        strokeOpacity <- c.downField("strokeOpacity").as[Option[Double]]
        strokeWidth <- c.downField("strokeWidth").as[Option[Double]]
        strokeDash <- c.downField("strokeDash").as[Option[List[Double]]]
        strokeDashOffset <- c.downField("strokeDashOffset").as[Option[Double]]
      } yield {

        Spec.CellConfig(
          width,
          height,
          clip,
          fill,
          fillOpacity,
          stroke,
          strokeOpacity,
          strokeWidth,
          strokeDash,
          strokeDashOffset)
      }
    }
    implicit val SpecMarkConfigEncoder: Encoder[Spec.MarkConfig] = Encoder.instance(((cc: Spec.MarkConfig) => Json.obj(
      "filled".->(cc.filled.asJson),
      "color".->(cc.color.asJson),
      "fill".->(cc.fill.asJson),
      "stroke".->(cc.stroke.asJson),
      "opacity".->(cc.opacity.asJson),
      "fillOpacity".->(cc.fillOpacity.asJson),
      "strokeOpacity".->(cc.strokeOpacity.asJson),
      "strokeWidth".->(cc.strokeWidth.asJson),
      "strokeDash".->(cc.strokeDash.asJson),
      "strokeDashOffset".->(cc.strokeDashOffset.asJson),
      "stacked".->(cc.stacked.asJson),
      "orient".->(cc.orient.asJson),
      "interpolate".->(cc.interpolate.asJson),
      "tension".->(cc.tension.asJson),
      "lineSize".->(cc.lineSize.asJson),
      "ruleSize".->(cc.ruleSize.asJson),
      "barSize".->(cc.barSize.asJson),
      "barThinSize".->(cc.barThinSize.asJson),
      "shape".->(cc.shape.asJson),
      "size".->(cc.size.asJson),
      "tickSize".->(cc.tickSize.asJson),
      "tickThickness".->(cc.tickThickness.asJson),
      "align".->(cc.align.asJson),
      "angle".->(cc.angle.asJson),
      "baseline".->(cc.baseline.asJson),
      "dx".->(cc.dx.asJson),
      "dy".->(cc.dy.asJson),
      "radius".->(cc.radius.asJson),
      "theta".->(cc.theta.asJson),
      "font".->(cc.font.asJson),
      "fontSize".->(cc.fontSize.asJson),
      "fontStyle".->(cc.fontStyle.asJson),
      "fontWeight".->(cc.fontWeight.asJson),
      "format".->(cc.format.asJson),
      "shortTimeLabels".->(cc.shortTimeLabels.asJson),
      "text".->(cc.text.asJson),
      "applyColorToBackground".->(cc.applyColorToBackground.asJson))))

    implicit val SpecMarkConfigDecoder: Decoder[Spec.MarkConfig] = Decoder.instance { (c: HCursor) =>
      for {
        filled <- c.downField("filled").as[Option[Boolean]]
        color <- c.downField("color").as[Option[String]]
        fill <- c.downField("fill").as[Option[String]]
        stroke <- c.downField("stroke").as[Option[String]]
        opacity <- c.downField("opacity").as[Option[Double]]
        fillOpacity <- c.downField("fillOpacity").as[Option[Double]]
        strokeOpacity <- c.downField("strokeOpacity").as[Option[Double]]
        strokeWidth <- c.downField("strokeWidth").as[Option[Double]]
        strokeDash <- c.downField("strokeDash").as[Option[List[Double]]]
        strokeDashOffset <- c.downField("strokeDashOffset").as[Option[Double]]
        stacked <- c.downField("stacked").as[Option[StackOffset]]
        orient <- c.downField("orient").as[Option[Orient]]
        interpolate <- c.downField("interpolate").as[Option[Interpolate]]
        tension <- c.downField("tension").as[Option[Double]]
        lineSize <- c.downField("lineSize").as[Option[Double]]
        ruleSize <- c.downField("ruleSize").as[Option[Double]]
        barSize <- c.downField("barSize").as[Option[Double]]
        barThinSize <- c.downField("barThinSize").as[Option[Double]]
        shape <- c.downField("shape").as[Option[MarkConfig.ShapeUnion]]
        size <- c.downField("size").as[Option[Double]]
        tickSize <- c.downField("tickSize").as[Option[Double]]
        tickThickness <- c.downField("tickThickness").as[Option[Double]]
        align <- c.downField("align").as[Option[HorizontalAlign]]
        angle <- c.downField("angle").as[Option[Double]]
        baseline <- c.downField("baseline").as[Option[VerticalAlign]]
        dx <- c.downField("dx").as[Option[Double]]
        dy <- c.downField("dy").as[Option[Double]]
        radius <- c.downField("radius").as[Option[Double]]
        theta <- c.downField("theta").as[Option[Double]]
        font <- c.downField("font").as[Option[String]]
        fontSize <- c.downField("fontSize").as[Option[Double]]
        fontStyle <- c.downField("fontStyle").as[Option[FontStyle]]
        fontWeight <- c.downField("fontWeight").as[Option[FontWeight]]
        format <- c.downField("format").as[Option[String]]
        shortTimeLabels <- c.downField("shortTimeLabels").as[Option[Boolean]]
        text <- c.downField("text").as[Option[String]]
        applyColorToBackground <- c.downField("applyColorToBackground").as[Option[Boolean]]
      } yield {
        Spec.MarkConfig(
          filled,
          color,
          fill,
          stroke,
          opacity,
          fillOpacity,
          strokeOpacity,
          strokeWidth,
          strokeDash,
          strokeDashOffset,
          stacked,
          orient,
          interpolate,
          tension,
          lineSize,
          ruleSize,
          barSize,
          barThinSize,
          shape,
          size,
          tickSize,
          tickThickness,
          align,
          angle,
          baseline,
          dx,
          dy,
          radius,
          theta,
          font,
          fontSize,
          fontStyle,
          fontWeight,
          format,
          shortTimeLabels,
          text,
          applyColorToBackground)
      }
    }
    implicit val SpecMarkConfigShapeUnionEncoder: Encoder[Spec.MarkConfig.ShapeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.MarkConfig.ShapeShape)) => ut.x.asJson
      case (ut @ ((_): Spec.MarkConfig.ShapeString)) => ut.x.asJson
    });
    implicit val SpecMarkConfigShapeUnionDecoder: Decoder[Spec.MarkConfig.ShapeUnion] = Decoder.instance(((c: HCursor) => c.as[Shape].map(((x) => Spec.MarkConfig.ShapeShape(x))).orElse(c.as[String].map(((x) => Spec.MarkConfig.ShapeString(x))))));
    implicit val SpecStackOffsetEncoder: Encoder[Spec.StackOffset] = Encoder.instance(((e: Spec.StackOffset) => parser.parse(e.json).toOption.get));
    implicit val SpecStackOffsetDecoder: Decoder[Spec.StackOffset] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"zero\"").toOption.get) => Either.right(Spec.StackOffsetEnums.Zero)
        case (j @ _) if j.==(parser.parse("\"center\"").toOption.get) => Either.right(Spec.StackOffsetEnums.Center)
        case (j @ _) if j.==(parser.parse("\"normalize\"").toOption.get) => Either.right(Spec.StackOffsetEnums.Normalize)
        case (j @ _) if j.==(parser.parse("\"none\"").toOption.get) => Either.right(Spec.StackOffsetEnums.None)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecOrientEncoder: Encoder[Spec.Orient] = Encoder.instance(((e: Spec.Orient) => parser.parse(e.json).toOption.get));
    implicit val SpecOrientDecoder: Decoder[Spec.Orient] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"horizontal\"").toOption.get) => Either.right(Spec.OrientEnums.Horizontal)
        case (j @ _) if j.==(parser.parse("\"vertical\"").toOption.get) => Either.right(Spec.OrientEnums.Vertical)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecInterpolateEncoder: Encoder[Spec.Interpolate] = Encoder.instance(((e: Spec.Interpolate) => parser.parse(e.json).toOption.get));
    implicit val SpecInterpolateDecoder: Decoder[Spec.Interpolate] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"linear\"").toOption.get) => Either.right(Spec.InterpolateEnums.Linear)
        case (j @ _) if j.==(parser.parse("\"linear-closed\"").toOption.get) => Either.right(Spec.InterpolateEnums.LinearClosed)
        case (j @ _) if j.==(parser.parse("\"step\"").toOption.get) => Either.right(Spec.InterpolateEnums.Step)
        case (j @ _) if j.==(parser.parse("\"step-before\"").toOption.get) => Either.right(Spec.InterpolateEnums.StepBefore)
        case (j @ _) if j.==(parser.parse("\"step-after\"").toOption.get) => Either.right(Spec.InterpolateEnums.StepAfter)
        case (j @ _) if j.==(parser.parse("\"basis\"").toOption.get) => Either.right(Spec.InterpolateEnums.Basis)
        case (j @ _) if j.==(parser.parse("\"basis-open\"").toOption.get) => Either.right(Spec.InterpolateEnums.BasisOpen)
        case (j @ _) if j.==(parser.parse("\"basis-closed\"").toOption.get) => Either.right(Spec.InterpolateEnums.BasisClosed)
        case (j @ _) if j.==(parser.parse("\"cardinal\"").toOption.get) => Either.right(Spec.InterpolateEnums.Cardinal)
        case (j @ _) if j.==(parser.parse("\"cardinal-open\"").toOption.get) => Either.right(Spec.InterpolateEnums.CardinalOpen)
        case (j @ _) if j.==(parser.parse("\"cardinal-closed\"").toOption.get) => Either.right(Spec.InterpolateEnums.CardinalClosed)
        case (j @ _) if j.==(parser.parse("\"bundle\"").toOption.get) => Either.right(Spec.InterpolateEnums.Bundle)
        case (j @ _) if j.==(parser.parse("\"monotone\"").toOption.get) => Either.right(Spec.InterpolateEnums.Monotone)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecShapeEncoder: Encoder[Spec.Shape] = Encoder.instance(((e: Spec.Shape) => parser.parse(e.json).toOption.get));
    implicit val SpecShapeDecoder: Decoder[Spec.Shape] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"circle\"").toOption.get) => Either.right(Spec.ShapeEnums.Circle)
        case (j @ _) if j.==(parser.parse("\"square\"").toOption.get) => Either.right(Spec.ShapeEnums.Square)
        case (j @ _) if j.==(parser.parse("\"cross\"").toOption.get) => Either.right(Spec.ShapeEnums.Cross)
        case (j @ _) if j.==(parser.parse("\"diamond\"").toOption.get) => Either.right(Spec.ShapeEnums.Diamond)
        case (j @ _) if j.==(parser.parse("\"triangle-up\"").toOption.get) => Either.right(Spec.ShapeEnums.TriangleUp)
        case (j @ _) if j.==(parser.parse("\"triangle-down\"").toOption.get) => Either.right(Spec.ShapeEnums.TriangleDown)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecHorizontalAlignEncoder: Encoder[Spec.HorizontalAlign] = Encoder.instance(((e: Spec.HorizontalAlign) => parser.parse(e.json).toOption.get));
    implicit val SpecHorizontalAlignDecoder: Decoder[Spec.HorizontalAlign] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"left\"").toOption.get) => Either.right(Spec.HorizontalAlignEnums.Left)
        case (j @ _) if j.==(parser.parse("\"right\"").toOption.get) => Either.right(Spec.HorizontalAlignEnums.Right)
        case (j @ _) if j.==(parser.parse("\"center\"").toOption.get) => Either.right(Spec.HorizontalAlignEnums.Center)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecVerticalAlignEncoder: Encoder[Spec.VerticalAlign] = Encoder.instance(((e: Spec.VerticalAlign) => parser.parse(e.json).toOption.get));
    implicit val SpecVerticalAlignDecoder: Decoder[Spec.VerticalAlign] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"top\"").toOption.get) => Either.right(Spec.VerticalAlignEnums.Top)
        case (j @ _) if j.==(parser.parse("\"middle\"").toOption.get) => Either.right(Spec.VerticalAlignEnums.Middle)
        case (j @ _) if j.==(parser.parse("\"bottom\"").toOption.get) => Either.right(Spec.VerticalAlignEnums.Bottom)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecFontStyleEncoder: Encoder[Spec.FontStyle] = Encoder.instance(((e: Spec.FontStyle) => parser.parse(e.json).toOption.get));
    implicit val SpecFontStyleDecoder: Decoder[Spec.FontStyle] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"normal\"").toOption.get) => Either.right(Spec.FontStyleEnums.Normal)
        case (j @ _) if j.==(parser.parse("\"italic\"").toOption.get) => Either.right(Spec.FontStyleEnums.Italic)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecFontWeightEncoder: Encoder[Spec.FontWeight] = Encoder.instance(((e: Spec.FontWeight) => parser.parse(e.json).toOption.get));
    implicit val SpecFontWeightDecoder: Decoder[Spec.FontWeight] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"normal\"").toOption.get) => Either.right(Spec.FontWeightEnums.Normal)
        case (j @ _) if j.==(parser.parse("\"bold\"").toOption.get) => Either.right(Spec.FontWeightEnums.Bold)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecOverlayConfigEncoder: Encoder[Spec.OverlayConfig] = Encoder.instance(((cc: Spec.OverlayConfig) => Json.obj(
      "line".->(cc.line.asJson),
      "area".->(cc.area.asJson),
      "pointStyle".->(cc.pointStyle.asJson),
      "lineStyle".->(cc.lineStyle.asJson))));
    implicit val SpecOverlayConfigDecoder: Decoder[Spec.OverlayConfig] = Decoder.instance { (c: HCursor) =>
      for {
        line <- c.downField("line").as[Option[Boolean]]
        area <- c.downField("area").as[Option[AreaOverlay]]
        pointStyle <- c.downField("pointStyle").as[Option[MarkConfig]]
        lineStyle <- c.downField("lineStyle").as[Option[MarkConfig]]
      } yield {
        Spec.OverlayConfig(
          line,
          area,
          pointStyle,
          lineStyle)
      }
    }
    implicit val SpecAreaOverlayEncoder: Encoder[Spec.AreaOverlay] = Encoder.instance(((e: Spec.AreaOverlay) => parser.parse(e.json).toOption.get));
    implicit val SpecAreaOverlayDecoder: Decoder[Spec.AreaOverlay] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j @ _) if j.==(parser.parse("\"line\"").toOption.get) => Either.right(Spec.AreaOverlayEnums.Line)
        case (j @ _) if j.==(parser.parse("\"linepoint\"").toOption.get) => Either.right(Spec.AreaOverlayEnums.Linepoint)
        case (j @ _) if j.==(parser.parse("\"none\"").toOption.get) => Either.right(Spec.AreaOverlayEnums.None)
        case _ => Either.left(DecodingFailure(
          "Couldn\'t find enum:".+(json.toString),
          c.history))
      }).map(((singleton) => singleton))))));
    implicit val SpecScaleConfigEncoder: Encoder[Spec.ScaleConfig] = Encoder.instance(((cc: Spec.ScaleConfig) => Json.obj(
      "round".->(cc.round.asJson),
      "textBandWidth".->(cc.textBandWidth.asJson),
      "rangeStep".->(cc.rangeStep.asJson),
      "opacity".->(cc.opacity.asJson),
      "padding".->(cc.padding.asJson),
      "useRawDomain".->(cc.useRawDomain.asJson),
      "nominalColorRange".->(cc.nominalColorRange.asJson),
      "sequentialColorRange".->(cc.sequentialColorRange.asJson),
      "shapeRange".->(cc.shapeRange.asJson),
      "barSizeRange".->(cc.barSizeRange.asJson),
      "fontSizeRange".->(cc.fontSizeRange.asJson),
      "ruleSizeRange".->(cc.ruleSizeRange.asJson),
      "tickSizeRange".->(cc.tickSizeRange.asJson),
      "pointSizeRange".->(cc.pointSizeRange.asJson))));
    implicit val SpecScaleConfigDecoder: Decoder[Spec.ScaleConfig] = Decoder.instance { (c: HCursor) =>
      for {
        round <- c.downField("round").as[Option[Boolean]]
        textBandWidth <- c.downField("textBandWidth").as[Option[Double]]
        rangeStep <- c.downField("rangeStep").as[Option[ScaleConfig.RangeStepUnion]]
        opacity <- c.downField("opacity").as[Option[List[Double]]]
        padding <- c.downField("padding").as[Option[Double]]
        useRawDomain <- c.downField("useRawDomain").as[Option[Boolean]]
        nominalColorRange <- c.downField("nominalColorRange").as[Option[ScaleConfig.NominalColorRangeUnion]]
        sequentialColorRange <- c.downField("sequentialColorRange").as[Option[ScaleConfig.SequentialColorRangeUnion]]
        shapeRange <- c.downField("shapeRange").as[Option[ScaleConfig.ShapeRangeUnion]]
        barSizeRange <- c.downField("barSizeRange").as[Option[List[Double]]]
        fontSizeRange <- c.downField("fontSizeRange").as[Option[List[Double]]]
        ruleSizeRange <- c.downField("ruleSizeRange").as[Option[List[Double]]]
        tickSizeRange <- c.downField("tickSizeRange").as[Option[List[Double]]]
        pointSizeRange <- c.downField("pointSizeRange").as[Option[List[Double]]]
      } yield {
        Spec.ScaleConfig(
          round,
          textBandWidth,
          rangeStep,
          opacity,
          padding,
          useRawDomain,
          nominalColorRange,
          sequentialColorRange,
          shapeRange,
          barSizeRange,
          fontSizeRange,
          ruleSizeRange,
          tickSizeRange,
          pointSizeRange)
      }
    }
    implicit val SpecScaleConfigRangeStepUnionEncoder: Encoder[Spec.ScaleConfig.RangeStepUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ScaleConfig.RangeStepDouble)) => ut.x.asJson
      case (ut @ ((_): Spec.ScaleConfig.RangeStepRangeStep)) => ut.x.asJson
    });
    implicit val SpecScaleConfigRangeStepUnionDecoder: Decoder[Spec.ScaleConfig.RangeStepUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec.ScaleConfig.RangeStepDouble(x))).orElse(c.as[RangeStep].map(((x) => Spec.ScaleConfig.RangeStepRangeStep(x))))));
    implicit val SpecScaleConfigNominalColorRangeUnionEncoder: Encoder[Spec.ScaleConfig.NominalColorRangeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ScaleConfig.NominalColorRangeString)) => ut.x.asJson
      case (ut @ ((_): Spec.ScaleConfig.NominalColorRangeListString)) => ut.x.asJson
    });
    implicit val SpecScaleConfigNominalColorRangeUnionDecoder: Decoder[Spec.ScaleConfig.NominalColorRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.ScaleConfig.NominalColorRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec.ScaleConfig.NominalColorRangeListString(x))))));
    implicit val SpecScaleConfigSequentialColorRangeUnionEncoder: Encoder[Spec.ScaleConfig.SequentialColorRangeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ScaleConfig.SequentialColorRangeString)) => ut.x.asJson
      case (ut @ ((_): Spec.ScaleConfig.SequentialColorRangeListString)) => ut.x.asJson
    });
    implicit val SpecScaleConfigSequentialColorRangeUnionDecoder: Decoder[Spec.ScaleConfig.SequentialColorRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.ScaleConfig.SequentialColorRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec.ScaleConfig.SequentialColorRangeListString(x))))));
    implicit val SpecScaleConfigShapeRangeUnionEncoder: Encoder[Spec.ScaleConfig.ShapeRangeUnion] = Encoder.instance({
      case (ut @ ((_): Spec.ScaleConfig.ShapeRangeString)) => ut.x.asJson
      case (ut @ ((_): Spec.ScaleConfig.ShapeRangeListString)) => ut.x.asJson
    });
    implicit val SpecScaleConfigShapeRangeUnionDecoder: Decoder[Spec.ScaleConfig.ShapeRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec.ScaleConfig.ShapeRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec.ScaleConfig.ShapeRangeListString(x))))));
    implicit val SpecAxisConfigEncoder: Encoder[Spec.AxisConfig] = Encoder.instance(((cc: Spec.AxisConfig) => Json.obj(
      "axisWidth".->(cc.axisWidth.asJson),
      "layer".->(cc.layer.asJson),
      "offset".->(cc.offset.asJson),
      "axisColor".->(cc.axisColor.asJson),
      "grid".->(cc.grid.asJson),
      "gridColor".->(cc.gridColor.asJson),
      "gridDash".->(cc.gridDash.asJson),
      "gridOpacity".->(cc.gridOpacity.asJson),
      "gridWidth".->(cc.gridWidth.asJson),
      "labels".->(cc.labels.asJson),
      "labelAngle".->(cc.labelAngle.asJson),
      "labelAlign".->(cc.labelAlign.asJson),
      "labelBaseline".->(cc.labelBaseline.asJson),
      "labelMaxLength".->(cc.labelMaxLength.asJson),
      "shortTimeLabels".->(cc.shortTimeLabels.asJson),
      "subdivide".->(cc.subdivide.asJson),
      "ticks".->(cc.ticks.asJson),
      "tickColor".->(cc.tickColor.asJson),
      "tickLabelColor".->(cc.tickLabelColor.asJson),
      "tickLabelFont".->(cc.tickLabelFont.asJson),
      "tickLabelFontSize".->(cc.tickLabelFontSize.asJson),
      "tickPadding".->(cc.tickPadding.asJson),
      "tickSize".->(cc.tickSize.asJson),
      "tickSizeMajor".->(cc.tickSizeMajor.asJson),
      "tickSizeMinor".->(cc.tickSizeMinor.asJson),
      "tickSizeEnd".->(cc.tickSizeEnd.asJson),
      "tickWidth".->(cc.tickWidth.asJson),
      "titleColor".->(cc.titleColor.asJson),
      "titleFont".->(cc.titleFont.asJson),
      "titleFontSize".->(cc.titleFontSize.asJson),
      "titleFontWeight".->(cc.titleFontWeight.asJson),
      "titleOffset".->(cc.titleOffset.asJson),
      "titleMaxLength".->(cc.titleMaxLength.asJson),
      "characterWidth".->(cc.characterWidth.asJson),
      "properties".->(cc.properties.asJson))));
    implicit val SpecAxisConfigDecoder: Decoder[Spec.AxisConfig] = Decoder.instance { (c: HCursor) =>
      for {
        labelAngle <- c.downField("labelAngle").as[Option[Double]]
        format <- c.downField("format").as[Option[String]]
        orient <- c.downField("orient").as[Option[AxisOrient]]
        title <- c.downField("title").as[Option[String]]
        values <- c.downField("values").as[Option[List[Double]]]
        axisWidth <- c.downField("axisWidth").as[Option[Double]]
        layer <- c.downField("layer").as[Option[String]]
        offset <- c.downField("offset").as[Option[Double]]
        axisColor <- c.downField("axisColor").as[Option[String]]
        grid <- c.downField("grid").as[Option[Boolean]]
        gridColor <- c.downField("gridColor").as[Option[String]]
        gridDash <- c.downField("gridDash").as[Option[List[Double]]]
        gridOpacity <- c.downField("gridOpacity").as[Option[Double]]
        gridWidth <- c.downField("gridWidth").as[Option[Double]]
        labels <- c.downField("labels").as[Option[Boolean]]
        labelAlign <- c.downField("labelAlign").as[Option[String]]
        labelBaseline <- c.downField("labelBaseline").as[Option[String]]
        labelMaxLength <- c.downField("labelMaxLength").as[Option[Double]]
        shortTimeLabels <- c.downField("shortTimeLabels").as[Option[Boolean]]
        subdivide <- c.downField("subdivide").as[Option[Double]]
        ticks <- c.downField("ticks").as[Option[Double]]
        tickColor <- c.downField("tickColor").as[Option[String]]
        tickLabelColor <- c.downField("tickLabelColor").as[Option[String]]
        tickLabelFont <- c.downField("tickLabelFont").as[Option[String]]
        tickLabelFontSize <- c.downField("tickLabelFontSize").as[Option[Double]]
        tickPadding <- c.downField("tickPadding").as[Option[Double]]
        tickSize <- c.downField("tickSize").as[Option[Double]]
        tickSizeMajor <- c.downField("tickSizeMajor").as[Option[Double]]
        tickSizeMinor <- c.downField("tickSizeMinor").as[Option[Double]]
        tickSizeEnd <- c.downField("tickSizeEnd").as[Option[Double]]
        tickWidth <- c.downField("tickWidth").as[Option[Double]]
        titleColor <- c.downField("titleColor").as[Option[String]]
        titleFont <- c.downField("titleFont").as[Option[String]]
        titleFontSize <- c.downField("titleFontSize").as[Option[Double]]
        titleFontWeight <- c.downField("titleFontWeight").as[Option[String]]
        titleOffset <- c.downField("titleOffset").as[Option[Double]]
        titleMaxLength <- c.downField("titleMaxLength").as[Option[Double]]
        characterWidth <- c.downField("characterWidth").as[Option[Double]]
        properties <- c.downField("properties").as[Option[AxisConfig.Properties]]
      } yield {
        Spec.AxisConfig(
          axisWidth,
          layer,
          offset,
          axisColor,
          grid,
          gridColor,
          gridDash,
          gridOpacity,
          gridWidth,
          labels,
          labelAngle,
          labelAlign,
          labelBaseline,
          labelMaxLength,
          shortTimeLabels,
          subdivide,
          ticks,
          tickColor,
          tickLabelColor,
          tickLabelFont,
          tickLabelFontSize,
          tickPadding,
          tickSize,
          tickSizeMajor,
          tickSizeMinor,
          tickSizeEnd,
          tickWidth,
          titleColor,
          titleFont,
          titleFontSize,
          titleFontWeight,
          titleOffset,
          titleMaxLength,
          characterWidth,
          properties)
      }
    }

    implicit val SpecAxisConfigPropertiesEncoder: Encoder[Spec.AxisConfig.Properties] = Encoder.instance(((wrapper: Spec.AxisConfig.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecAxisConfigPropertiesDecoder: Decoder[Spec.AxisConfig.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$5) => Spec.AxisConfig.Properties(x$5)))));

    implicit val SpecLegendConfigEncoder: Encoder[Spec.LegendConfig] = Encoder.instance(((cc: Spec.LegendConfig) => Json.obj(
      "orient".->(cc.orient.asJson),
      "offset".->(cc.offset.asJson),
      "padding".->(cc.padding.asJson),
      "margin".->(cc.margin.asJson),
      "gradientStrokeColor".->(cc.gradientStrokeColor.asJson),
      "gradientStrokeWidth".->(cc.gradientStrokeWidth.asJson),
      "gradientHeight".->(cc.gradientHeight.asJson),
      "gradientWidth".->(cc.gradientWidth.asJson),
      "labelAlign".->(cc.labelAlign.asJson),
      "labelBaseline".->(cc.labelBaseline.asJson),
      "labelColor".->(cc.labelColor.asJson),
      "labelFont".->(cc.labelFont.asJson),
      "labelFontSize".->(cc.labelFontSize.asJson),
      "labelOffset".->(cc.labelOffset.asJson),
      "shortTimeLabels".->(cc.shortTimeLabels.asJson),
      "symbolColor".->(cc.symbolColor.asJson),
      "symbolShape".->(cc.symbolShape.asJson),
      "symbolSize".->(cc.symbolSize.asJson),
      "symbolStrokeWidth".->(cc.symbolStrokeWidth.asJson),
      "titleColor".->(cc.titleColor.asJson),
      "titleFont".->(cc.titleFont.asJson),
      "titleFontSize".->(cc.titleFontSize.asJson),
      "titleFontWeight".->(cc.titleFontWeight.asJson),
      "properties".->(cc.properties.asJson))));

    implicit val SpecLegendConfigDecoder: Decoder[Spec.LegendConfig] = Decoder.instance { (c: HCursor) =>
      for {
        orient <- c.downField("orient").as[Option[String]]
        offset <- c.downField("offset").as[Option[Double]]
        padding <- c.downField("padding").as[Option[Double]]
        margin <- c.downField("margin").as[Option[Double]]
        gradientStrokeColor <- c.downField("gradientStrokeColor").as[Option[String]]
        gradientStrokeWidth <- c.downField("gradientStrokeWidth").as[Option[Double]]
        gradientHeight <- c.downField("gradientHeight").as[Option[Double]]
        gradientWidth <- c.downField("gradientWidth").as[Option[Double]]
        labelAlign <- c.downField("labelAlign").as[Option[String]]
        labelBaseline <- c.downField("labelBaseline").as[Option[String]]
        labelColor <- c.downField("labelColor").as[Option[String]]
        labelFont <- c.downField("labelFont").as[Option[String]]
        labelFontSize <- c.downField("labelFontSize").as[Option[Double]]
        labelOffset <- c.downField("labelOffset").as[Option[Double]]
        shortTimeLabels <- c.downField("shortTimeLabels").as[Option[Boolean]]
        symbolColor <- c.downField("symbolColor").as[Option[String]]
        symbolShape <- c.downField("symbolShape").as[Option[String]]
        symbolSize <- c.downField("symbolSize").as[Option[Double]]
        symbolStrokeWidth <- c.downField("symbolStrokeWidth").as[Option[Double]]
        titleColor <- c.downField("titleColor").as[Option[String]]
        titleFont <- c.downField("titleFont").as[Option[String]]
        titleFontSize <- c.downField("titleFontSize").as[Option[Double]]
        titleFontWeight <- c.downField("titleFontWeight").as[Option[String]]
        properties <- c.downField("properties").as[Option[LegendConfig.Properties]]
      } yield {
        Spec.LegendConfig(
          orient,
          offset,
          padding,
          margin,
          gradientStrokeColor,
          gradientStrokeWidth,
          gradientHeight,
          gradientWidth,
          labelAlign,
          labelBaseline,
          labelColor,
          labelFont,
          labelFontSize,
          labelOffset,
          shortTimeLabels,
          symbolColor,
          symbolShape,
          symbolSize,
          symbolStrokeWidth,
          titleColor,
          titleFont,
          titleFontSize,
          titleFontWeight,
          properties)
      }
    }
    implicit val SpecLegendConfigPropertiesEncoder: Encoder[Spec.LegendConfig.Properties] = Encoder.instance(((wrapper: Spec.LegendConfig.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val SpecLegendConfigPropertiesDecoder: Decoder[Spec.LegendConfig.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$6) => Spec.LegendConfig.Properties(x$6)))));
    implicit val SpecFacetConfigEncoder: Encoder[Spec.FacetConfig] = Encoder.instance(((cc: Spec.FacetConfig) => Json.obj(
      "scale".->(cc.scale.asJson),
      "axis".->(cc.axis.asJson),
      "grid".->(cc.grid.asJson),
      "cell".->(cc.cell.asJson))));
    implicit val SpecFacetConfigDecoder: Decoder[Spec.FacetConfig] = Decoder.instance { (c: HCursor) =>
      for {
        scale <- c.downField("scale").as[Option[FacetScaleConfig]]
        axis <- c.downField("axis").as[Option[AxisConfig]]
        grid <- c.downField("grid").as[Option[FacetGridConfig]]
        cell <- c.downField("cell").as[Option[CellConfig]]
      } yield {
        Spec.FacetConfig(
          scale,
          axis,
          grid,
          cell)
      }
    }
    implicit val SpecFacetScaleConfigEncoder: Encoder[Spec.FacetScaleConfig] = Encoder.instance(((cc: Spec.FacetScaleConfig) => Json.obj(
      "round".->(cc.round.asJson),
      "padding".->(cc.padding.asJson))));
    implicit val SpecFacetScaleConfigDecoder: Decoder[Spec.FacetScaleConfig] = Decoder.instance { (c: HCursor) =>
      for {
        round <- c.downField("round").as[Option[Boolean]]
        padding <- c.downField("padding").as[Option[Double]]
      } yield {
        Spec.FacetScaleConfig(
          round,
          padding)
      }
    }
    implicit val SpecFacetGridConfigEncoder: Encoder[Spec.FacetGridConfig] = Encoder.instance(((cc: Spec.FacetGridConfig) => Json.obj(
      "color".->(cc.color.asJson),
      "opacity".->(cc.opacity.asJson),
      "offset".->(cc.offset.asJson))));
    implicit val SpecFacetGridConfigDecoder: Decoder[Spec.FacetGridConfig] = Decoder.instance { (c: HCursor) =>
      for {
        color <- c.downField("color").as[Option[String]]
        opacity <- c.downField("opacity").as[Option[Double]]
        offset <- c.downField("offset").as[Option[Double]]
      } yield {
        Spec.FacetGridConfig(
          color,
          opacity,
          offset)
      }
    }
    implicit val SpecFacetSpecEncoder: Encoder[Spec.FacetSpec] = Encoder.instance(((cc: Spec.FacetSpec) => Json.obj(
      "facet".->(cc.facet.asJson),
      "spec".->(cc.spec.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val SpecFacetSpecDecoder: Decoder[Spec.FacetSpec] = Decoder.instance { (c: HCursor) =>
      for {
        facet <- c.downField("facet").as[Facet]
        spec <- c.downField("spec").as[FacetSpec.SpecUnion]
        name <- c.downField("name").as[Option[String]]
        description <- c.downField("description").as[Option[String]]
        data <- c.downField("data").as[Option[Data]]
        transform <- c.downField("transform").as[Option[Transform]]
        config <- c.downField("config").as[Option[Config]]
      } yield {

        Spec.FacetSpec(
          facet,
          spec,
          name,
          description,
          data,
          transform,
          config)
      }
    }
    implicit val SpecFacetSpecSpecUnionEncoder: Encoder[Spec.FacetSpec.SpecUnion] = Encoder.instance({
      case (ut @ ((_): Spec.FacetSpec.SpecLayerSpec)) => ut.x.asJson
      case (ut @ ((_): Spec.FacetSpec.SpecUnitSpec)) => ut.x.asJson
    });
    implicit val SpecFacetSpecSpecUnionDecoder: Decoder[Spec.FacetSpec.SpecUnion] = Decoder.instance(((c: HCursor) => c.as[LayerSpec].map(((x) => Spec.FacetSpec.SpecLayerSpec(x))).orElse(c.as[UnitSpec].map(((x) => Spec.FacetSpec.SpecUnitSpec(x))))));
    implicit val SpecFacetEncoder: Encoder[Spec.Facet] = Encoder.instance(((cc: Spec.Facet) => Json.obj(
      "row".->(cc.row.asJson),
      "column".->(cc.column.asJson))));
    implicit val SpecFacetDecoder: Decoder[Spec.Facet] = Decoder.instance { (c: HCursor) =>
      for {
        row <- c.downField("row").as[Option[PositionChannelDef]]
        column <- c.downField("column").as[Option[PositionChannelDef]]
      } yield {
        Spec.Facet(
          row,
          column)
      }
    }
    implicit val SpecLayerSpecEncoder: Encoder[Spec.LayerSpec] = Encoder.instance(((cc: Spec.LayerSpec) => Json.obj(
      "width".->(cc.width.asJson),
      "height".->(cc.height.asJson),
      "layers".->(cc.layers.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val SpecLayerSpecDecoder: Decoder[Spec.LayerSpec] = Decoder.instance { (c: HCursor) =>
      for {
        width <- c.downField("width").as[Option[Double]]
        height <- c.downField("height").as[Option[Double]]
        layers <- c.downField("layers").as[List[UnitSpec]]
        name <- c.downField("name").as[Option[String]]
        description <- c.downField("description").as[Option[String]]
        data <- c.downField("data").as[Option[Data]]
        transform <- c.downField("transform").as[Option[Transform]]
        config <- c.downField("config").as[Option[Config]]
      } yield {
        Spec.LayerSpec(
          width,
          height,
          layers,
          name,
          description,
          data,
          transform,
          config)
      }
    }

    implicit val SpecUnitSpecEncoder: Encoder[Spec.UnitSpec] = Encoder.instance(((cc: Spec.UnitSpec) => Json.obj(
      "width".->(cc.width.asJson),
      "height".->(cc.height.asJson),
      "mark".->(cc.mark.asJson),
      "encoding".->(cc.encoding.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val SpecUnitSpecDecoder: Decoder[Spec.UnitSpec] = Decoder.instance { (c: HCursor) =>
      for {
        width <- c.downField("width").as[Option[Double]]
        height <- c.downField("height").as[Option[Double]]
        mark <- c.downField("mark").as[Mark]
        encoding <- c.downField("encoding").as[Option[UnitEncoding]]
        name <- c.downField("name").as[Option[String]]
        description <- c.downField("description").as[Option[String]]
        data <- c.downField("data").as[Option[Data]]
        transform <- c.downField("transform").as[Option[Transform]]
        config <- c.downField("config").as[Option[Config]]
      } yield {
        Spec.UnitSpec(
          width,
          height,
          mark,
          encoding,
          name,
          description,
          data,
          transform,
          config)
      }
    }

    implicit val SpecUnitEncodingEncoder: Encoder[Spec.UnitEncoding] = Encoder.instance {
      (cc: Spec.UnitEncoding) =>
        Json.obj(
          "x".->(cc.x.asJson),
          "y".->(cc.y.asJson),
          "x2".->(cc.x2.asJson),
          "y2".->(cc.y2.asJson),
          "color".->(cc.color.asJson),
          "opacity".->(cc.opacity.asJson),
          "size".->(cc.size.asJson),
          "shape".->(cc.shape.asJson),
          "detail".->(cc.detail.asJson),
          "text".->(cc.text.asJson),
          "label".->(cc.label.asJson),
          "path".->(cc.path.asJson),
          "order".->(cc.order.asJson))
    }

    implicit val SpecUnitEncodingDecoder: Decoder[Spec.UnitEncoding] = Decoder.instance { (c: HCursor) =>
      for {
        x <- c.downField("x").as[Option[PositionChannelDef]]
        y <- c.downField("y").as[Option[PositionChannelDef]]
        x2 <- c.downField("x2").as[Option[FieldDef]]
        y2 <- c.downField("y2").as[Option[FieldDef]]
        color <- c.downField("color").as[Option[ChannelDefWithLegend]]
        opacity <- c.downField("opacity").as[Option[ChannelDefWithLegend]]
        size <- c.downField("size").as[Option[ChannelDefWithLegend]]
        shape <- c.downField("shape").as[Option[ChannelDefWithLegend]]
        detail <- c.downField("detail").as[Option[UnitEncoding.DetailUnion]]
        text <- c.downField("text").as[Option[FieldDef]]
        label <- c.downField("label").as[Option[FieldDef]]
        path <- c.downField("path").as[Option[UnitEncoding.PathUnion]]
        order <- c.downField("order").as[Option[UnitEncoding.OrderUnion]]
      } yield {
        Spec.UnitEncoding(
          x,
          y,
          x2,
          y2,
          color,
          opacity,
          size,
          shape,
          detail,
          text,
          label,
          path,
          order)
      }
    }

    implicit val SpecUnitEncodingDetailUnionEncoder: Encoder[Spec.UnitEncoding.DetailUnion] = Encoder.instance({
      case (ut @ ((_): Spec.UnitEncoding.DetailFieldDef)) => ut.x.asJson
      case (ut @ ((_): Spec.UnitEncoding.DetailListFieldDef)) => ut.x.asJson
    });
    implicit val SpecUnitEncodingDetailUnionDecoder: Decoder[Spec.UnitEncoding.DetailUnion] = Decoder.instance(((c: HCursor) => c.as[FieldDef].map(((x) => Spec.UnitEncoding.DetailFieldDef(x))).orElse(c.as[List[FieldDef]].map(((x) => Spec.UnitEncoding.DetailListFieldDef(x))))));
    implicit val SpecUnitEncodingPathUnionEncoder: Encoder[Spec.UnitEncoding.PathUnion] = Encoder.instance({
      case (ut @ ((_): Spec.UnitEncoding.PathOrderChannelDef)) => ut.x.asJson
      case (ut @ ((_): Spec.UnitEncoding.PathListOrderChannelDef)) => ut.x.asJson
    });
    implicit val SpecUnitEncodingPathUnionDecoder: Decoder[Spec.UnitEncoding.PathUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec.UnitEncoding.PathOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec.UnitEncoding.PathListOrderChannelDef(x))))));
    implicit val SpecUnitEncodingOrderUnionEncoder: Encoder[Spec.UnitEncoding.OrderUnion] = Encoder.instance({
      case (ut @ ((_): Spec.UnitEncoding.OrderOrderChannelDef)) => ut.x.asJson
      case (ut @ ((_): Spec.UnitEncoding.OrderListOrderChannelDef)) => ut.x.asJson
    });
    implicit val SpecUnitEncodingOrderUnionDecoder: Decoder[Spec.UnitEncoding.OrderUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec.UnitEncoding.OrderOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec.UnitEncoding.OrderListOrderChannelDef(x))))));
    implicit val SpecVegaUnionEncoder: Encoder[Spec.VegaUnion] = Encoder.instance({
      case (ut @ ((_): Spec.VegaExtendedUnitSpec)) => ut.x.asJson
      case (ut @ ((_): Spec.VegaFacetSpec)) => ut.x.asJson
      case (ut @ ((_): Spec.VegaLayerSpec)) => ut.x.asJson
    });
    implicit val SpecVegaUnionDecoder: Decoder[Spec.VegaUnion] = Decoder.instance(((c: HCursor) => c.as[ExtendedUnitSpec].map(((x) => Spec.VegaExtendedUnitSpec(x))).orElse(c.as[FacetSpec].map(((x) => Spec.VegaFacetSpec(x)))).orElse(c.as[LayerSpec].map(((x) => Spec.VegaLayerSpec(x))))))
  };
  object Implicits extends LowPriorityImplicits
}
