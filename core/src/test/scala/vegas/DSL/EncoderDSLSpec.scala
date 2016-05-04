package vegas.DSL

import vegas._
import vegas.spec.{ ChannelDef, Encoding, Scale, Axis, Aggregate }

/**
  * @author Aish Fenton.
  */
class EncoderDSLSpec extends BaseSpec with Fixtures {

  "Encoder Trait" should "encode x and y fields" in {
    val specBuilder = Vegas()
      .encodeX("population", Quantitative)
      .encodeY("country", Nominal)

    specBuilder.spec.encoding.get should equal (Encoding(
      x=Some(ChannelDef(
        field = Some("population"),
        dataType = Some(Quantitative)
      )),
      y=Some(ChannelDef(
        field = Some("country"),
        dataType = Some(Nominal)
      ))
    ))
  }

  it should "set aggregate params for x and y" in {
    val specBuilder = Vegas()
      .aggregateX(Mean)
      .aggregateY(Sum)

    specBuilder.spec.encoding.get.x.get.aggregate.get should equal(Mean)
    specBuilder.spec.encoding.get.y.get.aggregate.get should equal(Sum)
  }

  it should "set axis parameters for x and y" in {
    val specBuilder = Vegas()
      .axisX(title = "title x", titleOffset = 1, titleMaxLength = 2, characterWidth = 3)
      .axisY(title = "title y")

    specBuilder.spec.encoding.get.x.get.axis.get should equal (Axis(
      title = Some("title x"),
      titleOffset = Some(1),
      titleMaxLength = Some(2),
      characterWidth = Some(3)
    ))
    specBuilder.spec.encoding.get.y.get.axis.get should equal (Axis(title = Some("title y")))
  }

  it should "set scale parameters for x and y" in {
    val specBuilder = Vegas()
      .scaleX(scaleType = Log, bandSize = 1)
      .scaleY(scaleType = Time)

    specBuilder.spec.encoding.get.x.get.scale.get should equal (Scale(
      scaleType = Some(Log),
      bandSize = Some(1)
    ))
    specBuilder.spec.encoding.get.y.get.scale.get should equal (Scale(scaleType = Some(Time)))
  }

}

