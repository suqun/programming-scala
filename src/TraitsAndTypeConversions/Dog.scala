/**
 * 混入trait的数量是任意的。用关键字with可以混入更多的trait
 */
class Dog(val name: String) extends Animal with Friend {
  //optionally override method here.
  override def listen = println(name + "'s listening quietly")
}
