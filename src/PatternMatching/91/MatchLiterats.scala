/**
* 匹配字面量和常量
*
*/

def activity(day: String) {
  day match {
    case "Sunday" => println("Eat,sleep,repeat...")
    case "Saturday" => println("Hangout with friends...")
    case "Monday" => println("...code for fun ...")
    case "Friday" => println("...read a good book...")
  }
}

List("Monday","Sunday","Saturday").foreach{activity}

/*
...code for fun ...
Eat,sleep,repeat...
Hangout with friends...
*/

