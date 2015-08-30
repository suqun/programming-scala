def getPersonInfo(primarykey : Int) = {
  ("larry","su","larry_su@163.com")
}

/**
val (firstName,lastName,emailAddress) = getPersonInfo(1)

println("First Name is " + firstName)
println("Last Name is " + lastName)
println("Email Address is " + emailAddress)
*/

val info = getPersonInfo(1)

println("First Name is " + info._1)
println("Last Name is " + info._2)
println("Email Address is " + info._3)

