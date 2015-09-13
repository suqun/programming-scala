import scala.actors._
import Actor._
/**
 * Created by larry on 9/13/15.
 * 同步发送消息接收响应，使用 !?() 方法
 * 在接收消息的目标actor给出响应前，会一直阻塞，会引起潜在的死锁。
 * 如果要用这个方法，需要使用超时参数
 */

val fortuneTeller = actor {
  for(i <- 1 to 4) {
    Thread.sleep(1000)
    receive {
      case _ => sender ! "your day will rock! " + i
        //case _ => reply("your day will rock! " + i)//same as above
    }
  }
}

println(fortuneTeller !? (2000, "what's ahead"))
println(fortuneTeller !? (500, "what's ahead"))

val aPrinter = actor {
  receive { case msg => println("Ah, fortune message for you-" + msg)}
}

fortuneTeller.send("what's up",aPrinter)

fortuneTeller ! "how's my future"

Thread.sleep(3000)
receive { case msg : String => println("Recevied " + msg)}

println("Let's get that lost message")
receive {
  case !(channel,msg) => println("Received belated message " + msg)
}

/*
Some(your day will rock! 1)
None
Ah, fortune message for you-your day will rock! 3
Recevied your day will rock! 4
Let's get that lost message
Received belated message your day will rock! 2
 */