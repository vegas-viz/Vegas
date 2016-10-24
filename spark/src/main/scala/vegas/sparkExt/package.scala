package vegas

import org.apache.spark.sql.DataFrame
import vegas.DSL.DataDSL

package object sparkExt {

  implicit class VegasSpark[T](val specBuilder: DataDSL[T]) {

    def withDataFrame(df: DataFrame, limit: Int = 1000): T = {
      val columns: Array[String] = df.columns
      val count: Double = df.count
      val localData = {
        if (count >= limit) df.sample(false, limit / count).collect() else df.collect()
      }.map { row => row.toSeq.map { value => if (value != null) value.toString else "null" } }.toSeq

      val data = localData.map { point =>
        columns.zip(point).map { case (name, value) => name -> value }.toMap
      }

      specBuilder.withData(data)
    }
  }

}
