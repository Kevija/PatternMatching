import scala.io.StdIn.readLine

object PatternMatchingExercise extends App {

    def getDay(day: Int): String = day match{
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"
      case _ => "Unknown Weekday"
    }

    def getDayType(day: String): String = {
      day.capitalize match {
        case "Monday" | "Tuesday" | "Wednesday" | "Tuesday" | "Friday" => "Workday"
        case "Saturday" | "Sunday" => "Weekend"
        case _ => "Groundhog Day"
      }
    }

    val dayNumber = readLine("Insert the number of weekday: \n").toInt
    println(getDay(dayNumber))

    val day = readLine("Write a weekday: \n")
    println(s"It's a ${getDayType(day)}!")

  }