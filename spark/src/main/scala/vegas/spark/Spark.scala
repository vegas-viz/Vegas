package vegas.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

import vegas.DSL._
import vegas.DSL.DataDSL

object Spark {

  implicit class SparkExt(val specBuilder: DataDSL[_]) {

    def withDataFrame(df: DataFrame, limit: Int = 1000) = {
      val columns: Array[String] = df.columns
      val count: Double = df.count
      val localData = {
        if (count >= limit) df.sample(false, limit / count).collect() else df.collect()
      }.map { row => row.toSeq.map(_.toString) }.toSeq

      val data = localData.map { point =>
        columns.zip(point).map { case (name, value) => name -> value }.toMap
      }
      specBuilder.withData(data)
    }

    def withRDD(rdd: RDD[Product], limit: Int = 1000) = {
      val count = rdd.count
      val localData: Array[Product] = {
        if (count >= limit) rdd.sample(false, limit / count).collect() else rdd.collect()
      }
      specBuilder.withCaseClasses(localData)
    }

  }

}
