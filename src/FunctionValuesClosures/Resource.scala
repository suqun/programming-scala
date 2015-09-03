class Resource private() {
  println("Starting transaction...")
  
  private def cleanUp() { println("Ending transaction...")}

  def op1 = println("Operation 1")
  def op2 = println("Operation 2")
  def op3 = println("Operation 3")
}

object Resource {
  def use(codeBlock: Resource => Unit) {
    val resource = new Resource
    
    try {
      codeBlock(resource)
    }
    finally {
     resource.cleanUp()
    }
  }
}

Resource.use { resource =>
  resource.op1
  resource.op2
  resource.op3
  resource.op1
}
