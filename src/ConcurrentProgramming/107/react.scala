/**
 * Created by larry on 9/19/15.
 * react
 */
import scala.actors.Actor._

def info(msg: String) = println(msg + "received by " + Thread.currentThread())

def receiveMessage(id: Int): Unit = {
  for(i <- 1 to 2) {
    receiveWithin(20000) {
      case msg : String => info("receive: " + id + msg)
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
  actor { info("react: 1 actor created");reactMessage(1)},
  actor { info("react: 2 actor created");reactMessage(2)},
  actor { info("receive: 3 actor created");receiveMessage(3)},
  actor { info("receive: 4 actor created");receiveMessage(4)}
)

Thread.sleep(1000)
for(i <- 0 to 3) {
  actors(i) ! " hello "; Thread.sleep(2000)
}
Thread.sleep(2000)
for(i <- 0 to 3) {
  actors(i) ! " hello "; Thread.sleep(2000)
}