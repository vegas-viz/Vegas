package vegas.DSL

import java.util.{Calendar, GregorianCalendar}

import org.scalatest.{FlatSpec, Matchers}
import vegas._
import vegas.data.ValueTransformer
import vegas.spec.Spec._

/**
  * @author Aish Fenton.
  */
class DataDSLSpec extends FlatSpec with Matchers {

  case class Ex(a: Int, b: String)
  val testValueTransformer = new ValueTransformer { def transform(v: Any) = "ok" }


  "DataDSL Trait" should "wire in data from Seq of Maps" in {
    val data = List(Map("population" -> "318", "country" -> "UK"), Map("population" -> "64", "country" -> "UK"))

    val specBuilder = Vegas()
      .withData(data)

    specBuilder.spec.data should === (Some(Data(
      values = Some(data.map(Data.Values(_)))
    )))
  }

  it should "wire in a Seq of data, treating each index as a column name" in {
    val data = Seq(Seq("a", 1), Seq("b" ,2))

    val specBuilder = Vegas()
      .withSeqValues(data)

    val expectedData = List(Map("0" -> "a", "1" -> 1), Map("0" -> "b", "1" -> 2))
    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)) )
    )))
  }

  it should "wire in a Seq of case classes, treating each field name as a column name" in {
    val data = Seq( Ex(1, "UK"), Ex(2, "USA") )

    val specBuilder = Vegas()
      .withCaseClasses(data)

    val expectedData = List(Map("a" -> 1, "b" -> "UK"), Map("a" -> 2, "b" -> "USA"))
    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)))
    )))
  }

  it should "wire in a simple Seq of values, treating indices as an 'x' and values as a 'y' column" in {
    val data = Seq(1,2)

    val specBuilder = Vegas()
      .withValues(data)

    val expectedData = List(Map("x" -> 0, "y" -> 1), Map("x" -> 1, "y" -> 2))
    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)) )
    )))
  }

  it should "wire in a seq of (x,y) tuples, using 'x' and 'y' as column names" in {
    val data = Seq(("uk", 10), ("usa", 20))

    val specBuilder = Vegas()
      .withXY(data)

    val expectedData = List(Map("x" -> "uk", "y" -> 10), Map("x" -> "usa", "y" -> 20))
    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)) )
    )))
  }

  it should "transform values to 'SimpleTypes' that can be handled by vega-lite" in {
    val data = Seq((new GregorianCalendar(2015, Calendar.DECEMBER, 25)).getTime, Ex(4, "a"), 3.14)

    val specBuilder = Vegas()
      .withValues(data)

    val expectedData = List(
      Map("x" -> 0, "y" -> "2015-12-25T00:00-0800"),
      Map("x" -> 1, "y" -> "Ex(4,a)"),
      Map("x" -> 2, "y" -> 3.14)
    )

    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)) )
    )))
  }

  it should "let you override how values are transformed" in {
    val data = Seq(Ex(4, "a"), Ex(5, "b"))

    val specBuilder = Vegas()
      .withValues(data)(testValueTransformer)

    val expectedData = List(
      Map("x" -> "ok", "y" -> "ok"),
      Map("x" -> "ok", "y" -> "ok")
    )

    specBuilder.spec.data should === (Some(Data(
      values=Some( expectedData.map(Data.Values(_)) )
    )))
  }

}

