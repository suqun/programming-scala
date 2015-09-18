/**
 * Created by larry on 9/18/15.
 * 关于receive和receiveWithin,它们不会浪费时间在它们不关心的消息上
 * 这些方法把函数值当作偏应用函数，调用代码块之前，会检查它是否处理信息。
 * 如果接收到一个非预期消息，就会悄悄的忽略它。
 * 如果想把忽略的信息显示出来，可以提供case _ => ...语句
 */
import scala.actors._
import Actor._

val expectStringOrInteger = actor {
  for( i <- 1 to 4)  {
    receiveWithin(1000) {
      case str: String => println("You said " + str)
      case num: Int => println("You gave " + num)
      case TIMEOUT => println("Time out!!!")
    }
  }
}

expectStringOrInteger ! "Only constant is change"
expectStringOrInteger ! 1024
expectStringOrInteger ! 22.11
expectStringOrInteger ! (self,1024)

//代码的最后，放了一个receiveWithin的调用。因为主线程退出时，程序就退出了，
// 这个语句会保证程序还活动着，给actor一个应答的机会。从输出中可以看出，
//actor处理了前两个发送他的消息，忽略了后两个，因为它们没有匹配上预期的
//模式。程序最终会超时，因为没有再接收到任何可以匹配的消息。
receiveWithin(3000) { case _ => }

/*
You said Only constant is change
You gave 1024
Time out!!!
Time out!!!
 */