import TraitsAndTypeConversions.{Cat, Friend}

/**
 * Cat 并没有混入Friend trait,所有，不能把Cat的实例作为Friend
 */
def useFriend(friend: Friend) = friend listen

val alf = new Cat("Alf")
//val friend: Friend = alf //ERROR

//useFriend(alf) //ERROR
