package vegas.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

import vegas.DSL._

/**
  * @author Aish Fenton.
  */

object Spark {

  implicit class SparkExt(val specBuilder: SpecBuilder) {

    def withData(df: DataFrame, limit: Int = 1000) = {
      val columns: Array[String] = df.columns
      val counts: Double = df.count
      val localData = {
        if (counts >= limit) df.sample(false, limit / counts).collect() else df.collect()
      }.map { row => row.toSeq.map(_.toString) }.toSeq

      val data = localData.map { point =>
        columns.zip(point).map { case (name, value) => name -> value }.toMap
      }
      specBuilder.withData(data: _*)
    }

    def withData(df: RDD[Product]) = ???

  }

}
