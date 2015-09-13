
/**
 * Created by larry on 9/13/15.
 * 在一个范围内查找完全数
 */
def countPerfecNumbersInRange(start : Int, end: Int,
                               isPerfectFinder: Int => Boolean): Unit ={
  val startTime = System.nanoTime()
  val numberOfPerfectNumbers = ( 0 /: (start to end)) { (count, candicate) =>
    if (isPerfectFinder(candicate)) count + 1 else count
  }
  val endTime = System.nanoTime()

  println("Fond " + numberOfPerfectNumbers + " perfect numbers in given range, took " +
    (endTime - startTime)/1000000000.0 + " secs"
  )
}

val startNumber = 33550300
val endNumber = 33550400

countPerfecNumbersInRange(startNumber,endNumber,isPerfect)
countPerfecNumbersInRange(startNumber,endNumber,isPerfectConcurrent)