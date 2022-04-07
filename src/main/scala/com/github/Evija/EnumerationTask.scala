package com.github.Evija

import com.github.Evija.Days.WeekDay

object Days extends Enumeration {
  type WeekDay = Value
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

object EnumerationTask extends App {

  def isWeekDay(oneDay: WeekDay):Boolean = {
    oneDay == Days.Monday |
      oneDay == Days.Tuesday |
      oneDay == Days.Wednesday |
      oneDay == Days.Thursday|
      oneDay == Days.Friday |
      oneDay == Days.Saturday|
      oneDay == Days.Sunday

  }

  println(isWeekDay(Days.Wednesday))
  
}

