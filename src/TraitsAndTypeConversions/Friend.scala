/**
 * Trait像一个拥有部分实现的接口，trait里定义和初始化的val和var会在
 * 混入trait的类的内部得到实现。定义过而未初始化的val和var则认为是抽象的，
 * 需要由混入这些trait的类实现。
 *
 * trait看上去很像类，但是还有一些很大的区别。
 * 首先，它们需要混入类曲实现那些已声明的而未初始化（即抽象的）变量和值。
 * 其次，它们的构造函数不能有任何参数。
 * trait会编译成Java的接口，还有对应的实现类，里面包含了trait的实现的方法。
 */
trait Friend {
  val name : String 
  def listen() = println("Your friend " + name + "is listening")
}
