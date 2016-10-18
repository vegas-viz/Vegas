package vegas.sparkExt

import org.apache.spark.sql._
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import vegas._
import vegas.sparkExt.SparkExtSpec.XYPair
import vegas.spec.Spec.Data.Values

/**
  * Created by DB Tsai on 10/17/16.
  */
class SparkExtSpec extends FlatSpec with BeforeAndAfterAll with Matchers {
  @transient var sparkSession: SparkSession = _

  var largeDataDF: DataFrame = _
  var smallDataDF: DataFrame = _

  override def beforeAll() {
    sparkSession = SparkSession.builder
      .master("local[2]")
      .appName("test")
      .getOrCreate()

    largeDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize((1 to 2000).map { i =>
        val x = i / 2000.0
        val y = 1.5 * x + 3
        XYPair(x, y)
      }))

    smallDataDF = sparkSession.sqlContext.createDataFrame(
      sparkSession.sparkContext.parallelize((1 to 235).map { i =>
        val x = i / 235.0
        val y = 1.5 * x + 3
        XYPair(x, y)
      }))

    super.beforeAll()
  }

  override def afterAll() {
    if (sparkSession != null) sparkSession.stop()
    super.afterAll()
  }

  "With large data as input, the result" should "be sampled to around 1k records" in {
    val data = Vegas().withDataFrame(largeDataDF).spec.data.get.values.get
    assert((data.size - 1000.0) / 1000 < 0.05, "data.size should be around 1k")

    data.foreach { case Values(point: Map[String, String]) =>
      val x = point.get("x").get.toDouble
      val y = point.get("y").get.toDouble
      y shouldEqual 1.5 * x + 3
    }
  }

  "With small data as input, the result" should "have all the input records" in {
    val data = Vegas().withDataFrame(smallDataDF).spec.data.get.values.get
    data.size shouldEqual 235

    data.map { case Values(point: Map[String, String]) =>
      XYPair(point.get("x").get.toDouble, point.get("y").get.toDouble)
    }.zip(1 to 235).foreach { case (pair, index) =>
      pair.x shouldEqual index / 235.0
      pair.y shouldEqual 1.5 * pair.x + 3
    }
  }
}

object SparkExtSpec {

  case class XYPair(x: Double, y: Double)

}
