/**
 * 匹配枚举，匹配通配符 _
 */
object DayOfWeek extends Enumeration {
  val SUNDAY = Value("Sunday")
  val MONDAY = Value("Monday")
  val TUESDAY = Value("Tuesday")
  val WEDNESDAY = Value("Wednesday")
  val FRIDAY = Value("Friday")
  val SATURDAY = Value("Saturday")
}

def activity(day: DayOfWeek.Value) {
  day match {
    case DayOfWeek.SUNDAY => println("Eat,sleep,repeat...")
    case DayOfWeek.SATURDAY => println("Hangout with friends")
    case _ => println("....code for fun ....")
  }
}

activity(DayOfWeek.SATURDAY)
activity(DayOfWeek.MONDAY)

/*
Hangout with friends
....code for fun ....
*/


