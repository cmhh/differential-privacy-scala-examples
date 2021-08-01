package org.cmhh

import java.time.{LocalTime, DayOfWeek}
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.util.Locale
import java.io.{PrintWriter, File}
import scala.collection.immutable.TreeMap
import scala.io.Source
import scala.util.{Try, Success, Failure}

object IOUtils {
  def readDailyVisits(file: String): Visits = readVisits(file)
  def readWeeklyVisits(file: String): VisitsForWeek = readVisits(file).groupBy(_.day)

  def readVisits(file: String): Visits = {
    val bs = Source.fromResource(file)
    bs.getLines().toList.drop(1).map(x => {
      val split = x.split(',')
      Visit(
        split(0),
        LocalTime.parse(split(1), timeFormatter),
        split(2).toInt,
        split(3).toInt,
        DayOfWeek.of(split(4).toInt)
      )
    })
  }

  def writeVisits[T](data: TreeMap[T, Int], file: String): Try[Unit] = Try {
    val pw = new PrintWriter(new File(file))
    data.foreach(rec => {
      pw.write(s"${rec._1.toString},${rec._2.toString}\n")
    })
    pw.close
  }

  private val timeFormatter = new DateTimeFormatterBuilder()
    .parseCaseInsensitive()
    .appendPattern("h:mm:ss a")
    .toFormatter(Locale.ENGLISH)
}