//carry

def inject(arr: Array[Int], initial: Int)(operation: (Int, Int) => Int) :
  Int {
    var carryOver = initial
    arr.foreach(element => carryOver = operation(carryOver,element))
    carryOver
  }

val array = Array(2,3,4,1,6,4)
val sum = inject(array,0) { (carryOver,elem) => carryOver + elem}
println("Sum of elements in array " + array.toString() + " is " + sum)
