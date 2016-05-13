package vegas.DSL

import monocle.Lens
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

  // -------
  // Axis
  // ------

  private def axisCD(cd: Lens[Encoding, Option[ChannelDef]], hide: OptArg[Boolean], title: OptArg[String],
                     titleOffset: OptArg[Int], titleMaxLength: OptArg[Int], characterWidth: OptArg[Int],
                     orient: OptArg[Orient], axisWidth: OptArg[Int], offset: OptArg[Int], grid: OptArg[Boolean],
                     ticks: OptArg[Int], tickColor: OptArg[String], tickLabelFontSize: OptArg[Int], titleFontSize: OptArg[Int],
                     labels: OptArg[Boolean], format: OptArg[String], labelAngle: OptArg[Double],
                     labelMaxLength: OptArg[Int], shortTimeLabels: OptArg[Boolean]) = {

    val axis = Axis(hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize, titleFontSize, labels, format, labelAngle, labelMaxLength, shortTimeLabels)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(ChannelDef())
      composeLens _axis).set(Some(axis))(this)
  }

  def axisX(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg,
            titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg, orient: OptArg[Orient] = NoArg,
            axisWidth: OptArg[Int] = NoArg, offset: OptArg[Int] = NoArg, grid: OptArg[Boolean] = NoArg,
            ticks: OptArg[Int] = NoArg, tickColor: OptArg[String] = NoArg, tickLabelFontSize: OptArg[Int] = NoArg,
            titleFontSize: OptArg[Int] = NoArg,
            labels: OptArg[Boolean] = NoArg, format: OptArg[String] = NoArg, labelAngle: OptArg[Double] = NoArg,
            labelMaxLength: OptArg[Int] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg) = {

    require(orient.map(Seq(Top, Bottom).contains).getOrElse(true), "Orient must be Top or Bottom for X or Column")

    axisCD(_x, hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize, titleFontSize, labels, format, labelAngle, labelMaxLength, shortTimeLabels)
  }

  def axisY(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg,
            titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg, orient: OptArg[Orient] = NoArg,
            axisWidth: OptArg[Int] = NoArg, offset: OptArg[Int] = NoArg, grid: OptArg[Boolean] = NoArg,
            ticks: OptArg[Int] = NoArg, tickColor: OptArg[String] = NoArg, tickLabelFontSize: OptArg[Int] = NoArg,
            titleFontSize: OptArg[Int] = NoArg,
            labels: OptArg[Boolean] = NoArg, format: OptArg[String] = NoArg, labelAngle: OptArg[Double] = NoArg,
            labelMaxLength: OptArg[Int] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg) = {


    require(orient.map(Seq(Left, Right).contains).getOrElse(true), "Orient must be Left or Right for Y or Row")

    axisCD(_y, hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize, titleFontSize, labels, format, labelAngle, labelMaxLength, shortTimeLabels)
  }

  def axisColumn(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg,
                 titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg, orient: OptArg[Orient] = NoArg,
                 axisWidth: OptArg[Int] = NoArg, offset: OptArg[Int] = NoArg, grid: OptArg[Boolean] = NoArg,
                 ticks: OptArg[Int] = NoArg, tickColor: OptArg[String] = NoArg, tickLabelFontSize: OptArg[Int] = NoArg,
                 titleFontSize: OptArg[Int] = NoArg,
                 labels: OptArg[Boolean] = NoArg, format: OptArg[String] = NoArg, labelAngle: OptArg[Double] = NoArg,
                 labelMaxLength: OptArg[Int] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg) = {


    require(orient.map(Seq(Top, Bottom).contains).getOrElse(true), "Orient must be Top or Bottom for X or Column")

    axisCD(_column, hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize, titleFontSize, labels, format, labelAngle, labelMaxLength, shortTimeLabels)
  }

  def axisRow(hide: OptArg[Boolean] = NoArg, title: OptArg[String] = NoArg, titleOffset: OptArg[Int] = NoArg,
              titleMaxLength: OptArg[Int] = NoArg, characterWidth: OptArg[Int] = NoArg, orient: OptArg[Orient] = NoArg,
              axisWidth: OptArg[Int] = NoArg, offset: OptArg[Int] = NoArg, grid: OptArg[Boolean] = NoArg,
              ticks: OptArg[Int] = NoArg, tickColor: OptArg[String] = NoArg, tickLabelFontSize: OptArg[Int] = NoArg,
              titleFontSize: OptArg[Int] = NoArg,
              labels: OptArg[Boolean] = NoArg, format: OptArg[String] = NoArg, labelAngle: OptArg[Double] = NoArg,
              labelMaxLength: OptArg[Int] = NoArg, shortTimeLabels: OptArg[Boolean] = NoArg) = {

    require(orient.map(Seq(Left, Right).contains).getOrElse(true), "Orient must be Left or Right for Y or Row")

    axisCD(_row, hide, title, titleOffset, titleMaxLength, characterWidth, orient, axisWidth, offset, grid, ticks,
      tickColor, tickLabelFontSize, titleFontSize, labels, format, labelAngle, labelMaxLength, shortTimeLabels)
  }

  // -------
  // Scale
  // ------

  private def scaleCD(cd: Lens[Encoding, Option[ChannelDef]], scaleType: OptArg[ScaleType], bandSize: OptArg[Int],
                      padding: OptArg[Int], range: OptArg[Seq[String]], rangePreset: OptArg[RangePreset]) = {

    val scale = Scale(scaleType, bandSize, padding, range, rangePreset)

    (_spec composeLens _encoding composePrism _orElse(Encoding()) composeLens cd composePrism _orElse(ChannelDef())
      composeLens _scale).set(Some(scale))(this)
  }

  def scaleX(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg, padding: OptArg[Int] = NoArg,
             range: OptArg[Seq[String]] = NoArg, rangePreset: OptArg[RangePreset] = NoArg) = {

    scaleCD(_x, scaleType, bandSize, padding, range, rangePreset)
  }

  def scaleY(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg, padding: OptArg[Int] = NoArg,
             range: OptArg[Seq[String]] = NoArg, rangePreset: OptArg[RangePreset] = NoArg) = {

    scaleCD(_y, scaleType, bandSize, padding, range, rangePreset)
  }

  def scaleColumn(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg, padding: OptArg[Int] = NoArg,
                  range: OptArg[Seq[String]] = NoArg, rangePreset: OptArg[RangePreset] = NoArg) = {

    scaleCD(_column, scaleType, bandSize, padding, range, rangePreset)
  }

  def scaleRow(scaleType: OptArg[ScaleType] = NoArg, bandSize: OptArg[Int] = NoArg, padding: OptArg[Int] = NoArg,
               range: OptArg[Seq[String]] = NoArg, rangePreset: OptArg[RangePreset] = NoArg) = {

    scaleCD(_row, scaleType, bandSize, padding, range, rangePreset)
  }

  def scaleColor(range: OptArg[Seq[String]] = NoArg, rangePreset: OptArg[RangePreset] = NoArg) = {

    scaleCD(_color, NoArg, NoArg, NoArg, range, rangePreset)
  }

}
