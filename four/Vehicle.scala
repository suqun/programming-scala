/*
  类继承：1、重写方法需要override关键字 2、只有主构造函数才能往基类构造函数中传递参数
*/

class Vehicle (val id:Int, val year:Int) {
  override def toString() : String = "ID: " + id + " Year: " + year
}

class Car(override val id:Int, override val year: Int,
  var fuelLevel: Int) extends Vehicle(id,year) {
  override def toString(): String = super.toString() + " Fuel Level: " + fuelLevel
}

val car = new Car(1,2009,100)
println(car)
