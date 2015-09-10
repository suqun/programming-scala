/*
创建一个字符串，调用了r()方法，得到一个Regex的实例。
当正则表达式需要转义字符，用原始字符串 """\d2:\d2:\d4"""
findFirstIn找到正则表达式的第一个匹配
*/
val pattern = "(S|s)cala".r
val str = "Scala is scalable and cool"
println(pattern findFirstIn str)
/*
Some(Scala)
*/

//findAllIn()找所有出现的地方，返回一个由匹配单词组成的容器
//本例子返回(Scala,scala)
println((pattern findAllIn str).mkString(","))
/*
Scala,scala
*/

//replaceFirstIn()替换第一个匹配，replaceAllIn()替换所有匹配的字符串
println("cool".r replaceFirstIn(str,"awesome"))
/*
Scala is scalable and awesome
*/

