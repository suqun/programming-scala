import scala.actors.Actor._

/**
 * Created by larry on 9/13/15.
 * 将因子求和的计算划分到多线程上
 */
def sumOfFactorsInRange(lower: Int, upper: Int, number: Int) = {
  (0 /: (lower to upper)) { (sum,i) => if (number % i == 0) sum + i else sum}
}

def isPerfectConcurrent(candicate: Int) = {
  val RANGE = 1000000
  val numberOfPartisions = (candicate.toDouble / RANGE).ceil.toInt
  val caller = self

  for (i <- 0 until numberOfPartisions) {
    val lower = i * RANGE +1
    val upper = candicate min (i + 1) * RANGE

    //因子部分的求和运算委托给单独的actor
    actor {
      //actor完成分配的任务，把部分和作为消息发送给调用者caller。在这个闭包里，caller变量绑定到
      //isPerfectConcurrent()方法里的一个变量上——这个变量持有actor的引用，通过调用self方法得到的，表示主线程
      caller ! sumOfFactorsInRange(lower,upper,candicate)
    }
  }

  val sum = (0 /: (0 until numberOfPartisions)) { (partialSum,i) =>
    receive {//从委托的actor中接收信息，一次一个，用foldLeft（/:）方法接收了所有的部分和，计算部分和的总和。
      case sumInRange : Int => partialSum + sumInRange
    }
  }

  2 * candicate == sum
}

val startTime = System.nanoTime()
println("6 is perfect? " + isPerfectConcurrent(6))
println("33550336 is perfect? " + isPerfectConcurrent(33550336))
println("33550337 is perfect? " + isPerfectConcurrent(33550337))
val endTime = System.nanoTime()
println("perfect numbers in given range, took " +
  (endTime - startTime)/100000000.0 + " secs"
)
/*
6 is perfect? true
33550336 is perfect? true
33550337 is perfect? false
perfect numbers in given range, took 5.46528328 secs
 */