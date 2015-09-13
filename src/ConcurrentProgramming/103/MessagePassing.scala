import scala.actors.Actor._
/*
   消息传递
 */

var startTime : Long = 0
val caller = self

val engrossedActor = actor {
  println("Number of messages received so far? " + mailboxSize)
  caller ! "send"
  Thread.sleep(3000)
  println("Number of messages received while I was busy? " + mailboxSize)
  receive {
    case msg =>
      val receivedTime = System.currentTimeMillis() - startTime
      println("Received message " + msg + " after " + receivedTime + " ms")
  }
  caller ! "received"
}

receive { case _ =>}

println("Sending Message")
startTime = System.currentTimeMillis()
engrossedActor ! "hello buddy"
val endTime = System.currentTimeMillis() - startTime

printf("Took less than %d ms to send message\n",endTime)

receive {
  case _ =>
}
/*
Number of messages received so far? 0
Sending Message
Took less than 0 ms to send message
Number of messages received while I was busy? 0 //书上此处为1 ？？？
Received message hello buddy after 3001 ms
从输出可以看出，发送不阻塞，接收不中断。在actor调用receive()方法接收之前，消息会一直等在那里
 */