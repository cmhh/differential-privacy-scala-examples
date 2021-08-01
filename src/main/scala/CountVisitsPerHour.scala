package org.cmhh

import scala.collection.immutable.TreeMap
import com.google.privacy.differentialprivacy.Count

object CountVisitsPerHour extends App {
  val visits = IOUtils.readVisits("day_data.csv")

  IOUtils.writeVisits(getNonPrivateCounts(visits), "non_private_counts_per_hour.csv")
  IOUtils.writeVisits(getPrivateCounts(visits), "private_counts_per_hour.csv")

  def getNonPrivateCounts(visits: Visits): TreeMap[Int, Int] = 
    TreeMap[Int, Int]() ++ 
      visits
        .map(_.entryTime.getHour())
        .groupBy(identity)
        .map(x => (x._1, x._2.size)) 
  
  def getPrivateCounts(visits: Visits): TreeMap[Int, Int] = {
    val dpCounts = RestaurantSchedule.VALID_HOURS.map(hour => {
      (
        hour, 
        Count.builder().epsilon(math.log(3)).maxPartitionsContributed(1).build()
      )
    }).toMap

    visits.foreach(visit => {
      dpCounts.get(visit.entryTime.getHour()) match {
        case Some(c) => c.increment()
        case _ => 
      }
    })

    TreeMap[Int, Int]() ++ 
      dpCounts
        .map(x => (x._1, x._2.computeResult().toInt))
  }
}