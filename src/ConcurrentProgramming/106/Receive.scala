/**
 * Created by larry on 9/17/15.
 * receive 和 receiveWithin
 * receive 接收一个函数值/闭包，返回一个处理消息的应答
 * receive会造成程序阻塞，直到实际接收到应答为止
 */

import scala.actors.Actor._

val caller = self

val accumulator = actor {
  var sum = 0
  var continue = true
  while (continue) {
    sum += receive {
      case number: Int => number
      case "quit" =>
        continue = false
        0
    }
  }
  caller ! sum
}

accumulator ! 1
accumulator ! 7
accumulator ! 8
accumulator ! "quit"

receive { case result => println("Total is " + result)}

/*
Total is 16
 */

