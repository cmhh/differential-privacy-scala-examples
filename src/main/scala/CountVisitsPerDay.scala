package org.cmhh

import scala.collection.immutable.TreeMap
import com.google.privacy.differentialprivacy.Count
import java.time.DayOfWeek

object CountVisitsPerDay extends App {
  val MAX_CONTRIBUTED_DAYS = 3
  val visits: Visits = IOUtils.readVisits("week_data.csv")

  IOUtils.writeVisits(getNonPrivateCounts(visits), "non_private_counts_per_day.csv")
  IOUtils.writeVisits(getPrivateCounts(visits), "private_counts_per_day.csv")

  def getNonPrivateCounts(visits: Visits): TreeMap[DayOfWeek, Int] = 
    TreeMap[DayOfWeek, Int]() ++ 
      visits
        .map(_.day)
        .groupBy(identity)
        .map(x => (x._1, x._2.size)) 
  
  def getPrivateCounts(visits: Visits): TreeMap[DayOfWeek, Int] = {
    val boundedVisits = 
      ContributionBoundingUtils.boundContributedDays(visits, MAX_CONTRIBUTED_DAYS)

    val dpCounts = DayOfWeek.values().toList.map(day => {
      (
        day, 
        Count.builder()
          .epsilon(math.log(3))
          .maxPartitionsContributed(MAX_CONTRIBUTED_DAYS)
          .build()
      )
    }).toMap

    boundedVisits.foreach(visit => {
      dpCounts.get(visit.day) match {
        case Some(c) => c.increment()
        case _ => 
      }
    })

    TreeMap[DayOfWeek, Int]() ++ 
      dpCounts
        .map(x => (x._1, x._2.computeResult().toInt))
  }
}