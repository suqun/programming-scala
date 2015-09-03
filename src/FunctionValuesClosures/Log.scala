import java.util.Date

def log(data: Date, message: String) {
  println(date + "-----" + message)
}

val date = new Date
log(date,"message1")
log(date,"message2")
log(date,"message3")

//偏应用函数，date绑定，使用_使第二个参数未绑定
val logWithDateBound = log(date, _: String)
logWithDateBound("message1")
logWithDateBound("message2")
logWithDateBound("message3")
