/*
  case表达式的模式变量和常量
  
  按照约定，Scala中模式变量要以小写字母开头，常量要以大写字母开头
*/

class Sample {
  val max = 100
  val MIN = 0

  def process(input: Int) {
    input match {
     // case max => println("Don't try this at home")//无法编译通过，Scala会假设max是一个模式变量
      case this.max => println("You matched max")//可以显示的指定作用域
      case MIN => println("You matched MIN")
      case _ => println("Unmatched")
    }
  }
} 
  
new Sample().process(100)
new Sample().process(0)
new Sample().process(10)
/*
You matched max
You matched MIN
Unmatched
*/
