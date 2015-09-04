/**
 * Created by larry on 9/4/15.
 * Map 操作
 * API: http://www.scala-lang.org/api/current/#scala.collection.Map
 */

//1、filterKeys(p: (A) ⇒ Boolean): Map[A, B]
// Filters this map by retaining only keys satisfying a predicate.
val feeds = Map("Andy Hunt" -> "blog.toolshed.com",
  "Dave Thomas" -> "pragdave.pragprog.com",
  "Dan Steinberg" -> "dismunthink.com/blog")

val feeds1 = Map(
  ("Andy Hunt","blog.toolshed.com"),
  ("Dave Thomas","pragdave.pragprog.com"),
  ("Dan Steinberg","dismunthink.com/blog")
)

val filterNameStartWithD = feeds filterKeys(_ startsWith "D")
println("# of Filtered: " + filterNameStartWithD.size)
val filterNameStartWithA = feeds1 filterKeys(_ startsWith "A")
println("# of filtered: " + filterNameStartWithA.size)
//结果：
// # of Filtered: 2
// # of filtered: 1

//2、filter(p: ((A, B)) ⇒ Boolean): Map[A, B]
val filterNameWithDAndBlogInFeed = feeds filter { element => 
  val (key,value) = element
  (key startsWith "D") && (value contains "blog")
}

println(" # of feeds with auth name D* and blog in URL: " +
  filterNameWithDAndBlogInFeed.size)
//结果：# of feeds with auth name D* and blog in URL: 1


//3. get()
println("Get Andy's Feed: " + feeds.get("Andy Hunt"))
println("Get Bill's Feed: " + feeds.get("Bill Who"))
//结果：
//Get Andy's Feed: Some(blog.toolshed.com)
//Get Bill's Feed: None


//4、apply() 对类或对象使用括号时就是调用这个方法，返回的是值不是Potion[T]
//不同与get(),如果给定的键没有对应的值，就会抛出异常
try {
  println("Get Andy's Feed Using apply(): " + feeds("Andy Hunt")) 
  println("Get Bill's Feed: " + feeds("Bill Who"))
}
catch {
  case ex: java.util.NoSuchElementException => println("Not found")
}
/*
 结果:
 Get Andy's Feed Using apply(): blog.toolshed.com
 Not found
*/

//5、updated()新增元素， 并不会影响原来的Map，会返回一个新的map，包含了新增的元素
val newFeeds1 = feeds.updated("Venkat Subramaniam","agiledeveloper.com/blog")
println("Venkat's blog in original feeds: " + feeds.get("Venkat Subramaniam"))
println("Venkat's blog in new feed: " + newFeeds1("Venkat Subramaniam"))
/*
结果:
Venkat's blog in original feeds: None
Venkat's blog in new feed: agiledeveloper.com/blog
*/

/**
 * 相对于显示调用update()。如果对赋值左边的类或实例使用括号，Scala会自动调用update()方法
 * 所以，X() = b等价于X.update(b).如果update()的参数多于一个，可以将除了最后一个参数之外的
 * 所有参数放到括号里。所以，X(a) = b 等价于 X.update(a,b)
 */

//6、可变容器更新
val mutableFeeds = scala.collection.mutable.Map(
  "Scala Book Forum" -> "forums.pragprog.com/forums/87")
mutableFeeds("Groovy Book Forums") = "forums.pragprog.com/forums/55"
println("Number of forums: " + mutableFeeds.size)
/**
 * Number of forums: 2
 */

