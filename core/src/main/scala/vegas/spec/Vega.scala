package vegas.spec

object Spec2 {

  @enum sealed trait Mark extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait AxisOrient extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait ScaleType extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait NiceTime extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait AggregateOp extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait SortOrder extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait Type extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait TimeUnit extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait DataFormatType extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait StackOffset extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait Orient extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait Interpolate extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait Shape extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait HorizontalAlign extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait VerticalAlign extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait FontStyle extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait FontWeight extends scala.Product with scala.Serializable {
    def json: String
  };

  @enum sealed trait AreaOverlay extends scala.Product with scala.Serializable {
    def json: String
  };

  @union sealed trait VegaUnion extends scala.Product with scala.Serializable;

  trait LowPriorityImplicits {

    import io.circe._
    import io.circe.syntax._;

    implicit val Spec2ExtendedUnitSpecEncoder: Encoder[Spec2.ExtendedUnitSpec] = Encoder.instance(((cc: Spec2.ExtendedUnitSpec) => Json.obj("mark".->(cc.mark.asJson),
      "encoding".->(cc.encoding.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val Spec2ExtendedUnitSpecDecoder: Decoder[Spec2.ExtendedUnitSpec] = Decoder.instance(((c: HCursor) => c.downField("mark").as[Mark]
      .flatMap(((mark) => c.downField("encoding").as[Option[Encoding]]
        .flatMap(((encoding) => c.downField("name").as[Option[String]]
          .flatMap(((name) => c.downField("description").as[Option[String]]
            .flatMap(((description) => c.downField("data").as[Option[Data]]
              .flatMap(((data) => c.downField("transform").as[Option[Transform]]
                .flatMap(((transform) => c.downField("config").as[Option[Config]].map(((config) => Spec2.ExtendedUnitSpec(mark,
                  encoding,
                  name,
                  description,
                  data,
                  transform,
                  config)))))))))))))))));
    implicit val Spec2MarkEncoder: Encoder[Spec2.Mark] = Encoder.instance(((e: Spec2.Mark) => parser.parse(e.json).toOption.get));
    implicit val Spec2MarkDecoder: Decoder[Spec2.Mark] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"area\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Area)
        case (j@_) if j.==(parser.parse("\"bar\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Bar)
        case (j@_) if j.==(parser.parse("\"line\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Line)
        case (j@_) if j.==(parser.parse("\"point\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Point)
        case (j@_) if j.==(parser.parse("\"text\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Text)
        case (j@_) if j.==(parser.parse("\"tick\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Tick)
        case (j@_) if j.==(parser.parse("\"rule\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Rule)
        case (j@_) if j.==(parser.parse("\"circle\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Circle)
        case (j@_) if j.==(parser.parse("\"square\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.Square)
        case (j@_) if j.==(parser.parse("\"errorBar\"").toOption.get) => cats.data.Xor.right(Spec2.MarkEnums.ErrorBar)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2EncodingEncoder: Encoder[Spec2.Encoding] = Encoder.instance(((cc: Spec2.Encoding) => Json.obj("row".->(cc.row.asJson),
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
    implicit val Spec2EncodingDecoder: Decoder[Spec2.Encoding] = Decoder.instance(((c: HCursor) => c.downField("row").as[Option[PositionChannelDef]]
      .flatMap(((row) => c.downField("column").as[Option[PositionChannelDef]]
        .flatMap(((column) => c.downField("x").as[Option[PositionChannelDef]]
          .flatMap(((x) => c.downField("y").as[Option[PositionChannelDef]]
            .flatMap(((y) => c.downField("x2").as[Option[PositionChannelDef]]
              .flatMap(((x2) => c.downField("y2").as[Option[PositionChannelDef]]
                .flatMap(((y2) => c.downField("color").as[Option[ChannelDefWithLegend]]
                  .flatMap(((color) => c.downField("opacity").as[Option[ChannelDefWithLegend]]
                    .flatMap(((opacity) => c.downField("size").as[Option[ChannelDefWithLegend]]
                      .flatMap(((size) => c.downField("shape").as[Option[ChannelDefWithLegend]]
                        .flatMap(((shape) => c.downField("detail").as[Option[Encoding.DetailUnion]]
                          .flatMap(((detail) => c.downField("text").as[Option[FieldDef]]
                            .flatMap(((text) => c.downField("label").as[Option[FieldDef]]
                              .flatMap(((label) => c.downField("path").as[Option[Encoding.PathUnion]]
                                .flatMap(((path) => c.downField("order").as[Option[Encoding.OrderUnion]].map(((order) => Spec2.Encoding(row,
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
                                  order)))))))))))))))))))))))))))))))));
    implicit val Spec2EncodingDetailUnionEncoder: Encoder[Spec2.Encoding.DetailUnion] = Encoder.instance({
      case (ut@((_): Spec2.Encoding.DetailFieldDef) ) => ut.x.asJson
      case (ut@((_): Spec2.Encoding.DetailListFieldDef)) => ut.x.asJson
    });
    implicit val Spec2EncodingDetailUnionDecoder: Decoder[Spec2.Encoding.DetailUnion] = Decoder.instance(((c: HCursor) => c.as[FieldDef].map(((x) => Spec2.Encoding.DetailFieldDef(x))).orElse(c.as[List[FieldDef]].map(((x) => Spec2.Encoding.DetailListFieldDef(x))))));
    implicit val Spec2EncodingPathUnionEncoder: Encoder[Spec2.Encoding.PathUnion] = Encoder.instance({
      case (ut@((_): Spec2.Encoding.PathOrderChannelDef) ) => ut.x.asJson
      case (ut@((_): Spec2.Encoding.PathListOrderChannelDef)) => ut.x.asJson
    });
    implicit val Spec2EncodingPathUnionDecoder: Decoder[Spec2.Encoding.PathUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec2.Encoding.PathOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec2.Encoding.PathListOrderChannelDef(x))))));
    implicit val Spec2EncodingOrderUnionEncoder: Encoder[Spec2.Encoding.OrderUnion] = Encoder.instance({
      case (ut@((_): Spec2.Encoding.OrderOrderChannelDef) ) => ut.x.asJson
      case (ut@((_): Spec2.Encoding.OrderListOrderChannelDef)) => ut.x.asJson
    });
    implicit val Spec2EncodingOrderUnionDecoder: Decoder[Spec2.Encoding.OrderUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec2.Encoding.OrderOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec2.Encoding.OrderListOrderChannelDef(x))))));
    implicit val Spec2PositionChannelDefEncoder: Encoder[Spec2.PositionChannelDef] = Encoder.instance(((cc: Spec2.PositionChannelDef) => Json.obj("axis".->(cc.axis.asJson),
      "scale".->(cc.scale.asJson),
      "sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val Spec2PositionChannelDefDecoder: Decoder[Spec2.PositionChannelDef] = Decoder.instance(((c: HCursor) => c.downField("axis").as[Option[PositionChannelDef.AxisUnion]]
      .flatMap(((axis) => c.downField("scale").as[Option[Scale]]
        .flatMap(((scale) => c.downField("sort").as[Option[PositionChannelDef.SortUnion]]
          .flatMap(((sort) => c.downField("field").as[Option[String]]
            .flatMap(((field) => c.downField("type").as[Option[Type]]
              .flatMap(((`type`) => c.downField("value").as[Option[PositionChannelDef.ValueUnion]]
                .flatMap(((value) => c.downField("timeUnit").as[Option[TimeUnit]]
                  .flatMap(((timeUnit) => c.downField("bin").as[Option[PositionChannelDef.BinUnion]]
                    .flatMap(((bin) => c.downField("aggregate").as[Option[AggregateOp]]
                      .flatMap(((aggregate) => c.downField("title").as[Option[String]].map(((title) => Spec2.PositionChannelDef(axis,
                        scale,
                        sort,
                        field,
                        `type`,
                        value,
                        timeUnit,
                        bin,
                        aggregate,
                        title)))))))))))))))))))))));
    implicit val Spec2PositionChannelDefAxisUnionEncoder: Encoder[Spec2.PositionChannelDef.AxisUnion] = Encoder.instance({
      case (ut@((_): Spec2.PositionChannelDef.AxisBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.PositionChannelDef.AxisAxis)) => ut.x.asJson
    });
    implicit val Spec2PositionChannelDefAxisUnionDecoder: Decoder[Spec2.PositionChannelDef.AxisUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.PositionChannelDef.AxisBoolean(x))).orElse(c.as[Axis].map(((x) => Spec2.PositionChannelDef.AxisAxis(x))))));
    implicit val Spec2PositionChannelDefSortUnionEncoder: Encoder[Spec2.PositionChannelDef.SortUnion] = Encoder.instance({
      case (ut@((_): Spec2.PositionChannelDef.SortSortField) ) => ut.x.asJson
      case (ut@((_): Spec2.PositionChannelDef.SortSortOrder)) => ut.x.asJson
    });
    implicit val Spec2PositionChannelDefSortUnionDecoder: Decoder[Spec2.PositionChannelDef.SortUnion] = Decoder.instance(((c: HCursor) => c.as[SortField].map(((x) => Spec2.PositionChannelDef.SortSortField(x))).orElse(c.as[SortOrder].map(((x) => Spec2.PositionChannelDef.SortSortOrder(x))))));
    implicit val Spec2PositionChannelDefValueUnionEncoder: Encoder[Spec2.PositionChannelDef.ValueUnion] = Encoder.instance({
      case (ut@((_): Spec2.PositionChannelDef.ValueDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.PositionChannelDef.ValueString)) => ut.x.asJson
      case (ut@((_): Spec2.PositionChannelDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val Spec2PositionChannelDefValueUnionDecoder: Decoder[Spec2.PositionChannelDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.PositionChannelDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec2.PositionChannelDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec2.PositionChannelDef.ValueBoolean(x))))));
    implicit val Spec2PositionChannelDefBinUnionEncoder: Encoder[Spec2.PositionChannelDef.BinUnion] = Encoder.instance({
      case (ut@((_): Spec2.PositionChannelDef.BinBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.PositionChannelDef.BinBin)) => ut.x.asJson
    });
    implicit val Spec2PositionChannelDefBinUnionDecoder: Decoder[Spec2.PositionChannelDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.PositionChannelDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec2.PositionChannelDef.BinBin(x))))));
    implicit val Spec2AxisEncoder: Encoder[Spec2.Axis] = Encoder.instance(((cc: Spec2.Axis) => Json.obj("labelAngle".->(cc.labelAngle.asJson),
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
      "properties".->(cc.properties.asJson))));
    implicit val Spec2AxisDecoder: Decoder[Spec2.Axis] = Decoder.instance(((c: HCursor) => c.downField("labelAngle").as[Option[Double]]
      .flatMap(((labelAngle) => c.downField("format").as[Option[String]]
        .flatMap(((format) => c.downField("orient").as[Option[AxisOrient]]
          .flatMap(((orient) => c.downField("title").as[Option[String]]
            .flatMap(((title) => c.downField("values").as[Option[List[Double]]]
              .flatMap(((values) => c.downField("axisWidth").as[Option[Double]]
                .flatMap(((axisWidth) => c.downField("layer").as[Option[String]]
                  .flatMap(((layer) => c.downField("offset").as[Option[Double]]
                    .flatMap(((offset) => c.downField("axisColor").as[Option[String]]
                      .flatMap(((axisColor) => c.downField("grid").as[Option[Boolean]]
                        .flatMap(((grid) => c.downField("gridColor").as[Option[String]]
                          .flatMap(((gridColor) => c.downField("gridDash").as[Option[List[Double]]]
                            .flatMap(((gridDash) => c.downField("gridOpacity").as[Option[Double]]
                              .flatMap(((gridOpacity) => c.downField("gridWidth").as[Option[Double]]
                                .flatMap(((gridWidth) => c.downField("labels").as[Option[Boolean]]
                                  .flatMap(((labels) => c.downField("labelAlign").as[Option[String]]
                                    .flatMap(((labelAlign) => c.downField("labelBaseline").as[Option[String]]
                                      .flatMap(((labelBaseline) => c.downField("labelMaxLength").as[Option[Double]]
                                        .flatMap(((labelMaxLength) => c.downField("shortTimeLabels").as[Option[Boolean]]
                                          .flatMap(((shortTimeLabels) => c.downField("subdivide").as[Option[Double]]
                                            .flatMap(((subdivide) => c.downField("ticks").as[Option[Double]]
                                              .flatMap(((ticks) => c.downField("tickColor").as[Option[String]]
                                                .flatMap(((tickColor) => c.downField("tickLabelColor").as[Option[String]]
                                                  .flatMap(((tickLabelColor) => c.downField("tickLabelFont").as[Option[String]]
                                                    .flatMap(((tickLabelFont) => c.downField("tickLabelFontSize").as[Option[Double]]
                                                      .flatMap(((tickLabelFontSize) => c.downField("tickPadding").as[Option[Double]]
                                                        .flatMap(((tickPadding) => c.downField("tickSize").as[Option[Double]]
                                                          .flatMap(((tickSize) => c.downField("tickSizeMajor").as[Option[Double]]
                                                            .flatMap(((tickSizeMajor) => c.downField("tickSizeMinor").as[Option[Double]]
                                                              .flatMap(((tickSizeMinor) => c.downField("tickSizeEnd").as[Option[Double]]
                                                                .flatMap(((tickSizeEnd) => c.downField("tickWidth").as[Option[Double]]
                                                                  .flatMap(((tickWidth) => c.downField("titleColor").as[Option[String]]
                                                                    .flatMap(((titleColor) => c.downField("titleFont").as[Option[String]]
                                                                      .flatMap(((titleFont) => c.downField("titleFontSize").as[Option[Double]]
                                                                        .flatMap(((titleFontSize) => c.downField("titleFontWeight").as[Option[String]]
                                                                          .flatMap(((titleFontWeight) => c.downField("titleOffset").as[Option[Double]]
                                                                            .flatMap(((titleOffset) => c.downField("titleMaxLength").as[Option[Double]]
                                                                              .flatMap(((titleMaxLength) => c.downField("characterWidth").as[Option[Double]]
                                                                                .flatMap(((characterWidth) => c.downField("properties").as[Option[Axis.Properties]].map(((properties) => Spec2.Axis(labelAngle,
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
                                                                                  properties)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    implicit val Spec2AxisPropertiesEncoder: Encoder[Spec2.Axis.Properties] = Encoder.instance(((wrapper: Spec2.Axis.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2AxisPropertiesDecoder: Decoder[Spec2.Axis.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$1) => Spec2.Axis.Properties(x$1)))));
    implicit val Spec2AxisOrientEncoder: Encoder[Spec2.AxisOrient] = Encoder.instance(((e: Spec2.AxisOrient) => parser.parse(e.json).toOption.get));
    implicit val Spec2AxisOrientDecoder: Decoder[Spec2.AxisOrient] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"top\"").toOption.get) => cats.data.Xor.right(Spec2.AxisOrientEnums.Top)
        case (j@_) if j.==(parser.parse("\"right\"").toOption.get) => cats.data.Xor.right(Spec2.AxisOrientEnums.Right)
        case (j@_) if j.==(parser.parse("\"left\"").toOption.get) => cats.data.Xor.right(Spec2.AxisOrientEnums.Left)
        case (j@_) if j.==(parser.parse("\"bottom\"").toOption.get) => cats.data.Xor.right(Spec2.AxisOrientEnums.Bottom)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2ScaleEncoder: Encoder[Spec2.Scale] = Encoder.instance(((cc: Spec2.Scale) => Json.obj("type".->(cc.`type`.asJson),
      "domain".->(cc.domain.asJson),
      "range".->(cc.range.asJson),
      "round".->(cc.round.asJson),
      "bandSize".->(cc.bandSize.asJson),
      "padding".->(cc.padding.asJson),
      "clamp".->(cc.clamp.asJson),
      "nice".->(cc.nice.asJson),
      "exponent".->(cc.exponent.asJson),
      "zero".->(cc.zero.asJson),
      "useRawDomain".->(cc.useRawDomain.asJson))));
    implicit val Spec2ScaleDecoder: Decoder[Spec2.Scale] = Decoder.instance(((c: HCursor) => c.downField("type").as[Option[ScaleType]]
      .flatMap(((`type`) => c.downField("domain").as[Option[Scale.DomainUnion]]
        .flatMap(((domain) => c.downField("range").as[Option[Scale.RangeUnion]]
          .flatMap(((range) => c.downField("round").as[Option[Boolean]]
            .flatMap(((round) => c.downField("bandSize").as[Option[Double]]
              .flatMap(((bandSize) => c.downField("padding").as[Option[Double]]
                .flatMap(((padding) => c.downField("clamp").as[Option[Boolean]]
                  .flatMap(((clamp) => c.downField("nice").as[Option[Scale.NiceUnion]]
                    .flatMap(((nice) => c.downField("exponent").as[Option[Double]]
                      .flatMap(((exponent) => c.downField("zero").as[Option[Boolean]]
                        .flatMap(((zero) => c.downField("useRawDomain").as[Option[Boolean]].map(((useRawDomain) => Spec2.Scale(`type`,
                          domain,
                          range,
                          round,
                          bandSize,
                          padding,
                          clamp,
                          nice,
                          exponent,
                          zero,
                          useRawDomain)))))))))))))))))))))))));
    implicit val Spec2ScaleDomainUnionEncoder: Encoder[Spec2.Scale.DomainUnion] = Encoder.instance({
      case (ut@((_): Spec2.Scale.DomainListDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.Scale.DomainListString)) => ut.x.asJson
    });
    implicit val Spec2ScaleDomainUnionDecoder: Decoder[Spec2.Scale.DomainUnion] = Decoder.instance(((c: HCursor) => c.as[List[Double]].map(((x) => Spec2.Scale.DomainListDouble(x))).orElse(c.as[List[String]].map(((x) => Spec2.Scale.DomainListString(x))))));
    implicit val Spec2ScaleRangeUnionEncoder: Encoder[Spec2.Scale.RangeUnion] = Encoder.instance({
      case (ut@((_): Spec2.Scale.RangeString) ) => ut.x.asJson
      case (ut@((_): Spec2.Scale.RangeListDouble)) => ut.x.asJson
      case (ut@((_): Spec2.Scale.RangeListString)) => ut.x.asJson
    });
    implicit val Spec2ScaleRangeUnionDecoder: Decoder[Spec2.Scale.RangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.Scale.RangeString(x))).orElse(c.as[List[Double]].map(((x) => Spec2.Scale.RangeListDouble(x)))).orElse(c.as[List[String]].map(((x) => Spec2.Scale.RangeListString(x))))));
    implicit val Spec2ScaleNiceUnionEncoder: Encoder[Spec2.Scale.NiceUnion] = Encoder.instance({
      case (ut@((_): Spec2.Scale.NiceBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.Scale.NiceNiceTime)) => ut.x.asJson
    });
    implicit val Spec2ScaleNiceUnionDecoder: Decoder[Spec2.Scale.NiceUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.Scale.NiceBoolean(x))).orElse(c.as[NiceTime].map(((x) => Spec2.Scale.NiceNiceTime(x))))));
    implicit val Spec2ScaleTypeEncoder: Encoder[Spec2.ScaleType] = Encoder.instance(((e: Spec2.ScaleType) => parser.parse(e.json).toOption.get));
    implicit val Spec2ScaleTypeDecoder: Decoder[Spec2.ScaleType] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"linear\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Linear)
        case (j@_) if j.==(parser.parse("\"log\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Log)
        case (j@_) if j.==(parser.parse("\"pow\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Pow)
        case (j@_) if j.==(parser.parse("\"sqrt\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Sqrt)
        case (j@_) if j.==(parser.parse("\"quantile\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Quantile)
        case (j@_) if j.==(parser.parse("\"quantize\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Quantize)
        case (j@_) if j.==(parser.parse("\"ordinal\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Ordinal)
        case (j@_) if j.==(parser.parse("\"time\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Time)
        case (j@_) if j.==(parser.parse("\"utc\"").toOption.get) => cats.data.Xor.right(Spec2.ScaleTypeEnums.Utc)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2NiceTimeEncoder: Encoder[Spec2.NiceTime] = Encoder.instance(((e: Spec2.NiceTime) => parser.parse(e.json).toOption.get));
    implicit val Spec2NiceTimeDecoder: Decoder[Spec2.NiceTime] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"second\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Second)
        case (j@_) if j.==(parser.parse("\"minute\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Minute)
        case (j@_) if j.==(parser.parse("\"hour\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Hour)
        case (j@_) if j.==(parser.parse("\"day\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Day)
        case (j@_) if j.==(parser.parse("\"week\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Week)
        case (j@_) if j.==(parser.parse("\"month\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Month)
        case (j@_) if j.==(parser.parse("\"year\"").toOption.get) => cats.data.Xor.right(Spec2.NiceTimeEnums.Year)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2SortFieldEncoder: Encoder[Spec2.SortField] = Encoder.instance(((cc: Spec2.SortField) => Json.obj("field".->(cc.field.asJson),
      "op".->(cc.op.asJson),
      "order".->(cc.order.asJson))));
    implicit val Spec2SortFieldDecoder: Decoder[Spec2.SortField] = Decoder.instance(((c: HCursor) => c.downField("field").as[String]
      .flatMap(((field) => c.downField("op").as[AggregateOp]
        .flatMap(((op) => c.downField("order").as[Option[SortOrder]].map(((order) => Spec2.SortField(field,
          op,
          order)))))))));
    implicit val Spec2AggregateOpEncoder: Encoder[Spec2.AggregateOp] = Encoder.instance(((e: Spec2.AggregateOp) => parser.parse(e.json).toOption.get));
    implicit val Spec2AggregateOpDecoder: Decoder[Spec2.AggregateOp] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"values\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Values)
        case (j@_) if j.==(parser.parse("\"count\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Count)
        case (j@_) if j.==(parser.parse("\"valid\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Valid)
        case (j@_) if j.==(parser.parse("\"missing\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Missing)
        case (j@_) if j.==(parser.parse("\"distinct\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Distinct)
        case (j@_) if j.==(parser.parse("\"sum\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Sum)
        case (j@_) if j.==(parser.parse("\"mean\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Mean)
        case (j@_) if j.==(parser.parse("\"average\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Average)
        case (j@_) if j.==(parser.parse("\"variance\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Variance)
        case (j@_) if j.==(parser.parse("\"variancep\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Variancep)
        case (j@_) if j.==(parser.parse("\"stdev\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Stdev)
        case (j@_) if j.==(parser.parse("\"stdevp\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Stdevp)
        case (j@_) if j.==(parser.parse("\"median\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Median)
        case (j@_) if j.==(parser.parse("\"q1\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Q1)
        case (j@_) if j.==(parser.parse("\"q3\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Q3)
        case (j@_) if j.==(parser.parse("\"modeskew\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Modeskew)
        case (j@_) if j.==(parser.parse("\"min\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Min)
        case (j@_) if j.==(parser.parse("\"max\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Max)
        case (j@_) if j.==(parser.parse("\"argmin\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Argmin)
        case (j@_) if j.==(parser.parse("\"argmax\"").toOption.get) => cats.data.Xor.right(Spec2.AggregateOpEnums.Argmax)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2SortOrderEncoder: Encoder[Spec2.SortOrder] = Encoder.instance(((e: Spec2.SortOrder) => parser.parse(e.json).toOption.get));
    implicit val Spec2SortOrderDecoder: Decoder[Spec2.SortOrder] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"ascending\"").toOption.get) => cats.data.Xor.right(Spec2.SortOrderEnums.Ascending)
        case (j@_) if j.==(parser.parse("\"descending\"").toOption.get) => cats.data.Xor.right(Spec2.SortOrderEnums.Descending)
        case (j@_) if j.==(parser.parse("\"none\"").toOption.get) => cats.data.Xor.right(Spec2.SortOrderEnums.None)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2TypeEncoder: Encoder[Spec2.Type] = Encoder.instance(((e: Spec2.Type) => parser.parse(e.json).toOption.get));
    implicit val Spec2TypeDecoder: Decoder[Spec2.Type] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"quantitative\"").toOption.get) => cats.data.Xor.right(Spec2.TypeEnums.Quantitative)
        case (j@_) if j.==(parser.parse("\"ordinal\"").toOption.get) => cats.data.Xor.right(Spec2.TypeEnums.Ordinal)
        case (j@_) if j.==(parser.parse("\"temporal\"").toOption.get) => cats.data.Xor.right(Spec2.TypeEnums.Temporal)
        case (j@_) if j.==(parser.parse("\"nominal\"").toOption.get) => cats.data.Xor.right(Spec2.TypeEnums.Nominal)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2TimeUnitEncoder: Encoder[Spec2.TimeUnit] = Encoder.instance(((e: Spec2.TimeUnit) => parser.parse(e.json).toOption.get));
    implicit val Spec2TimeUnitDecoder: Decoder[Spec2.TimeUnit] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"year\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Year)
        case (j@_) if j.==(parser.parse("\"month\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Month)
        case (j@_) if j.==(parser.parse("\"day\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Day)
        case (j@_) if j.==(parser.parse("\"date\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Date)
        case (j@_) if j.==(parser.parse("\"hours\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Hours)
        case (j@_) if j.==(parser.parse("\"minutes\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Minutes)
        case (j@_) if j.==(parser.parse("\"seconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Seconds)
        case (j@_) if j.==(parser.parse("\"milliseconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Milliseconds)
        case (j@_) if j.==(parser.parse("\"yearmonth\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearmonth)
        case (j@_) if j.==(parser.parse("\"yearmonthdate\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearmonthdate)
        case (j@_) if j.==(parser.parse("\"yearmonthdatehours\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearmonthdatehours)
        case (j@_) if j.==(parser.parse("\"yearmonthdatehoursminutes\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearmonthdatehoursminutes)
        case (j@_) if j.==(parser.parse("\"yearmonthdatehoursminutesseconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearmonthdatehoursminutesseconds)
        case (j@_) if j.==(parser.parse("\"hoursminutes\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Hoursminutes)
        case (j@_) if j.==(parser.parse("\"hoursminutesseconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Hoursminutesseconds)
        case (j@_) if j.==(parser.parse("\"minutesseconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Minutesseconds)
        case (j@_) if j.==(parser.parse("\"secondsmilliseconds\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Secondsmilliseconds)
        case (j@_) if j.==(parser.parse("\"quarter\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Quarter)
        case (j@_) if j.==(parser.parse("\"yearquarter\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearquarter)
        case (j@_) if j.==(parser.parse("\"quartermonth\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Quartermonth)
        case (j@_) if j.==(parser.parse("\"yearquartermonth\"").toOption.get) => cats.data.Xor.right(Spec2.TimeUnitEnums.Yearquartermonth)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2BinEncoder: Encoder[Spec2.Bin] = Encoder.instance(((cc: Spec2.Bin) => Json.obj("min".->(cc.min.asJson),
      "max".->(cc.max.asJson),
      "base".->(cc.base.asJson),
      "step".->(cc.step.asJson),
      "steps".->(cc.steps.asJson),
      "minstep".->(cc.minstep.asJson),
      "div".->(cc.div.asJson),
      "maxbins".->(cc.maxbins.asJson))));
    implicit val Spec2BinDecoder: Decoder[Spec2.Bin] = Decoder.instance(((c: HCursor) => c.downField("min").as[Option[Double]]
      .flatMap(((min) => c.downField("max").as[Option[Double]]
        .flatMap(((max) => c.downField("base").as[Option[Double]]
          .flatMap(((base) => c.downField("step").as[Option[Double]]
            .flatMap(((step) => c.downField("steps").as[Option[List[Double]]]
              .flatMap(((steps) => c.downField("minstep").as[Option[Double]]
                .flatMap(((minstep) => c.downField("div").as[Option[List[Double]]]
                  .flatMap(((div) => c.downField("maxbins").as[Option[Double]].map(((maxbins) => Spec2.Bin(min,
                    max,
                    base,
                    step,
                    steps,
                    minstep,
                    div,
                    maxbins)))))))))))))))))));
    implicit val Spec2ChannelDefWithLegendEncoder: Encoder[Spec2.ChannelDefWithLegend] = Encoder.instance(((cc: Spec2.ChannelDefWithLegend) => Json.obj("legend".->(cc.legend.asJson),
      "scale".->(cc.scale.asJson),
      "sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val Spec2ChannelDefWithLegendDecoder: Decoder[Spec2.ChannelDefWithLegend] = Decoder.instance(((c: HCursor) => c.downField("legend").as[Option[Legend]]
      .flatMap(((legend) => c.downField("scale").as[Option[Scale]]
        .flatMap(((scale) => c.downField("sort").as[Option[ChannelDefWithLegend.SortUnion]]
          .flatMap(((sort) => c.downField("field").as[Option[String]]
            .flatMap(((field) => c.downField("type").as[Option[Type]]
              .flatMap(((`type`) => c.downField("value").as[Option[ChannelDefWithLegend.ValueUnion]]
                .flatMap(((value) => c.downField("timeUnit").as[Option[TimeUnit]]
                  .flatMap(((timeUnit) => c.downField("bin").as[Option[ChannelDefWithLegend.BinUnion]]
                    .flatMap(((bin) => c.downField("aggregate").as[Option[AggregateOp]]
                      .flatMap(((aggregate) => c.downField("title").as[Option[String]].map(((title) => Spec2.ChannelDefWithLegend(legend,
                        scale,
                        sort,
                        field,
                        `type`,
                        value,
                        timeUnit,
                        bin,
                        aggregate,
                        title)))))))))))))))))))))));
    implicit val Spec2ChannelDefWithLegendSortUnionEncoder: Encoder[Spec2.ChannelDefWithLegend.SortUnion] = Encoder.instance({
      case (ut@((_): Spec2.ChannelDefWithLegend.SortSortField) ) => ut.x.asJson
      case (ut@((_): Spec2.ChannelDefWithLegend.SortSortOrder)) => ut.x.asJson
    });
    implicit val Spec2ChannelDefWithLegendSortUnionDecoder: Decoder[Spec2.ChannelDefWithLegend.SortUnion] = Decoder.instance(((c: HCursor) => c.as[SortField].map(((x) => Spec2.ChannelDefWithLegend.SortSortField(x))).orElse(c.as[SortOrder].map(((x) => Spec2.ChannelDefWithLegend.SortSortOrder(x))))));
    implicit val Spec2ChannelDefWithLegendValueUnionEncoder: Encoder[Spec2.ChannelDefWithLegend.ValueUnion] = Encoder.instance({
      case (ut@((_): Spec2.ChannelDefWithLegend.ValueDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.ChannelDefWithLegend.ValueString)) => ut.x.asJson
      case (ut@((_): Spec2.ChannelDefWithLegend.ValueBoolean)) => ut.x.asJson
    });
    implicit val Spec2ChannelDefWithLegendValueUnionDecoder: Decoder[Spec2.ChannelDefWithLegend.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.ChannelDefWithLegend.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec2.ChannelDefWithLegend.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec2.ChannelDefWithLegend.ValueBoolean(x))))));
    implicit val Spec2ChannelDefWithLegendBinUnionEncoder: Encoder[Spec2.ChannelDefWithLegend.BinUnion] = Encoder.instance({
      case (ut@((_): Spec2.ChannelDefWithLegend.BinBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.ChannelDefWithLegend.BinBin)) => ut.x.asJson
    });
    implicit val Spec2ChannelDefWithLegendBinUnionDecoder: Decoder[Spec2.ChannelDefWithLegend.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.ChannelDefWithLegend.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec2.ChannelDefWithLegend.BinBin(x))))));
    implicit val Spec2LegendEncoder: Encoder[Spec2.Legend] = Encoder.instance(((cc: Spec2.Legend) => Json.obj("format".->(cc.format.asJson),
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
    implicit val Spec2LegendDecoder: Decoder[Spec2.Legend] = Decoder.instance(((c: HCursor) => c.downField("format").as[Option[String]]
      .flatMap(((format) => c.downField("title").as[Option[String]]
        .flatMap(((title) => c.downField("values").as[Option[List[Legend.Values]]]
          .flatMap(((values) => c.downField("orient").as[Option[String]]
            .flatMap(((orient) => c.downField("offset").as[Option[Double]]
              .flatMap(((offset) => c.downField("padding").as[Option[Double]]
                .flatMap(((padding) => c.downField("margin").as[Option[Double]]
                  .flatMap(((margin) => c.downField("gradientStrokeColor").as[Option[String]]
                    .flatMap(((gradientStrokeColor) => c.downField("gradientStrokeWidth").as[Option[Double]]
                      .flatMap(((gradientStrokeWidth) => c.downField("gradientHeight").as[Option[Double]]
                        .flatMap(((gradientHeight) => c.downField("gradientWidth").as[Option[Double]]
                          .flatMap(((gradientWidth) => c.downField("labelAlign").as[Option[String]]
                            .flatMap(((labelAlign) => c.downField("labelBaseline").as[Option[String]]
                              .flatMap(((labelBaseline) => c.downField("labelColor").as[Option[String]]
                                .flatMap(((labelColor) => c.downField("labelFont").as[Option[String]]
                                  .flatMap(((labelFont) => c.downField("labelFontSize").as[Option[Double]]
                                    .flatMap(((labelFontSize) => c.downField("labelOffset").as[Option[Double]]
                                      .flatMap(((labelOffset) => c.downField("shortTimeLabels").as[Option[Boolean]]
                                        .flatMap(((shortTimeLabels) => c.downField("symbolColor").as[Option[String]]
                                          .flatMap(((symbolColor) => c.downField("symbolShape").as[Option[String]]
                                            .flatMap(((symbolShape) => c.downField("symbolSize").as[Option[Double]]
                                              .flatMap(((symbolSize) => c.downField("symbolStrokeWidth").as[Option[Double]]
                                                .flatMap(((symbolStrokeWidth) => c.downField("titleColor").as[Option[String]]
                                                  .flatMap(((titleColor) => c.downField("titleFont").as[Option[String]]
                                                    .flatMap(((titleFont) => c.downField("titleFontSize").as[Option[Double]]
                                                      .flatMap(((titleFontSize) => c.downField("titleFontWeight").as[Option[String]]
                                                        .flatMap(((titleFontWeight) => c.downField("properties").as[Option[Legend.Properties]].map(((properties) => Spec2.Legend(format,
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
                                                          properties)))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    implicit val Spec2LegendValuesEncoder: Encoder[Spec2.Legend.Values] = Encoder.instance(((wrapper: Spec2.Legend.Values) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2LegendValuesDecoder: Decoder[Spec2.Legend.Values] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$2) => Spec2.Legend.Values(x$2)))));
    implicit val Spec2LegendPropertiesEncoder: Encoder[Spec2.Legend.Properties] = Encoder.instance(((wrapper: Spec2.Legend.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2LegendPropertiesDecoder: Decoder[Spec2.Legend.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$3) => Spec2.Legend.Properties(x$3)))));
    implicit val Spec2FieldDefEncoder: Encoder[Spec2.FieldDef] = Encoder.instance(((cc: Spec2.FieldDef) => Json.obj("field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val Spec2FieldDefDecoder: Decoder[Spec2.FieldDef] = Decoder.instance(((c: HCursor) => c.downField("field").as[Option[String]]
      .flatMap(((field) => c.downField("type").as[Option[Type]]
        .flatMap(((`type`) => c.downField("value").as[Option[FieldDef.ValueUnion]]
          .flatMap(((value) => c.downField("timeUnit").as[Option[TimeUnit]]
            .flatMap(((timeUnit) => c.downField("bin").as[Option[FieldDef.BinUnion]]
              .flatMap(((bin) => c.downField("aggregate").as[Option[AggregateOp]]
                .flatMap(((aggregate) => c.downField("title").as[Option[String]].map(((title) => Spec2.FieldDef(field,
                  `type`,
                  value,
                  timeUnit,
                  bin,
                  aggregate,
                  title)))))))))))))))));
    implicit val Spec2FieldDefValueUnionEncoder: Encoder[Spec2.FieldDef.ValueUnion] = Encoder.instance({
      case (ut@((_): Spec2.FieldDef.ValueDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.FieldDef.ValueString)) => ut.x.asJson
      case (ut@((_): Spec2.FieldDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val Spec2FieldDefValueUnionDecoder: Decoder[Spec2.FieldDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.FieldDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec2.FieldDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec2.FieldDef.ValueBoolean(x))))));
    implicit val Spec2FieldDefBinUnionEncoder: Encoder[Spec2.FieldDef.BinUnion] = Encoder.instance({
      case (ut@((_): Spec2.FieldDef.BinBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.FieldDef.BinBin)) => ut.x.asJson
    });
    implicit val Spec2FieldDefBinUnionDecoder: Decoder[Spec2.FieldDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.FieldDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec2.FieldDef.BinBin(x))))));
    implicit val Spec2OrderChannelDefEncoder: Encoder[Spec2.OrderChannelDef] = Encoder.instance(((cc: Spec2.OrderChannelDef) => Json.obj("sort".->(cc.sort.asJson),
      "field".->(cc.field.asJson),
      "type".->(cc.`type`.asJson),
      "value".->(cc.value.asJson),
      "timeUnit".->(cc.timeUnit.asJson),
      "bin".->(cc.bin.asJson),
      "aggregate".->(cc.aggregate.asJson),
      "title".->(cc.title.asJson))));
    implicit val Spec2OrderChannelDefDecoder: Decoder[Spec2.OrderChannelDef] = Decoder.instance(((c: HCursor) => c.downField("sort").as[Option[SortOrder]]
      .flatMap(((sort) => c.downField("field").as[Option[String]]
        .flatMap(((field) => c.downField("type").as[Option[Type]]
          .flatMap(((`type`) => c.downField("value").as[Option[OrderChannelDef.ValueUnion]]
            .flatMap(((value) => c.downField("timeUnit").as[Option[TimeUnit]]
              .flatMap(((timeUnit) => c.downField("bin").as[Option[OrderChannelDef.BinUnion]]
                .flatMap(((bin) => c.downField("aggregate").as[Option[AggregateOp]]
                  .flatMap(((aggregate) => c.downField("title").as[Option[String]].map(((title) => Spec2.OrderChannelDef(sort,
                    field,
                    `type`,
                    value,
                    timeUnit,
                    bin,
                    aggregate,
                    title)))))))))))))))))));
    implicit val Spec2OrderChannelDefValueUnionEncoder: Encoder[Spec2.OrderChannelDef.ValueUnion] = Encoder.instance({
      case (ut@((_): Spec2.OrderChannelDef.ValueDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.OrderChannelDef.ValueString)) => ut.x.asJson
      case (ut@((_): Spec2.OrderChannelDef.ValueBoolean)) => ut.x.asJson
    });
    implicit val Spec2OrderChannelDefValueUnionDecoder: Decoder[Spec2.OrderChannelDef.ValueUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.OrderChannelDef.ValueDouble(x))).orElse(c.as[String].map(((x) => Spec2.OrderChannelDef.ValueString(x)))).orElse(c.as[Boolean].map(((x) => Spec2.OrderChannelDef.ValueBoolean(x))))));
    implicit val Spec2OrderChannelDefBinUnionEncoder: Encoder[Spec2.OrderChannelDef.BinUnion] = Encoder.instance({
      case (ut@((_): Spec2.OrderChannelDef.BinBoolean) ) => ut.x.asJson
      case (ut@((_): Spec2.OrderChannelDef.BinBin)) => ut.x.asJson
    });
    implicit val Spec2OrderChannelDefBinUnionDecoder: Decoder[Spec2.OrderChannelDef.BinUnion] = Decoder.instance(((c: HCursor) => c.as[Boolean].map(((x) => Spec2.OrderChannelDef.BinBoolean(x))).orElse(c.as[Bin].map(((x) => Spec2.OrderChannelDef.BinBin(x))))));
    implicit val Spec2DataEncoder: Encoder[Spec2.Data] = Encoder.instance(((cc: Spec2.Data) => Json.obj("format".->(cc.format.asJson),
      "url".->(cc.url.asJson),
      "values".->(cc.values.asJson))));
    implicit val Spec2DataDecoder: Decoder[Spec2.Data] = Decoder.instance(((c: HCursor) => c.downField("format").as[Option[DataFormat]]
      .flatMap(((format) => c.downField("url").as[Option[String]]
        .flatMap(((url) => c.downField("values").as[Option[List[Data.Values]]].map(((values) => Spec2.Data(format,
          url,
          values)))))))));
    implicit val Spec2DataValuesEncoder: Encoder[Spec2.Data.Values] = Encoder.instance(((wrapper: Spec2.Data.Values) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2DataValuesDecoder: Decoder[Spec2.Data.Values] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$4) => Spec2.Data.Values(x$4)))));
    implicit val Spec2DataFormatEncoder: Encoder[Spec2.DataFormat] = Encoder.instance(((cc: Spec2.DataFormat) => Json.obj("type".->(cc.`type`.asJson),
      "property".->(cc.property.asJson),
      "feature".->(cc.feature.asJson),
      "mesh".->(cc.mesh.asJson))));
    implicit val Spec2DataFormatDecoder: Decoder[Spec2.DataFormat] = Decoder.instance(((c: HCursor) => c.downField("type").as[Option[DataFormatType]]
      .flatMap(((`type`) => c.downField("property").as[Option[String]]
        .flatMap(((property) => c.downField("feature").as[Option[String]]
          .flatMap(((feature) => c.downField("mesh").as[Option[String]].map(((mesh) => Spec2.DataFormat(`type`,
            property,
            feature,
            mesh)))))))))));
    implicit val Spec2DataFormatTypeEncoder: Encoder[Spec2.DataFormatType] = Encoder.instance(((e: Spec2.DataFormatType) => parser.parse(e.json).toOption.get));
    implicit val Spec2DataFormatTypeDecoder: Decoder[Spec2.DataFormatType] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"json\"").toOption.get) => cats.data.Xor.right(Spec2.DataFormatTypeEnums.Json)
        case (j@_) if j.==(parser.parse("\"csv\"").toOption.get) => cats.data.Xor.right(Spec2.DataFormatTypeEnums.Csv)
        case (j@_) if j.==(parser.parse("\"tsv\"").toOption.get) => cats.data.Xor.right(Spec2.DataFormatTypeEnums.Tsv)
        case (j@_) if j.==(parser.parse("\"topojson\"").toOption.get) => cats.data.Xor.right(Spec2.DataFormatTypeEnums.Topojson)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2TransformEncoder: Encoder[Spec2.Transform] = Encoder.instance(((cc: Spec2.Transform) => Json.obj("filter".->(cc.filter.asJson),
      "filterInvalid".->(cc.filterInvalid.asJson),
      "calculate".->(cc.calculate.asJson))));
    implicit val Spec2TransformDecoder: Decoder[Spec2.Transform] = Decoder.instance(((c: HCursor) => c.downField("filter").as[Option[Transform.FilterUnion]]
      .flatMap(((filter) => c.downField("filterInvalid").as[Option[Boolean]]
        .flatMap(((filterInvalid) => c.downField("calculate").as[Option[List[Formula]]].map(((calculate) => Spec2.Transform(filter,
          filterInvalid,
          calculate)))))))));
    implicit val Spec2TransformFilterUnionEncoder: Encoder[Spec2.Transform.FilterUnion] = Encoder.instance({
      case (ut@((_): Spec2.Transform.FilterString) ) => ut.x.asJson
      case (ut@((_): Spec2.Transform.FilterEqualFilter)) => ut.x.asJson
      case (ut@((_): Spec2.Transform.FilterRangeFilter)) => ut.x.asJson
      case (ut@((_): Spec2.Transform.FilterInFilter)) => ut.x.asJson
      case (ut@((_): Spec2.Transform.FilterListTransformFilter5Union)) => ut.x.asJson
    });
    implicit val Spec2TransformFilterUnionDecoder: Decoder[Spec2.Transform.FilterUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.Transform.FilterString(x))).orElse(c.as[EqualFilter].map(((x) => Spec2.Transform.FilterEqualFilter(x)))).orElse(c.as[RangeFilter].map(((x) => Spec2.Transform.FilterRangeFilter(x)))).orElse(c.as[InFilter].map(((x) => Spec2.Transform.FilterInFilter(x)))).orElse(c.as[List[Transform.Filter5Union]].map(((x) => Spec2.Transform.FilterListTransformFilter5Union(x))))));
    implicit val Spec2TransformFilter5UnionEncoder: Encoder[Spec2.Transform.Filter5Union] = Encoder.instance({
      case (ut@((_): Spec2.Transform.Filter5String) ) => ut.x.asJson
      case (ut@((_): Spec2.Transform.Filter5EqualFilter)) => ut.x.asJson
      case (ut@((_): Spec2.Transform.Filter5RangeFilter)) => ut.x.asJson
      case (ut@((_): Spec2.Transform.Filter5InFilter)) => ut.x.asJson
    });
    implicit val Spec2TransformFilter5UnionDecoder: Decoder[Spec2.Transform.Filter5Union] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.Transform.Filter5String(x))).orElse(c.as[EqualFilter].map(((x) => Spec2.Transform.Filter5EqualFilter(x)))).orElse(c.as[RangeFilter].map(((x) => Spec2.Transform.Filter5RangeFilter(x)))).orElse(c.as[InFilter].map(((x) => Spec2.Transform.Filter5InFilter(x))))));
    implicit val Spec2EqualFilterEncoder: Encoder[Spec2.EqualFilter] = Encoder.instance(((cc: Spec2.EqualFilter) => Json.obj("timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "equal".->(cc.equal.asJson))));
    implicit val Spec2EqualFilterDecoder: Decoder[Spec2.EqualFilter] = Decoder.instance(((c: HCursor) => c.downField("timeUnit").as[Option[TimeUnit]]
      .flatMap(((timeUnit) => c.downField("field").as[String]
        .flatMap(((field) => c.downField("equal").as[EqualFilter.EqualUnion].map(((equal) => Spec2.EqualFilter(timeUnit,
          field,
          equal)))))))));
    implicit val Spec2EqualFilterEqualUnionEncoder: Encoder[Spec2.EqualFilter.EqualUnion] = Encoder.instance({
      case (ut@((_): Spec2.EqualFilter.EqualString) ) => ut.x.asJson
      case (ut@((_): Spec2.EqualFilter.EqualDouble)) => ut.x.asJson
      case (ut@((_): Spec2.EqualFilter.EqualBoolean)) => ut.x.asJson
      case (ut@((_): Spec2.EqualFilter.EqualDateTime)) => ut.x.asJson
    });
    implicit val Spec2EqualFilterEqualUnionDecoder: Decoder[Spec2.EqualFilter.EqualUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.EqualFilter.EqualString(x))).orElse(c.as[Double].map(((x) => Spec2.EqualFilter.EqualDouble(x)))).orElse(c.as[Boolean].map(((x) => Spec2.EqualFilter.EqualBoolean(x)))).orElse(c.as[DateTime].map(((x) => Spec2.EqualFilter.EqualDateTime(x))))));
    implicit val Spec2DateTimeEncoder: Encoder[Spec2.DateTime] = Encoder.instance(((cc: Spec2.DateTime) => Json.obj("year".->(cc.year.asJson),
      "quarter".->(cc.quarter.asJson),
      "month".->(cc.month.asJson),
      "date".->(cc.date.asJson),
      "day".->(cc.day.asJson),
      "hours".->(cc.hours.asJson),
      "minutes".->(cc.minutes.asJson),
      "seconds".->(cc.seconds.asJson),
      "milliseconds".->(cc.milliseconds.asJson))));
    implicit val Spec2DateTimeDecoder: Decoder[Spec2.DateTime] = Decoder.instance(((c: HCursor) => c.downField("year").as[Option[Double]]
      .flatMap(((year) => c.downField("quarter").as[Option[Double]]
        .flatMap(((quarter) => c.downField("month").as[Option[DateTime.MonthUnion]]
          .flatMap(((month) => c.downField("date").as[Option[Double]]
            .flatMap(((date) => c.downField("day").as[Option[DateTime.DayUnion]]
              .flatMap(((day) => c.downField("hours").as[Option[Double]]
                .flatMap(((hours) => c.downField("minutes").as[Option[Double]]
                  .flatMap(((minutes) => c.downField("seconds").as[Option[Double]]
                    .flatMap(((seconds) => c.downField("milliseconds").as[Option[Double]].map(((milliseconds) => Spec2.DateTime(year,
                      quarter,
                      month,
                      date,
                      day,
                      hours,
                      minutes,
                      seconds,
                      milliseconds)))))))))))))))))))));
    implicit val Spec2DateTimeMonthUnionEncoder: Encoder[Spec2.DateTime.MonthUnion] = Encoder.instance({
      case (ut@((_): Spec2.DateTime.MonthDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.DateTime.MonthString)) => ut.x.asJson
    });
    implicit val Spec2DateTimeMonthUnionDecoder: Decoder[Spec2.DateTime.MonthUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.DateTime.MonthDouble(x))).orElse(c.as[String].map(((x) => Spec2.DateTime.MonthString(x))))));
    implicit val Spec2DateTimeDayUnionEncoder: Encoder[Spec2.DateTime.DayUnion] = Encoder.instance({
      case (ut@((_): Spec2.DateTime.DayDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.DateTime.DayString)) => ut.x.asJson
    });
    implicit val Spec2DateTimeDayUnionDecoder: Decoder[Spec2.DateTime.DayUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.DateTime.DayDouble(x))).orElse(c.as[String].map(((x) => Spec2.DateTime.DayString(x))))));
    implicit val Spec2RangeFilterEncoder: Encoder[Spec2.RangeFilter] = Encoder.instance(((cc: Spec2.RangeFilter) => Json.obj("timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "range".->(cc.range.asJson))));
    implicit val Spec2RangeFilterDecoder: Decoder[Spec2.RangeFilter] = Decoder.instance(((c: HCursor) => c.downField("timeUnit").as[Option[TimeUnit]]
      .flatMap(((timeUnit) => c.downField("field").as[String]
        .flatMap(((field) => c.downField("range").as[List[RangeFilter.RangeUnion]].map(((range) => Spec2.RangeFilter(timeUnit,
          field,
          range)))))))));
    implicit val Spec2RangeFilterRangeUnionEncoder: Encoder[Spec2.RangeFilter.RangeUnion] = Encoder.instance({
      case (ut@((_): Spec2.RangeFilter.RangeDouble) ) => ut.x.asJson
      case (ut@((_): Spec2.RangeFilter.RangeDateTime)) => ut.x.asJson
    });
    implicit val Spec2RangeFilterRangeUnionDecoder: Decoder[Spec2.RangeFilter.RangeUnion] = Decoder.instance(((c: HCursor) => c.as[Double].map(((x) => Spec2.RangeFilter.RangeDouble(x))).orElse(c.as[DateTime].map(((x) => Spec2.RangeFilter.RangeDateTime(x))))));
    implicit val Spec2InFilterEncoder: Encoder[Spec2.InFilter] = Encoder.instance(((cc: Spec2.InFilter) => Json.obj("timeUnit".->(cc.timeUnit.asJson),
      "field".->(cc.field.asJson),
      "in".->(cc.in.asJson))));
    implicit val Spec2InFilterDecoder: Decoder[Spec2.InFilter] = Decoder.instance(((c: HCursor) => c.downField("timeUnit").as[Option[TimeUnit]]
      .flatMap(((timeUnit) => c.downField("field").as[String]
        .flatMap(((field) => c.downField("in").as[List[InFilter.InUnion]].map(((in) => Spec2.InFilter(timeUnit,
          field,
          in)))))))));
    implicit val Spec2InFilterInUnionEncoder: Encoder[Spec2.InFilter.InUnion] = Encoder.instance({
      case (ut@((_): Spec2.InFilter.InString) ) => ut.x.asJson
      case (ut@((_): Spec2.InFilter.InDouble)) => ut.x.asJson
      case (ut@((_): Spec2.InFilter.InBoolean)) => ut.x.asJson
      case (ut@((_): Spec2.InFilter.InDateTime)) => ut.x.asJson
    });
    implicit val Spec2InFilterInUnionDecoder: Decoder[Spec2.InFilter.InUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.InFilter.InString(x))).orElse(c.as[Double].map(((x) => Spec2.InFilter.InDouble(x)))).orElse(c.as[Boolean].map(((x) => Spec2.InFilter.InBoolean(x)))).orElse(c.as[DateTime].map(((x) => Spec2.InFilter.InDateTime(x))))));
    implicit val Spec2FormulaEncoder: Encoder[Spec2.Formula] = Encoder.instance(((cc: Spec2.Formula) => Json.obj("field".->(cc.field.asJson),
      "expr".->(cc.expr.asJson))));
    implicit val Spec2FormulaDecoder: Decoder[Spec2.Formula] = Decoder.instance(((c: HCursor) => c.downField("field").as[String]
      .flatMap(((field) => c.downField("expr").as[String].map(((expr) => Spec2.Formula(field,
        expr)))))));
    implicit val Spec2ConfigEncoder: Encoder[Spec2.Config] = Encoder.instance(((cc: Spec2.Config) => Json.obj("viewport".->(cc.viewport.asJson),
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
    implicit val Spec2ConfigDecoder: Decoder[Spec2.Config] = Decoder.instance(((c: HCursor) => c.downField("viewport").as[Option[Double]]
      .flatMap(((viewport) => c.downField("background").as[Option[String]]
        .flatMap(((background) => c.downField("numberFormat").as[Option[String]]
          .flatMap(((numberFormat) => c.downField("timeFormat").as[Option[String]]
            .flatMap(((timeFormat) => c.downField("countTitle").as[Option[String]]
              .flatMap(((countTitle) => c.downField("cell").as[Option[CellConfig]]
                .flatMap(((cell) => c.downField("mark").as[Option[MarkConfig]]
                  .flatMap(((mark) => c.downField("overlay").as[Option[OverlayConfig]]
                    .flatMap(((overlay) => c.downField("scale").as[Option[ScaleConfig]]
                      .flatMap(((scale) => c.downField("axis").as[Option[AxisConfig]]
                        .flatMap(((axis) => c.downField("legend").as[Option[LegendConfig]]
                          .flatMap(((legend) => c.downField("facet").as[Option[FacetConfig]].map(((facet) => Spec2.Config(viewport,
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
                            facet)))))))))))))))))))))))))));
    implicit val Spec2CellConfigEncoder: Encoder[Spec2.CellConfig] = Encoder.instance(((cc: Spec2.CellConfig) => Json.obj("width".->(cc.width.asJson),
      "height".->(cc.height.asJson),
      "clip".->(cc.clip.asJson),
      "fill".->(cc.fill.asJson),
      "fillOpacity".->(cc.fillOpacity.asJson),
      "stroke".->(cc.stroke.asJson),
      "strokeOpacity".->(cc.strokeOpacity.asJson),
      "strokeWidth".->(cc.strokeWidth.asJson),
      "strokeDash".->(cc.strokeDash.asJson),
      "strokeDashOffset".->(cc.strokeDashOffset.asJson))));
    implicit val Spec2CellConfigDecoder: Decoder[Spec2.CellConfig] = Decoder.instance(((c: HCursor) => c.downField("width").as[Option[Double]]
      .flatMap(((width) => c.downField("height").as[Option[Double]]
        .flatMap(((height) => c.downField("clip").as[Option[Boolean]]
          .flatMap(((clip) => c.downField("fill").as[Option[String]]
            .flatMap(((fill) => c.downField("fillOpacity").as[Option[Double]]
              .flatMap(((fillOpacity) => c.downField("stroke").as[Option[String]]
                .flatMap(((stroke) => c.downField("strokeOpacity").as[Option[Double]]
                  .flatMap(((strokeOpacity) => c.downField("strokeWidth").as[Option[Double]]
                    .flatMap(((strokeWidth) => c.downField("strokeDash").as[Option[List[Double]]]
                      .flatMap(((strokeDash) => c.downField("strokeDashOffset").as[Option[Double]].map(((strokeDashOffset) => Spec2.CellConfig(width,
                        height,
                        clip,
                        fill,
                        fillOpacity,
                        stroke,
                        strokeOpacity,
                        strokeWidth,
                        strokeDash,
                        strokeDashOffset)))))))))))))))))))))));
    implicit val Spec2MarkConfigEncoder: Encoder[Spec2.MarkConfig] = Encoder.instance(((cc: Spec2.MarkConfig) => Json.obj("filled".->(cc.filled.asJson),
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
      "applyColorToBackground".->(cc.applyColorToBackground.asJson))));
    implicit val Spec2MarkConfigDecoder: Decoder[Spec2.MarkConfig] = Decoder.instance(((c: HCursor) => c.downField("filled").as[Option[Boolean]]
      .flatMap(((filled) => c.downField("color").as[Option[String]]
        .flatMap(((color) => c.downField("fill").as[Option[String]]
          .flatMap(((fill) => c.downField("stroke").as[Option[String]]
            .flatMap(((stroke) => c.downField("opacity").as[Option[Double]]
              .flatMap(((opacity) => c.downField("fillOpacity").as[Option[Double]]
                .flatMap(((fillOpacity) => c.downField("strokeOpacity").as[Option[Double]]
                  .flatMap(((strokeOpacity) => c.downField("strokeWidth").as[Option[Double]]
                    .flatMap(((strokeWidth) => c.downField("strokeDash").as[Option[List[Double]]]
                      .flatMap(((strokeDash) => c.downField("strokeDashOffset").as[Option[Double]]
                        .flatMap(((strokeDashOffset) => c.downField("stacked").as[Option[StackOffset]]
                          .flatMap(((stacked) => c.downField("orient").as[Option[Orient]]
                            .flatMap(((orient) => c.downField("interpolate").as[Option[Interpolate]]
                              .flatMap(((interpolate) => c.downField("tension").as[Option[Double]]
                                .flatMap(((tension) => c.downField("lineSize").as[Option[Double]]
                                  .flatMap(((lineSize) => c.downField("ruleSize").as[Option[Double]]
                                    .flatMap(((ruleSize) => c.downField("barSize").as[Option[Double]]
                                      .flatMap(((barSize) => c.downField("barThinSize").as[Option[Double]]
                                        .flatMap(((barThinSize) => c.downField("shape").as[Option[Shape]]
                                          .flatMap(((shape) => c.downField("size").as[Option[Double]]
                                            .flatMap(((size) => c.downField("tickSize").as[Option[Double]]
                                              .flatMap(((tickSize) => c.downField("tickThickness").as[Option[Double]]
                                                .flatMap(((tickThickness) => c.downField("align").as[Option[HorizontalAlign]]
                                                  .flatMap(((align) => c.downField("angle").as[Option[Double]]
                                                    .flatMap(((angle) => c.downField("baseline").as[Option[VerticalAlign]]
                                                      .flatMap(((baseline) => c.downField("dx").as[Option[Double]]
                                                        .flatMap(((dx) => c.downField("dy").as[Option[Double]]
                                                          .flatMap(((dy) => c.downField("radius").as[Option[Double]]
                                                            .flatMap(((radius) => c.downField("theta").as[Option[Double]]
                                                              .flatMap(((theta) => c.downField("font").as[Option[String]]
                                                                .flatMap(((font) => c.downField("fontSize").as[Option[Double]]
                                                                  .flatMap(((fontSize) => c.downField("fontStyle").as[Option[FontStyle]]
                                                                    .flatMap(((fontStyle) => c.downField("fontWeight").as[Option[FontWeight]]
                                                                      .flatMap(((fontWeight) => c.downField("format").as[Option[String]]
                                                                        .flatMap(((format) => c.downField("shortTimeLabels").as[Option[Boolean]]
                                                                          .flatMap(((shortTimeLabels) => c.downField("text").as[Option[String]]
                                                                            .flatMap(((text) => c.downField("applyColorToBackground").as[Option[Boolean]].map(((applyColorToBackground) => Spec2.MarkConfig(filled,
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
                                                                              applyColorToBackground)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    implicit val Spec2StackOffsetEncoder: Encoder[Spec2.StackOffset] = Encoder.instance(((e: Spec2.StackOffset) => parser.parse(e.json).toOption.get));
    implicit val Spec2StackOffsetDecoder: Decoder[Spec2.StackOffset] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"zero\"").toOption.get) => cats.data.Xor.right(Spec2.StackOffsetEnums.Zero)
        case (j@_) if j.==(parser.parse("\"center\"").toOption.get) => cats.data.Xor.right(Spec2.StackOffsetEnums.Center)
        case (j@_) if j.==(parser.parse("\"normalize\"").toOption.get) => cats.data.Xor.right(Spec2.StackOffsetEnums.Normalize)
        case (j@_) if j.==(parser.parse("\"none\"").toOption.get) => cats.data.Xor.right(Spec2.StackOffsetEnums.None)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2OrientEncoder: Encoder[Spec2.Orient] = Encoder.instance(((e: Spec2.Orient) => parser.parse(e.json).toOption.get));
    implicit val Spec2OrientDecoder: Decoder[Spec2.Orient] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"horizontal\"").toOption.get) => cats.data.Xor.right(Spec2.OrientEnums.Horizontal)
        case (j@_) if j.==(parser.parse("\"vertical\"").toOption.get) => cats.data.Xor.right(Spec2.OrientEnums.Vertical)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2InterpolateEncoder: Encoder[Spec2.Interpolate] = Encoder.instance(((e: Spec2.Interpolate) => parser.parse(e.json).toOption.get));
    implicit val Spec2InterpolateDecoder: Decoder[Spec2.Interpolate] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"linear\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Linear)
        case (j@_) if j.==(parser.parse("\"linear-closed\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.LinearClosed)
        case (j@_) if j.==(parser.parse("\"step\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Step)
        case (j@_) if j.==(parser.parse("\"step-before\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.StepBefore)
        case (j@_) if j.==(parser.parse("\"step-after\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.StepAfter)
        case (j@_) if j.==(parser.parse("\"basis\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Basis)
        case (j@_) if j.==(parser.parse("\"basis-open\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.BasisOpen)
        case (j@_) if j.==(parser.parse("\"basis-closed\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.BasisClosed)
        case (j@_) if j.==(parser.parse("\"cardinal\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Cardinal)
        case (j@_) if j.==(parser.parse("\"cardinal-open\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.CardinalOpen)
        case (j@_) if j.==(parser.parse("\"cardinal-closed\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.CardinalClosed)
        case (j@_) if j.==(parser.parse("\"bundle\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Bundle)
        case (j@_) if j.==(parser.parse("\"monotone\"").toOption.get) => cats.data.Xor.right(Spec2.InterpolateEnums.Monotone)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2ShapeEncoder: Encoder[Spec2.Shape] = Encoder.instance(((e: Spec2.Shape) => parser.parse(e.json).toOption.get));
    implicit val Spec2ShapeDecoder: Decoder[Spec2.Shape] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"circle\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.Circle)
        case (j@_) if j.==(parser.parse("\"square\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.Square)
        case (j@_) if j.==(parser.parse("\"cross\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.Cross)
        case (j@_) if j.==(parser.parse("\"diamond\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.Diamond)
        case (j@_) if j.==(parser.parse("\"triangle-up\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.TriangleUp)
        case (j@_) if j.==(parser.parse("\"triangle-down\"").toOption.get) => cats.data.Xor.right(Spec2.ShapeEnums.TriangleDown)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2HorizontalAlignEncoder: Encoder[Spec2.HorizontalAlign] = Encoder.instance(((e: Spec2.HorizontalAlign) => parser.parse(e.json).toOption.get));
    implicit val Spec2HorizontalAlignDecoder: Decoder[Spec2.HorizontalAlign] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"left\"").toOption.get) => cats.data.Xor.right(Spec2.HorizontalAlignEnums.Left)
        case (j@_) if j.==(parser.parse("\"right\"").toOption.get) => cats.data.Xor.right(Spec2.HorizontalAlignEnums.Right)
        case (j@_) if j.==(parser.parse("\"center\"").toOption.get) => cats.data.Xor.right(Spec2.HorizontalAlignEnums.Center)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2VerticalAlignEncoder: Encoder[Spec2.VerticalAlign] = Encoder.instance(((e: Spec2.VerticalAlign) => parser.parse(e.json).toOption.get));
    implicit val Spec2VerticalAlignDecoder: Decoder[Spec2.VerticalAlign] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"top\"").toOption.get) => cats.data.Xor.right(Spec2.VerticalAlignEnums.Top)
        case (j@_) if j.==(parser.parse("\"middle\"").toOption.get) => cats.data.Xor.right(Spec2.VerticalAlignEnums.Middle)
        case (j@_) if j.==(parser.parse("\"bottom\"").toOption.get) => cats.data.Xor.right(Spec2.VerticalAlignEnums.Bottom)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2FontStyleEncoder: Encoder[Spec2.FontStyle] = Encoder.instance(((e: Spec2.FontStyle) => parser.parse(e.json).toOption.get));
    implicit val Spec2FontStyleDecoder: Decoder[Spec2.FontStyle] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"normal\"").toOption.get) => cats.data.Xor.right(Spec2.FontStyleEnums.Normal)
        case (j@_) if j.==(parser.parse("\"italic\"").toOption.get) => cats.data.Xor.right(Spec2.FontStyleEnums.Italic)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2FontWeightEncoder: Encoder[Spec2.FontWeight] = Encoder.instance(((e: Spec2.FontWeight) => parser.parse(e.json).toOption.get));
    implicit val Spec2FontWeightDecoder: Decoder[Spec2.FontWeight] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"normal\"").toOption.get) => cats.data.Xor.right(Spec2.FontWeightEnums.Normal)
        case (j@_) if j.==(parser.parse("\"bold\"").toOption.get) => cats.data.Xor.right(Spec2.FontWeightEnums.Bold)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2OverlayConfigEncoder: Encoder[Spec2.OverlayConfig] = Encoder.instance(((cc: Spec2.OverlayConfig) => Json.obj("line".->(cc.line.asJson),
      "area".->(cc.area.asJson),
      "pointStyle".->(cc.pointStyle.asJson),
      "lineStyle".->(cc.lineStyle.asJson))));
    implicit val Spec2OverlayConfigDecoder: Decoder[Spec2.OverlayConfig] = Decoder.instance(((c: HCursor) => c.downField("line").as[Option[Boolean]]
      .flatMap(((line) => c.downField("area").as[Option[AreaOverlay]]
        .flatMap(((area) => c.downField("pointStyle").as[Option[MarkConfig]]
          .flatMap(((pointStyle) => c.downField("lineStyle").as[Option[MarkConfig]].map(((lineStyle) => Spec2.OverlayConfig(line,
            area,
            pointStyle,
            lineStyle)))))))))));
    implicit val Spec2AreaOverlayEncoder: Encoder[Spec2.AreaOverlay] = Encoder.instance(((e: Spec2.AreaOverlay) => parser.parse(e.json).toOption.get));
    implicit val Spec2AreaOverlayDecoder: Decoder[Spec2.AreaOverlay] = Decoder.instance(((c: HCursor) => c.as[Json]
      .flatMap(((json) => (json match {
        case (j@_) if j.==(parser.parse("\"line\"").toOption.get) => cats.data.Xor.right(Spec2.AreaOverlayEnums.Line)
        case (j@_) if j.==(parser.parse("\"linepoint\"").toOption.get) => cats.data.Xor.right(Spec2.AreaOverlayEnums.Linepoint)
        case (j@_) if j.==(parser.parse("\"none\"").toOption.get) => cats.data.Xor.right(Spec2.AreaOverlayEnums.None)
        case _ => throw new Exception("Couldn\'t find enum:".+(json.toString))
      }).map(((singleton) => singleton))))));
    implicit val Spec2ScaleConfigEncoder: Encoder[Spec2.ScaleConfig] = Encoder.instance(((cc: Spec2.ScaleConfig) => Json.obj("round".->(cc.round.asJson),
      "textBandWidth".->(cc.textBandWidth.asJson),
      "bandSize".->(cc.bandSize.asJson),
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
    implicit val Spec2ScaleConfigDecoder: Decoder[Spec2.ScaleConfig] = Decoder.instance(((c: HCursor) => c.downField("round").as[Option[Boolean]]
      .flatMap(((round) => c.downField("textBandWidth").as[Option[Double]]
        .flatMap(((textBandWidth) => c.downField("bandSize").as[Option[Double]]
          .flatMap(((bandSize) => c.downField("opacity").as[Option[List[Double]]]
            .flatMap(((opacity) => c.downField("padding").as[Option[Double]]
              .flatMap(((padding) => c.downField("useRawDomain").as[Option[Boolean]]
                .flatMap(((useRawDomain) => c.downField("nominalColorRange").as[Option[ScaleConfig.NominalColorRangeUnion]]
                  .flatMap(((nominalColorRange) => c.downField("sequentialColorRange").as[Option[ScaleConfig.SequentialColorRangeUnion]]
                    .flatMap(((sequentialColorRange) => c.downField("shapeRange").as[Option[ScaleConfig.ShapeRangeUnion]]
                      .flatMap(((shapeRange) => c.downField("barSizeRange").as[Option[List[Double]]]
                        .flatMap(((barSizeRange) => c.downField("fontSizeRange").as[Option[List[Double]]]
                          .flatMap(((fontSizeRange) => c.downField("ruleSizeRange").as[Option[List[Double]]]
                            .flatMap(((ruleSizeRange) => c.downField("tickSizeRange").as[Option[List[Double]]]
                              .flatMap(((tickSizeRange) => c.downField("pointSizeRange").as[Option[List[Double]]].map(((pointSizeRange) => Spec2.ScaleConfig(round,
                                textBandWidth,
                                bandSize,
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
                                pointSizeRange)))))))))))))))))))))))))))))));
    implicit val Spec2ScaleConfigNominalColorRangeUnionEncoder: Encoder[Spec2.ScaleConfig.NominalColorRangeUnion] = Encoder.instance({
      case (ut@((_): Spec2.ScaleConfig.NominalColorRangeString) ) => ut.x.asJson
      case (ut@((_): Spec2.ScaleConfig.NominalColorRangeListString)) => ut.x.asJson
    });
    implicit val Spec2ScaleConfigNominalColorRangeUnionDecoder: Decoder[Spec2.ScaleConfig.NominalColorRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.ScaleConfig.NominalColorRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec2.ScaleConfig.NominalColorRangeListString(x))))));
    implicit val Spec2ScaleConfigSequentialColorRangeUnionEncoder: Encoder[Spec2.ScaleConfig.SequentialColorRangeUnion] = Encoder.instance({
      case (ut@((_): Spec2.ScaleConfig.SequentialColorRangeString) ) => ut.x.asJson
      case (ut@((_): Spec2.ScaleConfig.SequentialColorRangeListString)) => ut.x.asJson
    });
    implicit val Spec2ScaleConfigSequentialColorRangeUnionDecoder: Decoder[Spec2.ScaleConfig.SequentialColorRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.ScaleConfig.SequentialColorRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec2.ScaleConfig.SequentialColorRangeListString(x))))));
    implicit val Spec2ScaleConfigShapeRangeUnionEncoder: Encoder[Spec2.ScaleConfig.ShapeRangeUnion] = Encoder.instance({
      case (ut@((_): Spec2.ScaleConfig.ShapeRangeString) ) => ut.x.asJson
      case (ut@((_): Spec2.ScaleConfig.ShapeRangeListString)) => ut.x.asJson
    });
    implicit val Spec2ScaleConfigShapeRangeUnionDecoder: Decoder[Spec2.ScaleConfig.ShapeRangeUnion] = Decoder.instance(((c: HCursor) => c.as[String].map(((x) => Spec2.ScaleConfig.ShapeRangeString(x))).orElse(c.as[List[String]].map(((x) => Spec2.ScaleConfig.ShapeRangeListString(x))))));
    implicit val Spec2AxisConfigEncoder: Encoder[Spec2.AxisConfig] = Encoder.instance(((cc: Spec2.AxisConfig) => Json.obj("axisWidth".->(cc.axisWidth.asJson),
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
    implicit val Spec2AxisConfigDecoder: Decoder[Spec2.AxisConfig] = Decoder.instance(((c: HCursor) => c.downField("axisWidth").as[Option[Double]]
      .flatMap(((axisWidth) => c.downField("layer").as[Option[String]]
        .flatMap(((layer) => c.downField("offset").as[Option[Double]]
          .flatMap(((offset) => c.downField("axisColor").as[Option[String]]
            .flatMap(((axisColor) => c.downField("grid").as[Option[Boolean]]
              .flatMap(((grid) => c.downField("gridColor").as[Option[String]]
                .flatMap(((gridColor) => c.downField("gridDash").as[Option[List[Double]]]
                  .flatMap(((gridDash) => c.downField("gridOpacity").as[Option[Double]]
                    .flatMap(((gridOpacity) => c.downField("gridWidth").as[Option[Double]]
                      .flatMap(((gridWidth) => c.downField("labels").as[Option[Boolean]]
                        .flatMap(((labels) => c.downField("labelAngle").as[Option[Double]]
                          .flatMap(((labelAngle) => c.downField("labelAlign").as[Option[String]]
                            .flatMap(((labelAlign) => c.downField("labelBaseline").as[Option[String]]
                              .flatMap(((labelBaseline) => c.downField("labelMaxLength").as[Option[Double]]
                                .flatMap(((labelMaxLength) => c.downField("shortTimeLabels").as[Option[Boolean]]
                                  .flatMap(((shortTimeLabels) => c.downField("subdivide").as[Option[Double]]
                                    .flatMap(((subdivide) => c.downField("ticks").as[Option[Double]]
                                      .flatMap(((ticks) => c.downField("tickColor").as[Option[String]]
                                        .flatMap(((tickColor) => c.downField("tickLabelColor").as[Option[String]]
                                          .flatMap(((tickLabelColor) => c.downField("tickLabelFont").as[Option[String]]
                                            .flatMap(((tickLabelFont) => c.downField("tickLabelFontSize").as[Option[Double]]
                                              .flatMap(((tickLabelFontSize) => c.downField("tickPadding").as[Option[Double]]
                                                .flatMap(((tickPadding) => c.downField("tickSize").as[Option[Double]]
                                                  .flatMap(((tickSize) => c.downField("tickSizeMajor").as[Option[Double]]
                                                    .flatMap(((tickSizeMajor) => c.downField("tickSizeMinor").as[Option[Double]]
                                                      .flatMap(((tickSizeMinor) => c.downField("tickSizeEnd").as[Option[Double]]
                                                        .flatMap(((tickSizeEnd) => c.downField("tickWidth").as[Option[Double]]
                                                          .flatMap(((tickWidth) => c.downField("titleColor").as[Option[String]]
                                                            .flatMap(((titleColor) => c.downField("titleFont").as[Option[String]]
                                                              .flatMap(((titleFont) => c.downField("titleFontSize").as[Option[Double]]
                                                                .flatMap(((titleFontSize) => c.downField("titleFontWeight").as[Option[String]]
                                                                  .flatMap(((titleFontWeight) => c.downField("titleOffset").as[Option[Double]]
                                                                    .flatMap(((titleOffset) => c.downField("titleMaxLength").as[Option[Double]]
                                                                      .flatMap(((titleMaxLength) => c.downField("characterWidth").as[Option[Double]]
                                                                        .flatMap(((characterWidth) => c.downField("properties").as[Option[AxisConfig.Properties]].map(((properties) => Spec2.AxisConfig(axisWidth,
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
                                                                          properties)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    implicit val Spec2AxisConfigPropertiesEncoder: Encoder[Spec2.AxisConfig.Properties] = Encoder.instance(((wrapper: Spec2.AxisConfig.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2AxisConfigPropertiesDecoder: Decoder[Spec2.AxisConfig.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$5) => Spec2.AxisConfig.Properties(x$5)))));
    implicit val Spec2LegendConfigEncoder: Encoder[Spec2.LegendConfig] = Encoder.instance(((cc: Spec2.LegendConfig) => Json.obj("orient".->(cc.orient.asJson),
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
    implicit val Spec2LegendConfigDecoder: Decoder[Spec2.LegendConfig] = Decoder.instance(((c: HCursor) => c.downField("orient").as[Option[String]]
      .flatMap(((orient) => c.downField("offset").as[Option[Double]]
        .flatMap(((offset) => c.downField("padding").as[Option[Double]]
          .flatMap(((padding) => c.downField("margin").as[Option[Double]]
            .flatMap(((margin) => c.downField("gradientStrokeColor").as[Option[String]]
              .flatMap(((gradientStrokeColor) => c.downField("gradientStrokeWidth").as[Option[Double]]
                .flatMap(((gradientStrokeWidth) => c.downField("gradientHeight").as[Option[Double]]
                  .flatMap(((gradientHeight) => c.downField("gradientWidth").as[Option[Double]]
                    .flatMap(((gradientWidth) => c.downField("labelAlign").as[Option[String]]
                      .flatMap(((labelAlign) => c.downField("labelBaseline").as[Option[String]]
                        .flatMap(((labelBaseline) => c.downField("labelColor").as[Option[String]]
                          .flatMap(((labelColor) => c.downField("labelFont").as[Option[String]]
                            .flatMap(((labelFont) => c.downField("labelFontSize").as[Option[Double]]
                              .flatMap(((labelFontSize) => c.downField("labelOffset").as[Option[Double]]
                                .flatMap(((labelOffset) => c.downField("shortTimeLabels").as[Option[Boolean]]
                                  .flatMap(((shortTimeLabels) => c.downField("symbolColor").as[Option[String]]
                                    .flatMap(((symbolColor) => c.downField("symbolShape").as[Option[String]]
                                      .flatMap(((symbolShape) => c.downField("symbolSize").as[Option[Double]]
                                        .flatMap(((symbolSize) => c.downField("symbolStrokeWidth").as[Option[Double]]
                                          .flatMap(((symbolStrokeWidth) => c.downField("titleColor").as[Option[String]]
                                            .flatMap(((titleColor) => c.downField("titleFont").as[Option[String]]
                                              .flatMap(((titleFont) => c.downField("titleFontSize").as[Option[Double]]
                                                .flatMap(((titleFontSize) => c.downField("titleFontWeight").as[Option[String]]
                                                  .flatMap(((titleFontWeight) => c.downField("properties").as[Option[LegendConfig.Properties]].map(((properties) => Spec2.LegendConfig(orient,
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
                                                    properties)))))))))))))))))))))))))))))))))))))))))))))))))));
    implicit val Spec2LegendConfigPropertiesEncoder: Encoder[Spec2.LegendConfig.Properties] = Encoder.instance(((wrapper: Spec2.LegendConfig.Properties) => wrapper.x.asJson(anyEncoder)));
    implicit val Spec2LegendConfigPropertiesDecoder: Decoder[Spec2.LegendConfig.Properties] = Decoder.instance(((h: HCursor) => h.as[Any](anyDecoder).map(((x$6) => Spec2.LegendConfig.Properties(x$6)))));
    implicit val Spec2FacetConfigEncoder: Encoder[Spec2.FacetConfig] = Encoder.instance(((cc: Spec2.FacetConfig) => Json.obj("scale".->(cc.scale.asJson),
      "axis".->(cc.axis.asJson),
      "grid".->(cc.grid.asJson),
      "cell".->(cc.cell.asJson))));
    implicit val Spec2FacetConfigDecoder: Decoder[Spec2.FacetConfig] = Decoder.instance(((c: HCursor) => c.downField("scale").as[Option[FacetScaleConfig]]
      .flatMap(((scale) => c.downField("axis").as[Option[AxisConfig]]
        .flatMap(((axis) => c.downField("grid").as[Option[FacetGridConfig]]
          .flatMap(((grid) => c.downField("cell").as[Option[CellConfig]].map(((cell) => Spec2.FacetConfig(scale,
            axis,
            grid,
            cell)))))))))));
    implicit val Spec2FacetScaleConfigEncoder: Encoder[Spec2.FacetScaleConfig] = Encoder.instance(((cc: Spec2.FacetScaleConfig) => Json.obj("round".->(cc.round.asJson),
      "padding".->(cc.padding.asJson))));
    implicit val Spec2FacetScaleConfigDecoder: Decoder[Spec2.FacetScaleConfig] = Decoder.instance(((c: HCursor) => c.downField("round").as[Option[Boolean]]
      .flatMap(((round) => c.downField("padding").as[Option[Double]].map(((padding) => Spec2.FacetScaleConfig(round,
        padding)))))));
    implicit val Spec2FacetGridConfigEncoder: Encoder[Spec2.FacetGridConfig] = Encoder.instance(((cc: Spec2.FacetGridConfig) => Json.obj("color".->(cc.color.asJson),
      "opacity".->(cc.opacity.asJson),
      "offset".->(cc.offset.asJson))));
    implicit val Spec2FacetGridConfigDecoder: Decoder[Spec2.FacetGridConfig] = Decoder.instance(((c: HCursor) => c.downField("color").as[Option[String]]
      .flatMap(((color) => c.downField("opacity").as[Option[Double]]
        .flatMap(((opacity) => c.downField("offset").as[Option[Double]].map(((offset) => Spec2.FacetGridConfig(color,
          opacity,
          offset)))))))));
    implicit val Spec2FacetSpecEncoder: Encoder[Spec2.FacetSpec] = Encoder.instance(((cc: Spec2.FacetSpec) => Json.obj("facet".->(cc.facet.asJson),
      "spec".->(cc.spec.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val Spec2FacetSpecDecoder: Decoder[Spec2.FacetSpec] = Decoder.instance(((c: HCursor) => c.downField("facet").as[Facet]
      .flatMap(((facet) => c.downField("spec").as[FacetSpec.SpecUnion]
        .flatMap(((spec) => c.downField("name").as[Option[String]]
          .flatMap(((name) => c.downField("description").as[Option[String]]
            .flatMap(((description) => c.downField("data").as[Option[Data]]
              .flatMap(((data) => c.downField("transform").as[Option[Transform]]
                .flatMap(((transform) => c.downField("config").as[Option[Config]].map(((config) => Spec2.FacetSpec(facet,
                  spec,
                  name,
                  description,
                  data,
                  transform,
                  config)))))))))))))))));
    implicit val Spec2FacetSpecSpecUnionEncoder: Encoder[Spec2.FacetSpec.SpecUnion] = Encoder.instance({
      case (ut@((_): Spec2.FacetSpec.SpecLayerSpec) ) => ut.x.asJson
      case (ut@((_): Spec2.FacetSpec.SpecUnitSpec)) => ut.x.asJson
    });
    implicit val Spec2FacetSpecSpecUnionDecoder: Decoder[Spec2.FacetSpec.SpecUnion] = Decoder.instance(((c: HCursor) => c.as[LayerSpec].map(((x) => Spec2.FacetSpec.SpecLayerSpec(x))).orElse(c.as[UnitSpec].map(((x) => Spec2.FacetSpec.SpecUnitSpec(x))))));
    implicit val Spec2FacetEncoder: Encoder[Spec2.Facet] = Encoder.instance(((cc: Spec2.Facet) => Json.obj("row".->(cc.row.asJson),
      "column".->(cc.column.asJson))));
    implicit val Spec2FacetDecoder: Decoder[Spec2.Facet] = Decoder.instance(((c: HCursor) => c.downField("row").as[Option[PositionChannelDef]]
      .flatMap(((row) => c.downField("column").as[Option[PositionChannelDef]].map(((column) => Spec2.Facet(row,
        column)))))));
    implicit val Spec2LayerSpecEncoder: Encoder[Spec2.LayerSpec] = Encoder.instance(((cc: Spec2.LayerSpec) => Json.obj("layers".->(cc.layers.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val Spec2LayerSpecDecoder: Decoder[Spec2.LayerSpec] = Decoder.instance(((c: HCursor) => c.downField("layers").as[List[UnitSpec]]
      .flatMap(((layers) => c.downField("name").as[Option[String]]
        .flatMap(((name) => c.downField("description").as[Option[String]]
          .flatMap(((description) => c.downField("data").as[Option[Data]]
            .flatMap(((data) => c.downField("transform").as[Option[Transform]]
              .flatMap(((transform) => c.downField("config").as[Option[Config]].map(((config) => Spec2.LayerSpec(layers,
                name,
                description,
                data,
                transform,
                config)))))))))))))));
    implicit val Spec2UnitSpecEncoder: Encoder[Spec2.UnitSpec] = Encoder.instance(((cc: Spec2.UnitSpec) => Json.obj("mark".->(cc.mark.asJson),
      "encoding".->(cc.encoding.asJson),
      "name".->(cc.name.asJson),
      "description".->(cc.description.asJson),
      "data".->(cc.data.asJson),
      "transform".->(cc.transform.asJson),
      "config".->(cc.config.asJson))));
    implicit val Spec2UnitSpecDecoder: Decoder[Spec2.UnitSpec] = Decoder.instance(((c: HCursor) => c.downField("mark").as[Mark]
      .flatMap(((mark) => c.downField("encoding").as[Option[UnitEncoding]]
        .flatMap(((encoding) => c.downField("name").as[Option[String]]
          .flatMap(((name) => c.downField("description").as[Option[String]]
            .flatMap(((description) => c.downField("data").as[Option[Data]]
              .flatMap(((data) => c.downField("transform").as[Option[Transform]]
                .flatMap(((transform) => c.downField("config").as[Option[Config]].map(((config) => Spec2.UnitSpec(mark,
                  encoding,
                  name,
                  description,
                  data,
                  transform,
                  config)))))))))))))))));
    implicit val Spec2UnitEncodingEncoder: Encoder[Spec2.UnitEncoding] = Encoder.instance(((cc: Spec2.UnitEncoding) => Json.obj("x".->(cc.x.asJson),
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
    implicit val Spec2UnitEncodingDecoder: Decoder[Spec2.UnitEncoding] = Decoder.instance(((c: HCursor) => c.downField("x").as[Option[PositionChannelDef]]
      .flatMap(((x) => c.downField("y").as[Option[PositionChannelDef]]
        .flatMap(((y) => c.downField("x2").as[Option[PositionChannelDef]]
          .flatMap(((x2) => c.downField("y2").as[Option[PositionChannelDef]]
            .flatMap(((y2) => c.downField("color").as[Option[ChannelDefWithLegend]]
              .flatMap(((color) => c.downField("opacity").as[Option[ChannelDefWithLegend]]
                .flatMap(((opacity) => c.downField("size").as[Option[ChannelDefWithLegend]]
                  .flatMap(((size) => c.downField("shape").as[Option[ChannelDefWithLegend]]
                    .flatMap(((shape) => c.downField("detail").as[Option[UnitEncoding.DetailUnion]]
                      .flatMap(((detail) => c.downField("text").as[Option[FieldDef]]
                        .flatMap(((text) => c.downField("label").as[Option[FieldDef]]
                          .flatMap(((label) => c.downField("path").as[Option[UnitEncoding.PathUnion]]
                            .flatMap(((path) => c.downField("order").as[Option[UnitEncoding.OrderUnion]].map(((order) => Spec2.UnitEncoding(x,
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
                              order)))))))))))))))))))))))))))));
    implicit val Spec2UnitEncodingDetailUnionEncoder: Encoder[Spec2.UnitEncoding.DetailUnion] = Encoder.instance({
      case (ut@((_): Spec2.UnitEncoding.DetailFieldDef) ) => ut.x.asJson
      case (ut@((_): Spec2.UnitEncoding.DetailListFieldDef)) => ut.x.asJson
    });
    implicit val Spec2UnitEncodingDetailUnionDecoder: Decoder[Spec2.UnitEncoding.DetailUnion] = Decoder.instance(((c: HCursor) => c.as[FieldDef].map(((x) => Spec2.UnitEncoding.DetailFieldDef(x))).orElse(c.as[List[FieldDef]].map(((x) => Spec2.UnitEncoding.DetailListFieldDef(x))))));
    implicit val Spec2UnitEncodingPathUnionEncoder: Encoder[Spec2.UnitEncoding.PathUnion] = Encoder.instance({
      case (ut@((_): Spec2.UnitEncoding.PathOrderChannelDef) ) => ut.x.asJson
      case (ut@((_): Spec2.UnitEncoding.PathListOrderChannelDef)) => ut.x.asJson
    });
    implicit val Spec2UnitEncodingPathUnionDecoder: Decoder[Spec2.UnitEncoding.PathUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec2.UnitEncoding.PathOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec2.UnitEncoding.PathListOrderChannelDef(x))))));
    implicit val Spec2UnitEncodingOrderUnionEncoder: Encoder[Spec2.UnitEncoding.OrderUnion] = Encoder.instance({
      case (ut@((_): Spec2.UnitEncoding.OrderOrderChannelDef) ) => ut.x.asJson
      case (ut@((_): Spec2.UnitEncoding.OrderListOrderChannelDef)) => ut.x.asJson
    });
    implicit val Spec2UnitEncodingOrderUnionDecoder: Decoder[Spec2.UnitEncoding.OrderUnion] = Decoder.instance(((c: HCursor) => c.as[OrderChannelDef].map(((x) => Spec2.UnitEncoding.OrderOrderChannelDef(x))).orElse(c.as[List[OrderChannelDef]].map(((x) => Spec2.UnitEncoding.OrderListOrderChannelDef(x))))));
    implicit val Spec2VegaUnionEncoder: Encoder[Spec2.VegaUnion] = Encoder.instance({
      case (ut@((_): Spec2.VegaExtendedUnitSpec) ) => ut.x.asJson
      case (ut@((_): Spec2.VegaFacetSpec)) => ut.x.asJson
      case (ut@((_): Spec2.VegaLayerSpec)) => ut.x.asJson
    });
    implicit val Spec2VegaUnionDecoder: Decoder[Spec2.VegaUnion] = Decoder.instance(((c: HCursor) => c.as[ExtendedUnitSpec].map(((x) => Spec2.VegaExtendedUnitSpec(x))).orElse(c.as[FacetSpec].map(((x) => Spec2.VegaFacetSpec(x)))).orElse(c.as[LayerSpec].map(((x) => Spec2.VegaLayerSpec(x))))))

    def anyEncoder: Encoder[Any] = Encoder.instance(((a: Any) => a match {
      case null => Json.Null
      case (b@((_): Boolean) ) => b.asJson
      case (b@((_): Byte) ) => b.asJson
      case (s@((_): Short) ) => s.asJson
      case (i@((_): Int) ) => i.asJson
      case (l@((_): Long) ) => l.asJson
      case (f@((_): Float) ) => f.asJson
      case (d@((_): Double) ) => d.asJson
      case (s@((_): String) ) => s.asJson
      case (a@((_): Array[Boolean]@unchecked) ) => a.asJson
      case (a@((_): Array[Byte]@unchecked) ) => a.asJson
      case (a@((_): Array[Short]@unchecked) ) => a.asJson
      case (a@((_): Array[Int]@unchecked) ) => a.asJson
      case (a@((_): Array[Long]@unchecked) ) => a.asJson
      case (a@((_): Array[Float]@unchecked) ) => a.asJson
      case (a@((_): Array[Double]@unchecked) ) => a.asJson
      case (s@((_): Array[Any]@unchecked) ) => s.asJson (Encoder.encodeTraversableOnce (anyEncoder,
    implicitly) )
      case (s@((_): Seq[Any]@unchecked) ) => s.asJson (Encoder.encodeTraversableOnce (anyEncoder,
    implicitly) )
      case (ma@((_): Map[String,
    Any]@unchecked) ) => ma.asJson (Encoder.encodeMapLike (KeyEncoder.encodeKeyString,
    anyEncoder) )
    }));

    def anyDecoder: Decoder[Any] = Decoder.instance(((h: HCursor) => h.focus match {
      case (n@_) if n.isNull => null
      case (n@_) if n.isNumber => n.as[Double]
      case (b@_) if b.isBoolean => b.as[Boolean]
      case (s@_) if s.isString => s.as[String]
      case (o@_) if o.isObject => o.as[Map[String,
        Any]](Decoder.decodeMapLike(KeyDecoder.decodeKeyString,
        anyDecoder,
        Map.canBuildFrom))
      case (a@_) if a.isArray => a.as[List[Any]](Decoder.decodeCanBuildFrom(anyDecoder,
        List.canBuildFrom[Any]))
    }));
  };

  class enum extends scala.annotation.StaticAnnotation;

  class union extends scala.annotation.StaticAnnotation;

  case class ExtendedUnitSpec(mark: Mark,
                              encoding: Option[Encoding] = None,
                              name: Option[String] = None,
                              description: Option[String] = None,
                              data: Option[Data] = None,
                              transform: Option[Transform] = None,
                              config: Option[Config] = None);

  case class Encoding(row: Option[PositionChannelDef] = None,
                      column: Option[PositionChannelDef] = None,
                      x: Option[PositionChannelDef] = None,
                      y: Option[PositionChannelDef] = None,
                      x2: Option[PositionChannelDef] = None,
                      y2: Option[PositionChannelDef] = None,
                      color: Option[ChannelDefWithLegend] = None,
                      opacity: Option[ChannelDefWithLegend] = None,
                      size: Option[ChannelDefWithLegend] = None,
                      shape: Option[ChannelDefWithLegend] = None,
                      detail: Option[Encoding.DetailUnion] = None,
                      text: Option[FieldDef] = None,
                      label: Option[FieldDef] = None,
                      path: Option[Encoding.PathUnion] = None,
                      order: Option[Encoding.OrderUnion] = None);

  case class PositionChannelDef(axis: Option[PositionChannelDef.AxisUnion] = None,
                                scale: Option[Scale] = None,
                                sort: Option[PositionChannelDef.SortUnion] = None,
                                field: Option[String] = None,
                                `type`: Option[Type] = None,
                                value: Option[PositionChannelDef.ValueUnion] = None,
                                timeUnit: Option[TimeUnit] = None,
                                bin: Option[PositionChannelDef.BinUnion] = None,
                                aggregate: Option[AggregateOp] = None,
                                title: Option[String] = None);

  case class Axis(labelAngle: Option[Double] = None,
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

  case class Scale(`type`: Option[ScaleType] = None,
                   domain: Option[Scale.DomainUnion] = None,
                   range: Option[Scale.RangeUnion] = None,
                   round: Option[Boolean] = None,
                   bandSize: Option[Double] = None,
                   padding: Option[Double] = None,
                   clamp: Option[Boolean] = None,
                   nice: Option[Scale.NiceUnion] = None,
                   exponent: Option[Double] = None,
                   zero: Option[Boolean] = None,
                   useRawDomain: Option[Boolean] = None);

  case class SortField(field: String,
                       op: AggregateOp,
                       order: Option[SortOrder] = None);

  case class Bin(min: Option[Double] = None,
                 max: Option[Double] = None,
                 base: Option[Double] = None,
                 step: Option[Double] = None,
                 steps: Option[List[Double]] = None,
                 minstep: Option[Double] = None,
                 div: Option[List[Double]] = None,
                 maxbins: Option[Double] = None);

  case class ChannelDefWithLegend(legend: Option[Legend] = None,
                                  scale: Option[Scale] = None,
                                  sort: Option[ChannelDefWithLegend.SortUnion] = None,
                                  field: Option[String] = None,
                                  `type`: Option[Type] = None,
                                  value: Option[ChannelDefWithLegend.ValueUnion] = None,
                                  timeUnit: Option[TimeUnit] = None,
                                  bin: Option[ChannelDefWithLegend.BinUnion] = None,
                                  aggregate: Option[AggregateOp] = None,
                                  title: Option[String] = None);

  case class Legend(format: Option[String] = None,
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

  case class FieldDef(field: Option[String] = None,
                      `type`: Option[Type] = None,
                      value: Option[FieldDef.ValueUnion] = None,
                      timeUnit: Option[TimeUnit] = None,
                      bin: Option[FieldDef.BinUnion] = None,
                      aggregate: Option[AggregateOp] = None,
                      title: Option[String] = None);

  case class OrderChannelDef(sort: Option[SortOrder] = None,
                             field: Option[String] = None,
                             `type`: Option[Type] = None,
                             value: Option[OrderChannelDef.ValueUnion] = None,
                             timeUnit: Option[TimeUnit] = None,
                             bin: Option[OrderChannelDef.BinUnion] = None,
                             aggregate: Option[AggregateOp] = None,
                             title: Option[String] = None);

  case class Data(format: Option[DataFormat] = None,
                  url: Option[String] = None,
                  values: Option[List[Data.Values]] = None);

  case class DataFormat(`type`: Option[DataFormatType] = None,
                        property: Option[String] = None,
                        feature: Option[String] = None,
                        mesh: Option[String] = None);

  case class Transform(filter: Option[Transform.FilterUnion] = None,
                       filterInvalid: Option[Boolean] = None,
                       calculate: Option[List[Formula]] = None);

  case class EqualFilter(timeUnit: Option[TimeUnit] = None,
                         field: String,
                         equal: EqualFilter.EqualUnion);

  case class DateTime(year: Option[Double] = None,
                      quarter: Option[Double] = None,
                      month: Option[DateTime.MonthUnion] = None,
                      date: Option[Double] = None,
                      day: Option[DateTime.DayUnion] = None,
                      hours: Option[Double] = None,
                      minutes: Option[Double] = None,
                      seconds: Option[Double] = None,
                      milliseconds: Option[Double] = None);

  case class RangeFilter(timeUnit: Option[TimeUnit] = None,
                         field: String,
                         range: List[RangeFilter.RangeUnion]);

  case class InFilter(timeUnit: Option[TimeUnit] = None,
                      field: String,
                      in: List[InFilter.InUnion]);

  case class Formula(field: String,
                     expr: String);

  case class Config(viewport: Option[Double] = None,
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

  case class CellConfig(width: Option[Double] = None,
                        height: Option[Double] = None,
                        clip: Option[Boolean] = None,
                        fill: Option[String] = None,
                        fillOpacity: Option[Double] = None,
                        stroke: Option[String] = None,
                        strokeOpacity: Option[Double] = None,
                        strokeWidth: Option[Double] = None,
                        strokeDash: Option[List[Double]] = None,
                        strokeDashOffset: Option[Double] = None);

  case class MarkConfig(filled: Option[Boolean] = None,
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
                        shape: Option[Shape] = None,
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

  case class OverlayConfig(line: Option[Boolean] = None,
                           area: Option[AreaOverlay] = None,
                           pointStyle: Option[MarkConfig] = None,
                           lineStyle: Option[MarkConfig] = None);

  case class ScaleConfig(round: Option[Boolean] = None,
                         textBandWidth: Option[Double] = None,
                         bandSize: Option[Double] = None,
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

  case class AxisConfig(axisWidth: Option[Double] = None,
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

  case class LegendConfig(orient: Option[String] = None,
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

  case class FacetConfig(scale: Option[FacetScaleConfig] = None,
                         axis: Option[AxisConfig] = None,
                         grid: Option[FacetGridConfig] = None,
                         cell: Option[CellConfig] = None);

  case class FacetScaleConfig(round: Option[Boolean] = None,
                              padding: Option[Double] = None);

  case class FacetGridConfig(color: Option[String] = None,
                             opacity: Option[Double] = None,
                             offset: Option[Double] = None);

  case class FacetSpec(facet: Facet,
                       spec: FacetSpec.SpecUnion,
                       name: Option[String] = None,
                       description: Option[String] = None,
                       data: Option[Data] = None,
                       transform: Option[Transform] = None,
                       config: Option[Config] = None);

  case class Facet(row: Option[PositionChannelDef] = None,
                   column: Option[PositionChannelDef] = None);

  case class LayerSpec(layers: List[UnitSpec],
                       name: Option[String] = None,
                       description: Option[String] = None,
                       data: Option[Data] = None,
                       transform: Option[Transform] = None,
                       config: Option[Config] = None);

  case class UnitSpec(mark: Mark,
                      encoding: Option[UnitEncoding] = None,
                      name: Option[String] = None,
                      description: Option[String] = None,
                      data: Option[Data] = None,
                      transform: Option[Transform] = None,
                      config: Option[Config] = None);

  case class UnitEncoding(x: Option[PositionChannelDef] = None,
                          y: Option[PositionChannelDef] = None,
                          x2: Option[PositionChannelDef] = None,
                          y2: Option[PositionChannelDef] = None,
                          color: Option[ChannelDefWithLegend] = None,
                          opacity: Option[ChannelDefWithLegend] = None,
                          size: Option[ChannelDefWithLegend] = None,
                          shape: Option[ChannelDefWithLegend] = None,
                          detail: Option[UnitEncoding.DetailUnion] = None,
                          text: Option[FieldDef] = None,
                          label: Option[FieldDef] = None,
                          path: Option[UnitEncoding.PathUnion] = None,
                          order: Option[UnitEncoding.OrderUnion] = None);

  case class VegaExtendedUnitSpec(x: ExtendedUnitSpec) extends VegaUnion;

  case class VegaFacetSpec(x: FacetSpec) extends VegaUnion;

  case class VegaLayerSpec(x: LayerSpec) extends VegaUnion;

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

  object Encoding {

    @union sealed trait DetailUnion extends scala.Product with scala.Serializable;

    @union sealed trait PathUnion extends scala.Product with scala.Serializable;

    @union sealed trait OrderUnion extends scala.Product with scala.Serializable;

    case class DetailFieldDef(x: FieldDef) extends DetailUnion;

    case class DetailListFieldDef(x: List[FieldDef]) extends DetailUnion;

    case class PathOrderChannelDef(x: OrderChannelDef) extends PathUnion;

    case class PathListOrderChannelDef(x: List[OrderChannelDef]) extends PathUnion;

    case class OrderOrderChannelDef(x: OrderChannelDef) extends OrderUnion;

    case class OrderListOrderChannelDef(x: List[OrderChannelDef]) extends OrderUnion

  };

  object PositionChannelDef {

    @union sealed trait AxisUnion extends scala.Product with scala.Serializable;

    @union sealed trait SortUnion extends scala.Product with scala.Serializable;

    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;

    @union sealed trait BinUnion extends scala.Product with scala.Serializable;

    case class AxisBoolean(x: Boolean) extends AxisUnion;

    case class AxisAxis(x: Axis) extends AxisUnion;

    case class SortSortField(x: SortField) extends SortUnion;

    case class SortSortOrder(x: SortOrder) extends SortUnion;

    case class ValueDouble(x: Double) extends ValueUnion;

    case class ValueString(x: String) extends ValueUnion;

    case class ValueBoolean(x: Boolean) extends ValueUnion;

    case class BinBoolean(x: Boolean) extends BinUnion;

    case class BinBin(x: Bin) extends BinUnion

  };

  object Axis {

    case class Properties(x: Any)

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

  object Scale {

    @union sealed trait DomainUnion extends scala.Product with scala.Serializable;

    @union sealed trait RangeUnion extends scala.Product with scala.Serializable;

    @union sealed trait NiceUnion extends scala.Product with scala.Serializable;

    case class DomainListDouble(x: List[Double]) extends DomainUnion;

    case class DomainListString(x: List[String]) extends DomainUnion;

    case class RangeString(x: String) extends RangeUnion;

    case class RangeListDouble(x: List[Double]) extends RangeUnion;

    case class RangeListString(x: List[String]) extends RangeUnion;

    case class NiceBoolean(x: Boolean) extends NiceUnion;

    case class NiceNiceTime(x: NiceTime) extends NiceUnion

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

  object ChannelDefWithLegend {

    @union sealed trait SortUnion extends scala.Product with scala.Serializable;

    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;

    @union sealed trait BinUnion extends scala.Product with scala.Serializable;

    case class SortSortField(x: SortField) extends SortUnion;

    case class SortSortOrder(x: SortOrder) extends SortUnion;

    case class ValueDouble(x: Double) extends ValueUnion;

    case class ValueString(x: String) extends ValueUnion;

    case class ValueBoolean(x: Boolean) extends ValueUnion;

    case class BinBoolean(x: Boolean) extends BinUnion;

    case class BinBin(x: Bin) extends BinUnion

  };

  object Legend {

    case class Values(x: Any);

    case class Properties(x: Any)

  };

  object FieldDef {

    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;

    @union sealed trait BinUnion extends scala.Product with scala.Serializable;

    case class ValueDouble(x: Double) extends ValueUnion;

    case class ValueString(x: String) extends ValueUnion;

    case class ValueBoolean(x: Boolean) extends ValueUnion;

    case class BinBoolean(x: Boolean) extends BinUnion;

    case class BinBin(x: Bin) extends BinUnion

  };

  object OrderChannelDef {

    @union sealed trait ValueUnion extends scala.Product with scala.Serializable;

    @union sealed trait BinUnion extends scala.Product with scala.Serializable;

    case class ValueDouble(x: Double) extends ValueUnion;

    case class ValueString(x: String) extends ValueUnion;

    case class ValueBoolean(x: Boolean) extends ValueUnion;

    case class BinBoolean(x: Boolean) extends BinUnion;

    case class BinBin(x: Bin) extends BinUnion

  };

  object Data {

    case class Values(x: Any)

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

  object Transform {

    @union sealed trait FilterUnion extends scala.Product with scala.Serializable;

    @union sealed trait Filter5Union extends scala.Product with scala.Serializable;

    case class FilterString(x: String) extends FilterUnion;

    case class FilterEqualFilter(x: EqualFilter) extends FilterUnion;

    case class FilterRangeFilter(x: RangeFilter) extends FilterUnion;

    case class FilterInFilter(x: InFilter) extends FilterUnion;

    case class FilterListTransformFilter5Union(x: List[Transform.Filter5Union]) extends FilterUnion;

    case class Filter5String(x: String) extends Filter5Union;

    case class Filter5EqualFilter(x: EqualFilter) extends Filter5Union;

    case class Filter5RangeFilter(x: RangeFilter) extends Filter5Union;

    case class Filter5InFilter(x: InFilter) extends Filter5Union

  };

  object EqualFilter {

    @union sealed trait EqualUnion extends scala.Product with scala.Serializable;

    case class EqualString(x: String) extends EqualUnion;

    case class EqualDouble(x: Double) extends EqualUnion;

    case class EqualBoolean(x: Boolean) extends EqualUnion;

    case class EqualDateTime(x: DateTime) extends EqualUnion

  };

  object DateTime {

    @union sealed trait MonthUnion extends scala.Product with scala.Serializable;

    @union sealed trait DayUnion extends scala.Product with scala.Serializable;

    case class MonthDouble(x: Double) extends MonthUnion;

    case class MonthString(x: String) extends MonthUnion;

    case class DayDouble(x: Double) extends DayUnion;

    case class DayString(x: String) extends DayUnion

  };

  object RangeFilter {

    @union sealed trait RangeUnion extends scala.Product with scala.Serializable;

    case class RangeDouble(x: Double) extends RangeUnion;

    case class RangeDateTime(x: DateTime) extends RangeUnion

  };

  object InFilter {

    @union sealed trait InUnion extends scala.Product with scala.Serializable;

    case class InString(x: String) extends InUnion;

    case class InDouble(x: Double) extends InUnion;

    case class InBoolean(x: Boolean) extends InUnion;

    case class InDateTime(x: DateTime) extends InUnion

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

  object OrientEnums {

    case object Horizontal extends Orient with scala.Product with scala.Serializable {
      val json: String = "\"horizontal\""
    };

    case object Vertical extends Orient with scala.Product with scala.Serializable {
      val json: String = "\"vertical\""
    }

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

  object FontStyleEnums {

    case object Normal extends FontStyle with scala.Product with scala.Serializable {
      val json: String = "\"normal\""
    };

    case object Italic extends FontStyle with scala.Product with scala.Serializable {
      val json: String = "\"italic\""
    }

  };

  object FontWeightEnums {

    case object Normal extends FontWeight with scala.Product with scala.Serializable {
      val json: String = "\"normal\""
    };

    case object Bold extends FontWeight with scala.Product with scala.Serializable {
      val json: String = "\"bold\""
    }

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

  object ScaleConfig {

    @union sealed trait NominalColorRangeUnion extends scala.Product with scala.Serializable;

    @union sealed trait SequentialColorRangeUnion extends scala.Product with scala.Serializable;

    @union sealed trait ShapeRangeUnion extends scala.Product with scala.Serializable;

    case class NominalColorRangeString(x: String) extends NominalColorRangeUnion;

    case class NominalColorRangeListString(x: List[String]) extends NominalColorRangeUnion;

    case class SequentialColorRangeString(x: String) extends SequentialColorRangeUnion;

    case class SequentialColorRangeListString(x: List[String]) extends SequentialColorRangeUnion;

    case class ShapeRangeString(x: String) extends ShapeRangeUnion;

    case class ShapeRangeListString(x: List[String]) extends ShapeRangeUnion

  };

  object AxisConfig {

    case class Properties(x: Any)

  };

  object LegendConfig {

    case class Properties(x: Any)

  };

  object FacetSpec {

    @union sealed trait SpecUnion extends scala.Product with scala.Serializable;

    case class SpecLayerSpec(x: LayerSpec) extends SpecUnion;

    case class SpecUnitSpec(x: UnitSpec) extends SpecUnion

  };

  object UnitEncoding {

    @union sealed trait DetailUnion extends scala.Product with scala.Serializable;

    @union sealed trait PathUnion extends scala.Product with scala.Serializable;

    @union sealed trait OrderUnion extends scala.Product with scala.Serializable;

    case class DetailFieldDef(x: FieldDef) extends DetailUnion;

    case class DetailListFieldDef(x: List[FieldDef]) extends DetailUnion;

    case class PathOrderChannelDef(x: OrderChannelDef) extends PathUnion;

    case class PathListOrderChannelDef(x: List[OrderChannelDef]) extends PathUnion;

    case class OrderOrderChannelDef(x: OrderChannelDef) extends OrderUnion;

    case class OrderListOrderChannelDef(x: List[OrderChannelDef]) extends OrderUnion

  };

  object Implicits extends LowPriorityImplicits

}