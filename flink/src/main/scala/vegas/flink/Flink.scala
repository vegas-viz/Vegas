package vegas.flink

import org.apache.flink.api.scala._
import vegas.DSL.{DataDSL, _}

/**
  * Created by ASRagab on 8/18/16.
  */
object Flink {

  implicit class FlinkExt(val specBuilder: DataDSL[_]) {

    def withData[T <: Product](ds: DataSet[T], limit: Int = 1000) = {
      val count = ds.count()
      val localData: Seq[T] = {
        if (count >= limit) ds.first(limit).collect() else ds.collect()
      }

      specBuilder.withCaseClasses(localData)
    }

  }

}
