import kotlin.math.pow

fun main(){
//    print("Введите первый член прогрессии ")
//    var n1:Double = readln().toDouble()
//    print("Введите знаменатель прогрессии ")
//    var q:Double = readln().toDouble()
//    print("Введите номер последнего члена прогрессии ")
//    var nn:Double = readln().toDouble()

//    geometryProgression(n1, q, nn)

    geometryProgression(3.0)
    geometryProgression(3.0, 2.0, 3.0)
}

fun geometryProgression(nn:Double, n1:Double = 1.0, q:Double = 2.0) {
    var answer:Double = n1 * q.pow(nn-1.0)
    println("Значение $nn-го числа: $answer")
}
