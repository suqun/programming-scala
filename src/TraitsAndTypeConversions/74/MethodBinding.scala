abstract class Writer {
  def writeMessage(message: String)
}

trait UpperCaseWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message.toUpperCase)
}

trait ProfanityFilterWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message.replace("stupid","S-----"))
}

class StringWriterDelegate extends Writer {
  val writer = new java.io.StringWriter
  
  def writeMessage(message: String) = writer.write(message)
  override def toString(): String = writer.toString
}



val myWriterProfanityFirst = new StringWriterDelegate
  with UpperCaseWriter with ProfanityFilterWriter

val myWriterProfanityLast = new StringWriterDelegate
  with ProfanityFilterWriter with UpperCaseWriter

myWriterProfanityFirst writeMessage "There is no sin except stupidity"
myWriterProfanityLast writeMessage "There is no sin except stupidity"


println(myWriterProfanityFirst)
println(myWriterProfanityLast)

/**
  THERE IS NO SIN EXCEPT S-----ITY
  THERE IS NO SIN EXCEPT STUPIDITY
 */