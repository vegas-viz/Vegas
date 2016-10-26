package vegas

import org.apache.spark.sql.DataFrame
import vegas.DSL.DataDSL

package object sparkExt {

  val DefaultLimit = 10000

  implicit class VegasSpark[T](val specBuilder: DataDSL[T]) {

    def withDataFrame(df: DataFrame, limit: Int = DefaultLimit): T = {
      val columns: Array[String] = df.columns
      val count: Double = df.count
      val data = {
        if (count >= limit) df.sample(false, limit / count).collect() else df.collect()
      }.map { row =>
        columns.zipWithIndex.map { case (name: String, index: Int) =>
          // We should be able to pass in the required columns into here, so we don't need
          // to create a map containing all the columns.
          val value = row.get(index)
          name -> value
        }.toMap
      }
      specBuilder.withData(data)
    }
  }

}
