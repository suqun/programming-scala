import java.util._

var list1 = new ArrayList[Int]
var list2 = new ArrayList[Any]

var ref1 : Int = 1
var ref2 : Any = null

ref2 = ref1 //OK
list2 = list1 //Compilation Error
