package org.cmhh

object RestaurantSchedule {
  val OPENING_HOUR = 9
  val CLOSING_HOUR = 20
  val NUM_OF_WORK_HOURS = CLOSING_HOUR - OPENING_HOUR + 1
  val VALID_HOURS = OPENING_HOUR to CLOSING_HOUR
}