def totalResultOverRange(number: Int, codeBlock: Int => Int) : Int = {
  var result = 0
  for (i <- 1 to number) {
    result += codeBlock(i)
  }
  result
}

println(totalResultOverRange(11,i => i))

println(totalResultOverRange(11,i => if (i % 2 == 0) 1 else 0))

println(totalResultOverRange(11,i => if (i % 2 != 0) 1 else 0))
