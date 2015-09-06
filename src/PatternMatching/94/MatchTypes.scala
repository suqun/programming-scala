/*
类型和guard的匹配
guard用if从句表示，在模式匹配中，对表达式的求值必须满足guard。
case的顺序很重要。Scala会自上而下的求值。所以，下面代码10，11行是不能交换的。
*/
def process(input: Any) {
  input match {
    case (a:Int,b:Int) => println("Processing (int,int)...")
    case (a:Double,b:Double) => println("Processing (double,double)...")
    case msg: Int if(msg >1000000) => println("Processing int > 1000000")
    case msg: Int => println("Processing int...")
    case msg: String => println("Processing string...")
    case _ => printf("Can't handle %s...",input)
  }
}

process((34.2,-159.3))
process(0)
process(10000001)
process(2.2)
/*
Processing (double,double)...
Processing int...
Processing int > 1000000
Can't handle 2.2...l
*/



