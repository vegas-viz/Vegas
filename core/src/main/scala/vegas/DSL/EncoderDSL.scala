package vegas.DSL

import monocle.macros.GenLens
import vegas.spec._

/**
  * @author Aish Fenton.
  */
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

  def encodeX(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _x).set(Some(cd))(this)
  }

  def encodeY(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _y).set(Some(cd))(this)
  }

  def encodeColumn(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _column).set(Some(cd))(this)
  }

  def encodeRow(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _row).set(Some(cd))(this)
  }

  def encodeColor(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _color).set(Some(cd))(this)
  }

  def encodeSize(field: String, dataType: DataType, aggregate: OptArg[Aggregate] = NoArg) = {
    val cd = ChannelDef(field=Some(field), dataType=Some(dataType), aggregate=aggregate)
    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _size).set(Some(cd))(this)
  }

  def axisX(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg, titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg) = {
    val axis = Axis(hide, title, titleOffset, titleMaxLength, characterWidth)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _x composePrism _orElse(ChannelDef())
      composeLens _axis).set(Some(axis))(this)
  }

  def axisY(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg, titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg) = {
    val axis = Axis(hide, title, titleOffset, titleMaxLength, characterWidth)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _y composePrism _orElse(ChannelDef())
      composeLens _axis).set(Some(axis))(this)
  }

  def scaleX(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg) = {
    val scale = Scale(scaleType, bandSize)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _x composePrism _orElse(ChannelDef())
      composeLens _scale).set(Some(scale))(this)
  }

  def scaleY(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg) = {
    val scale = Scale(scaleType, bandSize)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens _y composePrism _orElse(ChannelDef())
      composeLens _scale).set(Some(scale))(this)
  }

}
