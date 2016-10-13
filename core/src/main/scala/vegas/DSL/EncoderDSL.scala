package vegas.DSL

import monocle.{Lens, Optional}
import monocle.macros.GenLens
import vegas.data.SimpleTypeUtils
import vegas.spec.Spec._
import vegas.macros.{alias_with_lens, aliased}

@aliased
trait EncoderDSL[T] extends BaseEncoderDSL[T] {
  self: T =>

  protected[this] def _encoding: Lens[T, Option[Encoding]]

  private val _column = GenLens[Encoding](_.column)
  private val _row = GenLens[Encoding](_.row)
  private val _x = GenLens[Encoding](_.x)
  private val _y = GenLens[Encoding](_.y)
  private val _x2 = GenLens[Encoding](_.x2)
  private val _y2 = GenLens[Encoding](_.y2)

  private val _color = GenLens[Encoding](_.color)
  private val _opacity = GenLens[Encoding](_.opacity)
  private val _size = GenLens[Encoding](_.size)
  private val _shape = GenLens[Encoding](_.shape)

  private val _text = GenLens[Encoding](_.text)
  private val _label = GenLens[Encoding](_.label)
  private val _detail = GenLens[Encoding](_.detail)

  // TODO
  private val _path = GenLens[Encoding](_.path)
  private val _order = GenLens[Encoding](_.order)

  @alias_with_lens("encodeColumn", _column)
  @alias_with_lens("encodeRow", _row)
  @alias_with_lens("encodeX", _x)
  @alias_with_lens("encodeY", _y)
  private def encodePCD_(l: Lens[Encoding, Option[PositionChannelDef]])
    (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
     aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg,
     axis: OptArg[Axis] = NoArg, hideAxis: OptArg[Boolean] = NoArg,
     scale: OptArg[Scale] = NoArg, timeUnit: OptArg[TimeUnit] = NoArg, title: OptArg[String] = NoArg,
     bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
     sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val lens = (_encoding composePrism _orElse(Encoding()) composeLens l)

    baseEncodePCD(lens)(field, dataType, aggregate, value, axis, hideAxis, scale, timeUnit, title, bin, enableBin,
      sortField, sortOrder)

  }

  @alias_with_lens("encodeColor", _color)
  @alias_with_lens("encodeOpacity", _opacity)
  @alias_with_lens("encodeSize", _size)
  @alias_with_lens("encodeShape", _shape)
  private def encodeCDWL_(l: Lens[Encoding, Option[ChannelDefWithLegend]])
    (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
     aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg, scale:OptArg[Scale] = NoArg,
     timeUnit: OptArg[TimeUnit] = NoArg, title: OptArg[String] = NoArg, legend: OptArg[Legend] = NoArg,
     bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
     sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val lens = (_encoding composePrism _orElse(Encoding()) composeLens l)

    baseEncodeCDWL(lens)(field, dataType, aggregate, value, scale, timeUnit, title, legend, bin, enableBin,
      sortField, sortOrder)

  }

  @alias_with_lens("encodeText", _text)
  @alias_with_lens("encodeLabel", _label)
  @alias_with_lens("encodeX2", _x2)
  @alias_with_lens("encodeY2", _y2)
  private def encodeFD_(l: Lens[Encoding, Option[FieldDef]])
                       (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg, value: OptArg[Any] = NoArg,
                        timeUnit: OptArg[TimeUnit] = NoArg, bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                        aggregate: OptArg[AggregateOp] = NoArg,
                        title: OptArg[String] = NoArg) = {

    val lens = (_encoding composePrism _orElse(Encoding()) composeLens l)

    baseEncoderFD(lens)(field, dataType, value, timeUnit, bin, enableBin, aggregate, title)

  }

  def encodeDetailFields(fields: FieldDef*): T = {
    val detailU = if (fields.size == 1) Encoding.DetailFieldDef(fields.head) else Encoding.DetailListFieldDef(fields.toList)
    val lens = (_encoding composePrism _orElse(Encoding()) composeLens _detail)
    lens.set(Some(detailU))(this)
  }


}


@aliased
trait UnitEncoderDSL[T] extends BaseEncoderDSL[T] {
  self: T =>

  protected[this] def _encoding: Lens[T, Option[UnitEncoding]]

  private val _x = GenLens[UnitEncoding](_.x)
  private val _y = GenLens[UnitEncoding](_.y)
  private val _x2 = GenLens[UnitEncoding](_.x2)
  private val _y2 = GenLens[UnitEncoding](_.y2)

