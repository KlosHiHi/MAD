fun main() {
    print("Введите радиус ")
    var rad: Double = readln().toDouble()

    var answer: Double = area(rad)

    println("Площадь круга: $answer")

    print("Введите большую ось ")
    var biggerSemiAxis: Double = readln().toDouble()
    print("Введите меньшую ось ")
    var smallerSemiAxis: Double = readln().toDouble()

    var answer2: Double = area(biggerSemiAxis, smallerSemiAxis)
    println("Площадь эллипса: $answer2")
}

fun area(rad:Double):Double {
    val pi = 3.14
    var answer: Double
    answer = pi * (rad * rad)
    return answer
}

fun area(bigger:Double, smaller:Double):Double {
    val pi = 3.14
    var answer: Double
    answer = pi * bigger * smaller
    return answer
}