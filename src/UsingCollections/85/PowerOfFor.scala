/**
 * Created by larry on 9/5/15.
 * for 通用语法的简写形式：

for([pattern <- generator; definition*]+;filter*)
   [yield] expression

   for表达式接收的参数包括一个或多个生成器generator,
   0个或多个定义definition,
   还有0或多个过滤器filter。

   yeild 关键字是可选的，如果它存在的话，就表示表达式返回一组值而不是一个Unit
 */
for (i <- 1 to 3) { print("hi ") }
/*
hi hi hi 
*/

//取出一个范围内的值，每个值乘以2
val result = for (i <- 1 to 10)
  yield i * 2

//可以用map()方法执行上面的逻辑
val result2 = (1 to 10 ).map(_ * 2)

//只对范围内的偶数翻倍，使用过滤器
val doubleEven = for (i <- 1 to 10; if i % 2 ==0)
  yield i * 2
//可以用大括号代替括号
for { 
  i <- 1 to 10
  if i % 2 == 0
}
 yield i * 2


//多个生成器，则每个生成器都会形成一个内部循环，最右的生成器控制着最内的循环
for (i <- 1 to 3; j <- 4 to 6) {
  print("[" + i + "," + j + "]")
}
/*
[1,4][1,5][1,6][2,4][2,5][2,6][3,4][3,5][3,6]
*/


