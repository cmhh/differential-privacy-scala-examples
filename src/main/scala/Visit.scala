package org.cmhh

import java.time.{LocalTime, DayOfWeek}

case class Visit(
  visitorId: String, entryTime: LocalTime, minutesSpent: Int, eurosSpent: Int, day: DayOfWeek
)