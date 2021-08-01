package org.cmhh

import scala.util.{Try, Success, Failure}

object Main extends App {
  println()
  println("1 -> count visits per hour from daily data")
  println("2 -> count visits per day from weekly data")
  println()
  print("Make a selection (1 to 2): ")

  val selection = Try { scala.io.StdIn.readLine().toInt }

  selection match {
    case Success(x) => x match {
      case 1 => CountVisitsPerHour.main(Array())
      case 2 => CountVisitsPerDay.main(Array())
      case _ => println("\nInvalid selection.")
    }
    case Failure(e) => println(s"\nInvalid selection.")
  }
}