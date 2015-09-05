/**
 * Created by larry on 9/4/15.
 * List操作
 * API: http://www.scala-lang.org/api/current/#scala.collection.immutable.List
 */

val feeds = List("blog.toolshed.com","pragdave.pragprog.com","dimsumthinking.com/blog")

//1. 用0到list.length-1之间的索引访问List的元素
println("First feed: " + feeds.head)
println("Second feed: " + feeds(1))
/*
First feed: blog.toolshed.com
Second feed: pragdave.pragprog.com
*/

//2. List前面添加元素，可以使用::(), a :: list 可以读作“在list前面添加a”
// ::(x: A): List[A]
// Example:
// 1 :: List(2, 3) = List(2, 3).::(1) = List(1, 2, 3)
val prefixedList = "forums.pragprog.com/forums/87" :: feeds
println("First feed in prefixed : " + prefixedList.head)

//3. listA的前面添加list list ::: listA
//:::(prefix: List[A]): List[A] 
//Example:
//List(1, 2) ::: List(3, 4) = List(3, 4).:::(List(1, 2)) = List(1, 2, 3, 4)
val feedsWithForums = 
  feeds ::: List("forums.pragprog.com/forums/87","forums.pragprog.com/forums/55")
println("First feed in feeds wiht forums: " + feedsWithForums.head)
println("Last feed in fedds wiht forums: " + feedsWithForums.last)
/*
First feed in feeds wiht forums: blog.toolshed.com
Last feed in fedds wiht forums: forums.pragprog.com/forums/55
*/

//4. filter()选择出满足条件的元素，
//   forall()检查是否所有的元素都满足某一条件
//   exists()检查是否存在满足特定条件
println("Feeds with blog: " + feeds.filter(_ contains "blog").mkString(","))
println("All feeds hava com: " + feeds.forall(_ contains "com"))
println("All feeds have dave: " + feeds.forall(_ contains "dave"))
println("Any feeds has dave: " + feeds.exists(_ contains "dave"))
println("Any feeds has bill: " + feeds.exists(_ contains "bill"))
/*
All feeds hava com: true
All feeds have dave: false
Any feeds has dave: true
Any feeds has bill: false
*/

//5. map() 
//   map[B](f: (A) ⇒ B): List[B]
//   Builds a new collection by applying a function to all elements of this list.
println("Feed url lengths: " + feeds.map(_.length).mkString(","))
/*
Feed url lengths: 17,21,23
*/









