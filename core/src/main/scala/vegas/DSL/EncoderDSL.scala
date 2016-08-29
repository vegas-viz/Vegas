package vegas.DSL

import monocle.Lens
import monocle.macros.GenLens
import vegas.spec.Spec2._
import vegas.macros.{ alias_with_lens, aliased }

@aliased
trait EncoderDSL {
  self: SpecBuilder =>

  private val _encoding = GenLens[ExtendedUnitSpec](_.encoding)
  private val _x = GenLens[Encoding](_.x)
  private val _y = GenLens[Encoding](_.y)
  private val _column = GenLens[Encoding](_.column)
  private val _row = GenLens[Encoding](_.row)
  private val _color = GenLens[Encoding](_.color)
  private val _size = GenLens[Encoding](_.size)
  private val _shape = GenLens[Encoding](_.shape)

  private val _aggregate = GenLens[PositionChannelDef](_.aggregate)
  private val _axis = GenLens[PositionChannelDef](_.axis)
  private val _pcdScale = GenLens[PositionChannelDef](_.scale)

  private val _cdwlScale = GenLens[ChannelDefWithLegend](_.scale)

  //-------
  // Encoding
  //-------

  @alias_with_lens("encodeX", _x)
  @alias_with_lens("encodeY", _y)
  @alias_with_lens("encodeColumn", _column)
  @alias_with_lens("encodeRow", _row)
  private def encodePCD_(l: Lens[Encoding, Option[PositionChannelDef]])(field: String, dataType: Type, aggregate: OptArg[AggregateOp] = NoArg) = {
    val cd = PositionChannelDef(field=Some(field), `type`=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens l).set(Some(cd))(this)
  }

  @alias_with_lens("encodeColor", _color)
  @alias_with_lens("encodeSize", _size)
  @alias_with_lens("encodeShape", _shape)
  private def encodeCDWL_(l: Lens[Encoding, Option[ChannelDefWithLegend]])(field: String, dataType: Type, aggregate: OptArg[AggregateOp] = NoArg) = {
    val cd = ChannelDefWithLegend(field=Some(field), `type`=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens l).set(Some(cd))(this)
  }


  //-------
  // Axis
  //-------

  @alias_with_lens("axisX", _x)
  @alias_with_lens("axisY", _y)
  @alias_with_lens("axisColumn", _column)
  @alias_with_lens("axisRow", _row)
  private def axisB_(cd: Lens[Encoding, Option[PositionChannelDef]])
                   (axis: Boolean) = {

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(PositionChannelDef())
      composeLens _axis).set(Some(PositionChannelDef.AxisBoolean(axis)))(this)
  }

  @alias_with_lens("axisX", _x)
  @alias_with_lens("axisY", _y)
  @alias_with_lens("axisColumn", _column)
  @alias_with_lens("axisRow", _row)
  private def axisA_(cd: Lens[Encoding, Option[PositionChannelDef]])
                   (title: OptArg[String] = NoArg, titleOffset: OptArg[Double] = NoArg, titleMaxLength: OptArg[Double] = NoArg,
                    characterWidth: OptArg[Double] = NoArg, orient: OptArg[AxisOrient] = NoArg, axisWidth: OptArg[Double] = NoArg,
                    offset: OptArg[Double] = NoArg, grid: OptArg[Boolean] = NoArg, ticks: OptArg[Double] = NoArg, tickColor: OptArg[String] = NoArg,
                    tickLabelFontSize: OptArg[Double] = NoArg, titleFontSize: OptArg[Double] = NoArg) = {

    val axis = Axis(title=title, titleOffset=titleOffset, titleMaxLength=titleMaxLength, characterWidth=characterWidth,
      orient=orient, axisWidth=axisWidth, offset=offset, grid=grid, ticks=ticks, tickColor=tickColor, tickLabelFontSize=tickLabelFontSize,
      titleFontSize=titleFontSize)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(PositionChannelDef())
      composeLens _axis).set(Some(PositionChannelDef.AxisAxis(axis)))(this)
  }

  //-------
  // Scale
  //-------

  @alias_with_lens("scaleX", _x)
  @alias_with_lens("scaleY",  _y)
  @alias_with_lens("scaleRow", _row)
  @alias_with_lens("scaleColumn", _column)
  private def scale_PCD(pcd: Lens[Encoding, Option[PositionChannelDef]])
                        (scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Double] = NoArg, padding: OptArg[Double] = NoArg) = {

    val scale = Scale(`type`=scaleType, bandSize=bandSize, padding=padding)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens pcd composePrism _orElse(PositionChannelDef())
      composeLens _pcdScale).set(Some(scale))(this)
  }

  @alias_with_lens("scaleColor", _color)
  @alias_with_lens("scaleSize",  _size)
  @alias_with_lens("scaleShape", _shape)
  private def scaleCDWL_(cdwl: Lens[Encoding, Option[ChannelDefWithLegend]])
                    (scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Double] = NoArg, padding: OptArg[Double] = NoArg,
                     rangeValues: OptArg[List[Double]] = NoArg, rangeNominals: OptArg[List[String]] = NoArg, rangePreset: OptArg[String] = NoArg) = {

    val rangeU = (rangeValues.map(Scale.RangeListDouble(_)) orElse rangeNominals.map(Scale.RangeListString(_)) orElse rangePreset.map(Scale.RangeString(_)))
    val scale = Scale(`type`=scaleType, bandSize=bandSize, padding=padding, range=rangeU)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cdwl composePrism _orElse(ChannelDefWithLegend())
      composeLens _cdwlScale).set(Some(scale))(this)
  }

}
