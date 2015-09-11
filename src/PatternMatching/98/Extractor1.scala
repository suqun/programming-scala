object Symbol {
  def unapply(symbol:String) : Boolean = symbol == "GOOG" || symbol == "IBM    "
}
  

object StockService {
  def process(input: String){
    input match {
      case Symbol() => println("Look up price for valid symbol " + input)
      case _ => println("Invalid input " + input)
    }
  }
}

StockService process "GOOG"
StockService process "IBM"
StockService process "ERR"



