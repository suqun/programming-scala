/**
 * Created by larry on 9/18/15.
 * receiveWithin
 */

import scala.actors._
import scala.actors.Actor._

val caller = self

val accumulator = actor {
  var sum = 0
  var continue = true
  while(continue) {
    sum += receiveWithin(1000) {
      case number: Int => number
      case TIMEOUT =>
        println("Time out ! Will return result now")
        continue = false
        0
    }
  }
  caller ! sum
}

accumulator ! 1
accumulator ! 7
accumulator ! 8

//在给定的超时期限内，如果什么都没收到，receiveWithin方法会收到一个TIMEOUT
//消息，如果不对其进行模式匹配，就会抛出异常。下面的代码里，接收到TIMEOUT消息
// 当作了完成值累计的信号
receiveWithin(10000) {case result => println("Total is " + result)}
/*
Time out ! Will return result now
Total is 16
 */