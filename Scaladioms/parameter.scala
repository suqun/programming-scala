def max(values: Int*) = values.foldLeft(values(0)) {Math.max}

println(max(2,4,6,1,9,3))

val numbers = Array(2,4,6,1,9,3)

println(max(numbers:_*))
