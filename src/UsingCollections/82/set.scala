/**
 * Created by larry on 9/4/15.
 * Set 操作
 */

val feeds1 = Set("blog.toolshed.com","pragdave.pragprog.com",
  "pragmactic-osxer.blogspot.com","vita-contemplativa.blogspot.com")
val feeds2 = Set("blog.toolshed.com","martinfowler.com/blike")

//2、filter()方法获取Set的元素，
//   mkString()为Set的每个元素创建字符串表示，例如逗号拼接
val blogSpotFeeds = feeds1 filter (_ contains "blogspot")
println("blogspot feeds: " + blogSpotFeeds.mkString(","))
/*
 结果：
 blogspot feeds: pragmactic-osxer.blogspot.com,vita-contemplativa.blogspot.com
*/

//3、++() 合并两个Set，Set至多持有每个元素一次，合并后的Set公共的元素只存储一个
val mergedFeeds = feeds1 ++ feeds2
println("# of merged feeds: " + mergedFeeds.size)
/*
 结果：
 # of merged feeds: 5
*/

//4、**() 两个Set的交集运算(此处错误，交集可以使用&)
val commonFeeds = feeds1 & feeds2
println("common feeds: " + commonFeeds.mkString(","))
/*
 结果：
 common feeds: blog.toolshed.com
*/
//5、map() 对每个元素应用给定的函数值，将结果收集到一个set里，最后将产生的Set返回
//toArray()方法将Set的元素复制到数组中，然后索引访问Set的元素
val urls = feeds1 map ("http://" + _)
println("One url: " + urls.toArray())
/*
 结果：

*/

//6、foreach() 迭代Set的元素
println("Refresh Feeds: ")
feeds1 foreach { feed => println(" Refreshing " + feed) }

/*
 结果：
 Refresh Feeds:
  Refreshing blog.toolshed.com
Refreshing pragdave.pragprog.com
Refreshing pragmactic-osxer.blogspot.com
Refreshing vita-contemplativa.blogspot.com
*/