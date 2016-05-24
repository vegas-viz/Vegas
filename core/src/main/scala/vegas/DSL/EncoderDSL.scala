package vegas.DSL

import monocle.Lens
import monocle.macros.GenLens
import vegas.spec._
import vegas.macros.{ alias_with_lens, aliased }

/**
  * @author Aish Fenton.
  */
@aliased
trait EncoderDSL {
  self: SpecBuilder =>

  private val _encoding = GenLens[Spec](_.encoding)
  private val _x = GenLens[Encoding](_.x)
  private val _y = GenLens[Encoding](_.y)
  private val _column = GenLens[Encoding](_.column)
  private val _row = GenLens[Encoding](_.row)
  private val _color = GenLens[Encoding](_.color)
  private val _size = GenLens[Encoding](_.size)
  private val _aggregate = GenLens[ChannelDef](_.aggregate)
  private val _axis = GenLens[ChannelDef](_.axis)
  private val _scale = GenLens[ChannelDef](_.scale)

  @alias_with_lens("encodeX", _x)
  @alias_with_lens("encodeY", _y)
  @alias_with_lens("encodeColumn", _column)
  @alias_with_lens("encodeRow", _row)
  @alias_with_lens("encodeColor", _color)
  @alias_with_lens("encodeSize", _size)
  private def encode_(l: Lens[Encoding, Option[ChannelDef]])(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens l).set(Some(cd))(this)
  }

  @alias_with_lens("axisX", _x)
  @alias_with_lens("axisY", _y)
  @alias_with_lens("axisColumn", _column)
  @alias_with_lens("axisRow", _row)
  private def axis_(cd: Lens[Encoding, Option[ChannelDef]])
                   (hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg,
                    titleOffset: OptArg[Int] = NoArg, titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg,
                    orient: OptArg[Orient] = NoArg, axisWidth: OptArg[Int] = NoArg, offset: OptArg[Int] = NoArg,
                    grid: OptArg[Boolean] = NoArg, ticks: OptArg[Int] = NoArg, tickColor: OptArg[String] = NoArg,
                    tickLabelFontSize: OptArg[Int] = NoArg, titleFontSize: OptArg[Int] = NoArg) = {

    val axis = Axis(hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize,titleFontSize)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(ChannelDef())
      composeLens _axis).set(Some(axis))(this)
  }

  @alias_with_lens("scaleX", _x)
  @alias_with_lens("scaleY", _y)
  @alias_with_lens("scaleColumn", _column)
  @alias_with_lens("scaleRow", _row)
  @alias_with_lens("scaleColor", _color)
  private def scale_(cd: Lens[Encoding, Option[ChannelDef]])
                    (scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg,
                     padding: OptArg[Int] = NoArg, range: OptArg[Seq[String]] = NoArg,
                     rangePreset: OptArg[RangePreset] = NoArg) = {

    val scale = Scale(scaleType, bandSize, padding, range, rangePreset)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(ChannelDef())
      composeLens _scale).set(Some(scale))(this)
  }

}
