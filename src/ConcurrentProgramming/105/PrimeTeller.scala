/**
 * Created by larry on 9/16/15.
 * actor 方法
 */
import scala.actors._
import Actor._

def isPrime(number: Int) = {
  println("Going to find if " + number + " is prime")

  var result = true

  if(number == 2 || number ==3 ) result = true

  for(i <- 2 to Math.sqrt(number.toDouble).floor.toInt; if result) {
    if(number % i == 0) result = false
  }

  println("done finding if " + number + " is prime")
  result
}
//上面这段代码，接收应答之前，就会堵塞在那里。把调用这个方法的职责委托给一个actor。
//这个actor会确定一个数是否是素数，然后，用一个异步响应发回给调用者

val primeTeller = actor{
  var continue = true
  while (continue) {
    receive {
      //case (caller : Actor,number: Int) => caller ! (number,isPrime(number))
      case (caller: Actor,number: Int) => actor{//委托给另一个actor，进行并发处理
        caller ! (number,isPrime(number))
      }
      case "quit" => continue = false
    }
  }
}
//primeTeller是一个引用，指向了用actor方法创建的一个匿名actor。他会不断循环，直到接收quit信息。
//除了退出信息，还能接收一个包含caller和number的元组，收到这个消息时，会判断给定的数是否是素数，然后
//给caller发回一个消息
primeTeller ! (self,2)
primeTeller ! (self,131)
primeTeller ! (self,132)

for (i <- 1 to 3) {
  receive {
    case (number,result) => println(number + " is prime? " +result)
  }
}

primeTeller ! "quit"

/*
case (caller : Actor,number: Int) => caller ! (number,isPrime(number))

Going to find if 2 is prime
done finding if 2 is prime
Going to find if 131 is prime
2 is prime? true
done finding if 131 is prime
Going to find if 132 is prime
131 is prime? true
done finding if 132 is prime
132 is prime? false

case (caller: Actor,number: Int) => actor{
        caller ! (number,isPrime(number))
      }

Going to find if 131 is prime
done finding if 131 is prime
Going to find if 132 is prime
131 is prime? true
done finding if 132 is prime
132 is prime? false
Going to find if 2 is prime
done finding if 2 is prime
2 is prime? true
 */