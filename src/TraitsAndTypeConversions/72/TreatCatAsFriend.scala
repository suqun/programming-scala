import TraitsAndTypeConversions.{Cat, Friend}

/**
 * 在实例一级对trait进行选择性混入，可以把特定的类的实例当作trait
 * 创建实例时，只要用with关键字标记一下即可
 */
def useFriend(friend: Friend) = friend listen

val snowy = new Cat("Snowy") with Friend
val friend: Friend = snowy
friend.listen

useFriend(snowy)
