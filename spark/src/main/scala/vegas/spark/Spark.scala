package vegas.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

/**
  * @author Aish Fenton.
  */
trait SparkExt {

  def withData(df: DataFrame) = {

  }

  def withData(df: RDD[Product]) = ???

}
