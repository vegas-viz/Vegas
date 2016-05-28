package vegas.DSL

import vegas._
import vegas.spec.{Data}

/**
  * @author Aish Fenton.
  */
class DataDSLSpec extends BaseSpec {

  case class Ex(a: Int, b: String)

  "DataDSL Trait" should "wire in data from Seq of Maps" in {
    val data = Seq(Map("population" -> "318", "country" -> "UK"), Map("population" -> "64", "country" -> "UK"))

    val specBuilder = Vegas()
      .withData(data)

    specBuilder.spec.data.get should equal (Data(
      values = Some(data)
    ))
  }

  it should "wire in 'row' data, treating each index as a field name" in {
    val data = Seq(Seq("a", 1), Seq("b" ,2))

    val specBuilder = Vegas()
      .withDataRow(data)

    val expectedData = Seq(Map("0" -> "a", "1" -> 1), Map("0" -> "b", "1" -> 2))
    specBuilder.spec.data.get should equal (Data(values=Some( expectedData )))
  }

  it should "extract data from a Seq of case classes" in {
    val data = Seq( Ex(1, "UK"), Ex(2, "USA") )

    val specBuilder = Vegas()
      .withReflectData(data)

    val expectedData = Seq(Map("a" -> 1, "b" -> "UK"), Map("a" -> 2, "b" -> "USA"))
    specBuilder.spec.data.get should equal (Data(values=Some( expectedData )))
  }

  it should "wire in a simple seq of numbers" in {
    val data = Seq(1,2)

    val specBuilder = Vegas()
      .withDataSeq(data)

    val expectedData = Seq(Map("x" -> 0, "y" -> 1), Map("x" -> 1, "y" -> 2))
    specBuilder.spec.data.get should equal (Data(values=Some( expectedData )))
  }

  it should "wire in a seq of (x,y) tuples" in {
    val data = Seq(("uk", 10), ("usa", 20))

    val specBuilder = Vegas()
      .withDataXY(data)

    val expectedData = Seq(Map("x" -> "uk", "y" -> 10), Map("x" -> "usa", "y" -> 20))
    specBuilder.spec.data.get should equal (Data(values=Some( expectedData )))
  }

  "FieldExtractor" should "extract fields from a case class using reflection" in {
    val ex = Ex(2, "UK")
    val fields = new FieldExtractor { }.extractFields( ex )
    fields should equal (Map("a" -> 2, "b" -> "UK"))
  }

}

