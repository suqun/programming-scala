//package automobiles

class Vehicle{
  protected def checkEngine(){}
}

class Car extends Vehicle{
  def start() { checkEngine()} //OK
  def tow(car:Car){
    car.checkEngine() //OK
  }
  def tow(vehicle:Vehicle){
    vehicle.checkEngine()//Error
  }
}

class GasStation{
  def fillGas(vehicle:Vehicle){
    vehicle.checkEngine()//Error
  }
}

