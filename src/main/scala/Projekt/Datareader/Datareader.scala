package Projekt.Datareader

import org.apache.spark.sql.{Dataset, SparkSession}
import Projekt.Case.Names
import Projekt.Case.Actors

object Datareader {

  def readNames( path: String): Dataset[Names] = {
    val spark = SparkSession.builder.master("local[4]")
      .appName("Moja-applikacja")
      .getOrCreate();
    import spark.implicits._;
    return spark.read.format("csv").option("header",true).option("delimiter", ";").load(path).as[Names]
  }
  def readActors(path: String): Dataset[Actors] = {
    val spark = SparkSession.builder.master("local[4]")
      .appName("Moja-applikacja")
      .getOrCreate()
    import spark.implicits._;
    return spark.read.format("csv").option("header",true).option("delimiter", ";").load(path).as[Actors]
  }
}