import kotlin.random.Random

fun main(){
    var userNumber:Int = readln().toInt()
    var randomX = Random.nextInt(1, 10)
    guessingGame(userNumber, randomX)
}

fun guessingGame(userNumber:Int, randomX:Int) {
    var x: Int = userNumber
    do {
        if (x == randomX) {
            println("Молодец!!!")
            return
        } else if (x < randomX) {
            println("Требуется ввести большее число")
            x = readln().toInt()
        } else {
            println("Требуется ввести меньшее число")
            x = readln().toInt()
        }
    } while (randomX != x)
}