/*创建单例对象要用object关键字，而不是class。因为单实例对象无法初始化，所有不能给他的主构造函数传递参数
  该例子可以跳过MarkerFactory直接创建Marker的实例
*/
class Marker(val color: String) {
  println("Creating " + this)

  override def toString() : String = "marker color " + color
}

object MarkerFactory {
  private val markers = Map (
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def getMarker(color: String) =
    if (markers.contains(color)) markers(color) else null 
}

println(MarkerFactory getMarker "blue")
println(MarkerFactory getMarker "blue")
println(MarkerFactory getMarker "red")
println(MarkerFactory getMarker "red")
println(MarkerFactory getMarker "yellow")
