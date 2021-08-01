package org 

import java.time.DayOfWeek

package object cmhh {
  type Visits = List[Visit]
  type VisitsForWeek = Map[DayOfWeek, Visits]
}