/**
 * Scala虽然提供了可变的(mutable)容器，但它更倾向于使用不可变的(immutable)容器
 * 默认下用的不可变的
 * Set 草错详见API：http://docs.scala-lang.org/zh-cn/overviews/collections/sets.html
 */

//1、从一个具有三个颜色的Set，添加黑色，并不会修改原有的set，而是得到一个新的四个元素的Set
val colors1 = Set("Blue","Green","Red")
var colors = colors1
println("colors1(colors): " + colors)

colors += "Black"
println("colors: " + colors)
println("colors1: " + colors1)
/**
 * 结果
   colors1(colors): Set(Blue, Green, Red)
   colors: Set(Blue, Green, Red, Black)
   colors1: Set(Blue, Green, Red)
 */