  private val _color = GenLens[UnitEncoding](_.color)
  private val _opacity = GenLens[UnitEncoding](_.opacity)
  private val _size = GenLens[UnitEncoding](_.size)
  private val _shape = GenLens[UnitEncoding](_.shape)

  private val _text = GenLens[UnitEncoding](_.text)
  private val _label = GenLens[UnitEncoding](_.label)
  private val _detail = GenLens[UnitEncoding](_.detail)

  // TODO
  private val _path = GenLens[UnitEncoding](_.path)
  private val _order = GenLens[UnitEncoding](_.order)

  @alias_with_lens("encodeX", _x)
  @alias_with_lens("encodeY", _y)
  private def encodePCD_(l: Lens[UnitEncoding, Option[PositionChannelDef]])
                        (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
                         aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg,
                         axis: OptArg[Axis] = NoArg, hideAxis: OptArg[Boolean] = NoArg,
                         scale: OptArg[Scale] = NoArg, timeUnit: OptArg[TimeUnit] = NoArg, title: OptArg[String] = NoArg,
                         bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                         sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val lens = (_encoding composePrism _orElse(UnitEncoding()) composeLens l)
    baseEncodePCD(lens)(field, dataType, aggregate, value, axis, hideAxis, scale, timeUnit, title, bin, enableBin,
      sortField, sortOrder)
  }

  @alias_with_lens("encodeColor", _color)
  @alias_with_lens("encodeOpacity", _opacity)
  @alias_with_lens("encodeSize", _size)
  @alias_with_lens("encodeShape", _shape)
  private def encodeCDWL_(l: Lens[UnitEncoding, Option[ChannelDefWithLegend]])
                         (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
                          aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg, scale:OptArg[Scale] = NoArg,
                          timeUnit: OptArg[TimeUnit] = NoArg, title: OptArg[String] = NoArg, legend: OptArg[Legend] = NoArg,
                          bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                          sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val lens = (_encoding composePrism _orElse(UnitEncoding()) composeLens l)
    baseEncodeCDWL(lens)(field, dataType, aggregate, value, scale, timeUnit, title, legend, bin, enableBin,
      sortField, sortOrder)
  }

  @alias_with_lens("encodeText", _text)
  @alias_with_lens("encodeLabel", _label)
  @alias_with_lens("encodeX2", _x2)
  @alias_with_lens("encodeY2", _y2)
  private def encodeFD_(l: Lens[UnitEncoding, Option[FieldDef]])
                       (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg, value: OptArg[Any] = NoArg,
                        timeUnit: OptArg[TimeUnit] = NoArg, bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                        aggregate: OptArg[AggregateOp] = NoArg,
                        title: OptArg[String] = NoArg) = {

    val lens = (_encoding composePrism _orElse(UnitEncoding()) composeLens l)

    baseEncoderFD(lens)(field, dataType, value, timeUnit, bin, enableBin, aggregate, title)
  }

  def encodeDetailFields(fields: FieldDef*): T = {
    val detailU = if (fields.size == 1) UnitEncoding.DetailFieldDef(fields.head) else UnitEncoding.DetailListFieldDef(fields.toList)
    val lens = (_encoding composePrism _orElse(UnitEncoding()) composeLens _detail)
    lens.set(Some(detailU))(this)
  }

}

trait BaseEncoderDSL[T] {
  self: T =>

  protected def baseEncodePCD(lens: Optional[T, Option[PositionChannelDef]])
                        (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
                         aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg,
                         axis: OptArg[Axis] = NoArg, hideAxis: OptArg[Boolean] = NoArg,
                         scale: OptArg[Scale] = NoArg, timeUnit: OptArg[TimeUnit] = NoArg, title: OptArg[String] = NoArg,
                         bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                         sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val valueU = value.map {
      case b: Boolean => PositionChannelDef.ValueBoolean(b)
      case s: String =>  PositionChannelDef.ValueString(s)
      case x@_ => SimpleTypeUtils.toDouble(x).map(PositionChannelDef.ValueDouble(_))
        .getOrElse(throw new Exception("Value must be AnyVal, Boolean, or String"))
    }
    val axisU = (axis.map(PositionChannelDef.AxisAxis(_)) orElse hideAxis.map(b => PositionChannelDef.AxisBoolean( !b )))
    val binU = (bin.map(PositionChannelDef.BinBin(_)) orElse enableBin.map(b => PositionChannelDef.BinBoolean( b )))

    val sortU = (sortField.map(PositionChannelDef.SortSortField(_)) orElse sortOrder.map(PositionChannelDef.SortSortOrder(_)))

    val cd = PositionChannelDef(field=field, `type`=dataType, aggregate=aggregate, axis=axisU, scale=scale, value=valueU,
      timeUnit=timeUnit, title=title, bin=binU, sort=sortU)

    lens.set(Some(cd))(this)
  }

