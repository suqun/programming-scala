class Microwave{
  def start() = println("started")
  def stop() = println("stopped")
  private def turnTable = println("turning talbe")
}

val microwave = new Microwave
microwave.start()
microwave.turnTable()//ERROR
