package vegas.sparkExt

import org.apache.spark.sql._
import org.apache.spark.sql.types.{DoubleType, IntegerType, StructField, StructType}
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import vegas._
import vegas.sparkExt.SparkExtSpec._
import vegas.spec.Spec.Data.Values

/**
  * Created by DB Tsai on 10/17/16.
  */
class SparkExtSpec extends FlatSpec with BeforeAndAfterAll with Matchers {
  import vegas.util.Time._

  @transient var sparkSession: SparkSession = _

  var largeDataDF: DataFrame = _
  var smallDataDF: DataFrame = _
  var complexDataDF: DataFrame = _

  override def beforeAll() {
    sparkSession = SparkSession.builder
      .master("local[*]")
      .appName("test")
      .config("spark.ui.enabled", false)
      .getOrCreate()

    largeDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize((1 to 20000).map { i =>
        val x = i / 20000.0
        val y = 1.5 * x + 3
        XYPair(x, y)
      }))

    smallDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize((1 to 235).map { i =>
        val x = i / 235.0
        val y = 1.5 * x + 3
        XYPair(x, y)
      }))

    complexDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize(Seq(
        Person("Bob", 35, None, Some(true), None, mkSqlTimestamp(1984, 12, 25, 23, 59, 0)),
        Person("Alice", 12, Some(1.12), None, Some(mkSqlDate(2015, 12, 25)), mkSqlTimestamp(1984, 12, 25, 23, 59, 0))
      )))

    super.beforeAll()
  }

  override def afterAll() {
    if (sparkSession != null) sparkSession.stop()
    super.afterAll()
  }

  "With large data as input, the result" should "be sampled to ~sparkExt.DefaultLimit number of records" in {
    val data = Vegas().withDataFrame(largeDataDF).spec.data.get.values.get
    assert((data.size - sparkExt.DefaultLimit) / sparkExt.DefaultLimit < 0.05, "data.size should be around 1k")

    data.foreach { case Values(point: Map[String, Double] @unchecked) =>
      val x = point("x")
      val y = point("y")
      y shouldEqual 1.5 * x + 3
    }
  }

  "With small data as input, the result" should "have all the input records" in {
    val data = Vegas().withDataFrame(smallDataDF).spec.data.get.values.get
    data.size shouldEqual 235

    data.map { case Values(point: Map[String, Double] @unchecked) =>
      XYPair(point("x"), point("y"))
    }.zip(1 to 235).foreach { case (pair, index) =>
      pair.x shouldEqual index / 235.0
      pair.y shouldEqual 1.5 * pair.x + 3
    }
  }

  "Data with nulls" should "preserve them" in {
    val nullDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize(Seq(Row(1, null), Row(null, 3.14))),
      StructType( StructField("a", IntegerType, true) :: StructField("b", DoubleType, true) :: Nil )
    )
    val data = Vegas().withDataFrame(nullDataDF).spec.data.get.values.get

    data.map { case Values(d: Map[String, Any] @unchecked) =>
      (d("a"), d("b"))
    } should === (Seq((1, null), (null, 3.14)))
  }

  "With complex data as input" should "encode it to the right types" in {
    val data = Vegas().withDataFrame(complexDataDF).spec.data.get.values.get

    data.map { case Values(d: Map[String, Any] @unchecked) =>
      (d("name"), d("age"), d("height"), d("employee"), d("birthday"), d("createdAt"))
    } should === (Seq(
      ("Bob", 35L, null, true, null, "1984-12-25T23:59:00"),
      ("Alice", 12L, 1.12, null, "2015-12-25", "1984-12-25T23:59:00")
    ))
  }

}

object SparkExtSpec {
  case class XYPair(x: Double, y: Double)
  case class Person(name: String, age: Long, height: Option[Double], employee: Option[Boolean],
                    birthday: Option[java.sql.Date], createdAt: java.sql.Timestamp)
}
