def process(input: String) {
  val GoogStock = """^GOOG:(\d*\.\d+)""".r
  input match {
    case GoogStock(price) => println("Price of GOOG is " + price)
    case _ => println("not processing " + input)
  }
}

process("GOOG:310.84")
process("GOOG:310")
process("IBM:84.01")
/*
Price of GOOG is 310.84
not processing GOOG:310
not processing IBM:84.01
*/
