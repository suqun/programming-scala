/*
  判断是否为完全数:一个正整数，其因子之和是该数的2倍
*/
def sumOfFactors(number: Int) = {
  (0 /: (1 to number)) { (sum, i) => if (number % i == 0) sum + i else sum }
}

def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors(candidate)

val startTime = System.nanoTime()
println("6 is perfect? " + isPerfect(6))
println("33550336 is perfect? " + isPerfect(33550336))
println("33550337 is perfect? " + isPerfect(33550337))
val endTime = System.nanoTime()
println("perfect numbers in given range, took " +
  (endTime - startTime)/100000000.0 + " secs"
)
/*
6 is perfect? true
33550336 is perfect? true
33550337 is perfect? false
perfect numbers in given range, took 10.35432489 secs
*/

