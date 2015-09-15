/**
 * Created by larry on 9/15/15.
 * Actor 类
 */
import scala.actors._
import Actor._

class AnsweringService(val folks: String*) extends Actor {//没有继承任何类，使用extends混入trait
  def act(): Unit = {
    while (true) {
      receive {
        case (caller: Actor,name: String,msg: String) =>
          caller ! (
            if(folks.contains(name))
              String.format("Hey it's %s got message %s",name, msg)
            else
              String.format("Hey there's no one with the name %s here.",name)
            )
        case "ping" => println("ping!")
        case "quit" => println("exiting actor")
      }
    }
  }
}

val answeringService = new AnsweringService("Sara","Kara","John")

//给actor发送了一些元组信息，不会立即得到处理，进入队列
answeringService ! (self,"Sara","In town")
answeringService ! (self,"Kara","Go shopping")

//只要调用了start方法就会有一个单独的线程调用actor的act方法
answeringService.start()

//再发送些消息
answeringService ! (self,"John","Bug fixed?")
answeringService ! (self,"Bill","What's up")

//循环接收对发出的四条消息的应答
for(i <- 1 to 4) { receive { case msg => println(msg)}}

answeringService ! "ping"
answeringService ! "quit"
answeringService
answeringService ! "ping"

Thread.sleep(2000)
println("The last ping was not processed")

/*
Hey it's Sara got messgae In town
Hey it's Kara got messgae Go shopping
Hey it's John got messgae Bug fixed?
Hey there's no one with the name Bill here.
ping!
exiting actor
ping! //同pdf不同，书上说明，调用exit()方法后，终止actor的执行
The last ping was not processed
 */