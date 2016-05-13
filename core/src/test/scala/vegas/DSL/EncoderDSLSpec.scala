package vegas.DSL

import vegas._
import vegas.spec.{ ChannelDef, Encoding, Scale, Axis, Aggregate }

/**
  * @author Aish Fenton.
  */
class EncoderDSLSpec extends BaseSpec {

  "Encoder Trait" should "encode x and y fields, and possibly aggregate" in {
    val specBuilder = Vegas()
      .encodeX("population", Quantitative)
      .encodeY("country", Nominal, aggregate=Mean)

    specBuilder.spec.encoding.get should equal (Encoding(
      x=Some(ChannelDef(
        field = Some("population"),
        dataType = Some(Quantitative)
      )),
      y=Some(ChannelDef(
        field = Some("country"),
        dataType = Some(Nominal),
        aggregate = Some(Mean)
      ))
    ))
  }

  it should "encode column and row, and possibly aggregate" in {
    val specBuilder = Vegas()
      .encodeColumn("population", Quantitative, Sum)
      .encodeRow("country", Nominal)

    specBuilder.spec.encoding.get should equal (Encoding(
      column=Some(ChannelDef(
        field = Some("population"),
        dataType = Some(Quantitative),
        aggregate = Some(Sum)
      )),
      row=Some(ChannelDef(
        field = Some("country"),
        dataType = Some(Nominal)
      ))
    ))
  }

  it should "encode color and size, and possibly aggregate" in {
    val specBuilder = Vegas()
      .encodeColor("country", Nominal, aggregate=Median)
      .encodeSize("population", Quantitative)

    specBuilder.spec.encoding.get should equal (Encoding(
      color=Some(ChannelDef(
        field = Some("country"),
        dataType = Some(Nominal),
        aggregate = Some(Median)
      )),
      size=Some(ChannelDef(
        field = Some("population"),
        dataType = Some(Quantitative)
      ))
    ))
  }

  it should "set axis parameters" in {
    val specBuilder = Vegas()
      .axisX(title = "title x", titleOffset=1, titleMaxLength=2, characterWidth=3, orient=Top, axisWidth=1,
             offset= -8, grid=false, ticks=5, tickColor = "red", tickLabelFontSize = 15, titleFontSize=12)
      .axisY(title = "title y")

    specBuilder.spec.encoding.get.x.get.axis.get should equal (Axis(
      hide = None,
      title = Some("title x"),
      titleOffset = Some(1),
      titleMaxLength = Some(2),
      characterWidth = Some(3),
      orient = Some(Top),
      axisWidth = Some(1),
      offset = Some(-8),
      grid = Some(false),
      ticks = Some(5),
      tickColor = Some("red"),
      tickLabelFontSize = Some(15),
      titleFontSize = Some(12)
    ))
    specBuilder.spec.encoding.get.y.get.axis.get should equal (Axis(title = Some("title y")))
  }

  it should "thrown an exception if Axis is set to wrong orientation" in {
    an [IllegalArgumentException] should be thrownBy { Vegas().axisX(orient = Right) }
    an [IllegalArgumentException] should be thrownBy { Vegas().axisY(orient = Bottom) }
  }

  it should "set scale parameters" in {
    val specBuilder = Vegas()
      .scaleX(scaleType = Log, bandSize=1, padding=5)
      .scaleY(scaleType = Time)
      .scaleRow(scaleType = Time)
      .scaleColumn(scaleType = Time)
      .scaleColor(range=Seq("a"), rangePreset=Category10)

    specBuilder.spec.encoding.get.x.get.scale.get should equal (Scale(
      scaleType = Some(Log),
      bandSize = Some(1),
      padding = Some(5)
    ))
    specBuilder.spec.encoding.get.y.get.scale.get should equal (Scale(scaleType = Some(Time)))
    specBuilder.spec.encoding.get.column.get.scale.get should equal (Scale(scaleType = Some(Time)))
    specBuilder.spec.encoding.get.row.get.scale.get should equal (Scale(scaleType = Some(Time)))
    specBuilder.spec.encoding.get.color.get.scale.get should equal (Scale(
      range = Some(Seq("a")),
      rangePreset = Some(Category10)
    ))
  }

}

