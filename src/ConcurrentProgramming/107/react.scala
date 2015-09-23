/**
 * Created by larry on 9/19/15.
 * react
 */
import scala.actors.Actor._
import scala.actors._

def info(msg: String) = println(msg + "received by " + Thread.currentThread())

def receiveMessage(id: Int): Unit = {
  for(i <- 1 to 2) {
    receiveWithin(20000) {
      case msg : String => info("receive: " + id + msg)
      case TIMEOUT => println("TIMEOUT")
    }
  }
}

def reactMessage(id: Int ): Unit = {
  react {
    case msg : String => info("react: " + id + msg )
      reactMessage(id)
  }
}

val actors = Array(
  actor { info("react: 1 actor created ");reactMessage(1)},
  actor { info("react: 2 actor created ");reactMessage(2)},
  actor { info("receive: 3 actor created ");receiveMessage(3)},
  actor { info("receive: 4 actor created ");receiveMessage(4)}
)

Thread.sleep(1000)
for(i <- 0 to 3) {
  actors(i) ! " hello "; Thread.sleep(2000)
}
Thread.sleep(2000)
for(i <- 0 to 3) {
  actors(i) ! " hello "; Thread.sleep(2000)
}
//使用receiveWithin的actor具有线程关联性，它们会持续的使用分配给他们的同一个线程
//react的actor可以彼此自由的交换线程，可以由任何可用的线程处理，react的actor不具有线程关联性
//它们会放弃自己的线程，用一个新的线程（或许是同一个线程）进行后续的消息处理
/*
react: 1 actor created received by Thread[ForkJoinPool-1-worker-13,5,main]
react: 2 actor created received by Thread[ForkJoinPool-1-worker-11,5,main]
receive: 3 actor created received by Thread[ForkJoinPool-1-worker-13,5,main]
receive: 4 actor created received by Thread[ForkJoinPool-1-worker-9,5,main]
react: 1 hello received by Thread[ForkJoinPool-1-worker-7,5,main]
react: 2 hello received by Thread[ForkJoinPool-1-worker-7,5,main]
receive: 3 hello received by Thread[ForkJoinPool-1-worker-13,5,main]
receive: 4 hello received by Thread[ForkJoinPool-1-worker-9,5,main]
react: 1 hello received by Thread[ForkJoinPool-1-worker-7,5,main]
react: 2 hello received by Thread[ForkJoinPool-1-worker-7,5,main]
receive: 3 hello received by Thread[ForkJoinPool-1-worker-13,5,main]
receive: 4 hello received by Thread[ForkJoinPool-1-worker-9,5,main]
 */