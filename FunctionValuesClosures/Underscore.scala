val arr = Array(1,2,3,4,5)

println("Sum of all values in array is " + 
  (0 /: arr) { (sum,elem) => sum + elem}
)

println("Sum of all values in array is " +
  (0 /: arr) { _ + _}
)


val negativeNumberExists = arr.exists{ _ < 0}
println("Array has negative number? " + negativeNumberExists)


def max2(a: Int, b: Int) : Int = if(a>b) a else b

var max = (Integer.MIN_VALUE /: arr) { (large,elem) => max2(large,elem)}
println(max)
max = (Integer.MIN_VALUE /: arr) {max2(_,_)}
println(max)
max = (Integer.MIN_VALUE /: arr) {max2 _}
println(max)
max = (Integer.MIN_VALUE /: arr) {max2}
println(max)

