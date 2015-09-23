/**
 * Created by larry on 9/23/15.
 * 类似于receiveWhitin，在超时时段里，没有接收到任何消息，reactWithin
 * 就会超时
 */

import scala.actors._
import Actor._

val caller = self

def accumulate(sum: Int): Unit = {
  reactWithin(500) {
    case number: Int => accumulate(sum + number)
    case TIMEOUT =>
      println("Time out ! Will send result now ")
      caller ! sum
  }
  //react和reactWithin，并不是真的从调用里返回，放在这些方法后的代码不会执行
  println("This will not be called...")
}

val accumulator = actor {
  accumulate(0)
}

accumulator ! 1
accumulator ! 7
accumulator ! 8

receiveWithin(10000) { case result => println("Total is " + result) }
