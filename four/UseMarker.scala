/*
  Scala 可以创建一个关联到类上的单例。单例同类共享相同的名字---伴生对象
  类和伴生对象之间没有界限，他们可以相互访问彼此的private字段和方法。

  另外，在scala里可以把构造函数标记为private
*/
class Marker private (val color: String) {
  println("Creating " + this)

  override def toString() : String = "marker color " + color
}

object Marker {
  private val markers = Map (
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def getMarker(color: String) =
    if (markers.contains(color)) markers(color) else null 
}

println(Marker getMarker "blue")
println(Marker getMarker "blue")
println(Marker getMarker "red")
println(Marker getMarker "red")
println(Marker getMarker "yellow")
