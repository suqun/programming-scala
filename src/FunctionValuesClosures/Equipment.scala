class Equipment(val routine : Int => Int) {
  def simulate(input: Int) = {
    print("Running sinulation...")
    routine(input)
  }
}

//use not DRY
val equipment1 = new Equipment({input => println("calc with " + input);input})
val equipment2 = new Equipment({input => println("calc with " + input);input})

equipment1.simulate(4)
equipment2.simulate(6)

//use DRY
val calculator = { input : Int => println("calc with " + input); input}

val equipment3 = new Equipment(calculator)
val equipment4 = new Equipment(calculator)

equipment3.simulate(4)
equipment4.simulate(6)

//use DRY 2

def calc(input: Int) = { println("calc with " + input); input}

val equipment5 = new Equipment(calc)
val equipment6 = new Equipment(calc)

equipment5.simulate(5)
equipment6.simulate(6)
