package Projekt

import Projekt.Datareader.Datareader
import Projekt.Datawriter.Datawriter
import org.apache.spark.sql.SparkSession

object Main {
  val spark = SparkSession.builder.master("local[4]")
    .appName("Moja-applikacja")
    .getOrCreate();

  def main(args: Array[String]): Unit = {
    val actorsDf = Datareader.readActors("src\\Data\\actors.csv");
    val namesDf = Datareader.readNames("src\\Data\\names.csv");
    val actorsDf2 = actorsDf.filter(row => Transform.Transform.isComposer(row));
    val namesDf2 = namesDf.filter(row => Transform.Transform.isDivorced(row));
    actorsDf2.show();
    namesDf2.show();
    Datawriter.writedf(actorsDf2.toDF(), "result");
  }

}
