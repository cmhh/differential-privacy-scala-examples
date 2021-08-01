package org.cmhh

object ContributionBoundingUtils {
  def boundContributedDays(visits: Visits, maxContributedDays: Int): Visits = 
    visits.groupBy(_.visitorId).flatMap(x => sample(x._2, maxContributedDays)).toList

  def sample[T](xs: Seq[T], n: Int): Seq[T] = {
    if (xs.size <= n) xs
    else {
      shuffle(xs).take(n)
    }
  }

  def shuffle[T](xs: Seq[T]): Seq[T] = 
    xs
      .zip((1 to xs.size).map(i => scala.util.Random.nextDouble()))
      .sortBy(_._2)
      .map(_._1)
}