  protected def baseEncodeCDWL(lens: Optional[T, Option[ChannelDefWithLegend]])
                         (field: OptArg[String] = NoArg, dataType: OptArg[Type] = NoArg,
                          aggregate: OptArg[AggregateOp] = NoArg, value: OptArg[Any] = NoArg,
                          scale: OptArg[Scale] = NoArg, timeUnit: OptArg[TimeUnit] = NoArg,
                          title: OptArg[String] = NoArg, legend: OptArg[Legend]= NoArg,
                          bin: OptArg[Bin] = NoArg, enableBin: OptArg[Boolean] = NoArg,
                          sortField: OptArg[SortField] = NoArg, sortOrder: OptArg[SortOrder] = NoArg) = {

    val valueU = value.map {
      case b: Boolean => ChannelDefWithLegend.ValueBoolean(b)
      case s: String => ChannelDefWithLegend.ValueString(s)
      case x@_ => SimpleTypeUtils.toDouble(x).map(ChannelDefWithLegend.ValueDouble(_))
        .getOrElse(throw new Exception("Value must be AnyVal, Boolean, or String"))
    }
    val binU = (bin.map(ChannelDefWithLegend.BinBin(_)) orElse enableBin.map(b => ChannelDefWithLegend.BinBoolean( b )))
    val sortU = (sortField.map(ChannelDefWithLegend.SortSortField(_)) orElse sortOrder.map(ChannelDefWithLegend.SortSortOrder(_)))

    val cd = ChannelDefWithLegend(field = field, `type` = dataType, aggregate = aggregate, value = valueU, scale = scale,
      timeUnit = timeUnit, title = title, legend=legend, bin=binU, sort=sortU)
    lens.set(Some(cd))(this)
  }

  protected def baseEncoderFD(lens: Optional[T, Option[FieldDef]])
                              (field: OptArg[String] = NoArg,
                               dataType: OptArg[Type] = NoArg,
                               value: OptArg[Any] = NoArg,
                               timeUnit: OptArg[TimeUnit] = NoArg,
                               bin: OptArg[Bin] = NoArg,
                               enableBin: OptArg[Boolean] = NoArg,
                               aggregate: OptArg[AggregateOp] = NoArg,
                               title: OptArg[String] = NoArg) = {
    val valueU = value.map {
      case b: Boolean => FieldDef.ValueBoolean(b)
      case s: String => FieldDef.ValueString(s)
      case x@_ => SimpleTypeUtils.toDouble(x).map(FieldDef.ValueDouble(_))
        .getOrElse(throw new Exception("Value must be AnyVal, Boolean, or String"))
    }

    val binU = (bin.map(FieldDef.BinBin(_)) orElse enableBin.map(b => FieldDef.BinBoolean( b )))

    val fd = FieldDef(field = field, `type` = dataType, aggregate = aggregate, value = valueU, timeUnit = timeUnit,
      bin = binU, title=title)

    lens.set(Some(fd))(this)

  }

  def encodeDetailFields(fields: FieldDef*): T

  def encodeDetail(fields: String*): T = {
    val fieldDefs = fields.map { f => FieldDef.apply(field = Some(f)) }
    encodeDetailFields(fieldDefs: _*)
  }

}

object FieldDSL {

  def apply(field: OptArg[String] = NoArg,
            dataType: OptArg[Type] = NoArg,
            value: OptArg[Any] = NoArg,
            timeUnit: OptArg[TimeUnit] = NoArg,
            bin: OptArg[Bin] = NoArg,
            enableBin: OptArg[Boolean] = NoArg,
            aggregate: OptArg[AggregateOp] = NoArg,
            title: OptArg[String] = NoArg) = {

    val valueU = value.map {
      case b: Boolean => FieldDef.ValueBoolean(b)
      case s: String => FieldDef.ValueString(s)
      case x@_ => SimpleTypeUtils.toDouble(x).map(FieldDef.ValueDouble(_))
        .getOrElse(throw new Exception("Value must be AnyVal, Boolean, or String"))
    }

    val binU = (bin.map(FieldDef.BinBin(_)) orElse enableBin.map(b => FieldDef.BinBoolean( b )))

    FieldDef(
      field = field,
      `type` = dataType,
      value = valueU,
      timeUnit = timeUnit,
      bin = binU,
      aggregate = aggregate
    )

  }

}
