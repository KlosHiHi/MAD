fun main() {
    println("Введите первую сторону")
    var firstSide: UByte = readln().toUByte()
    println("Введите вторую сторону")
    var secondSide: UByte = readln().toUByte()
    println("Введите третью сторону")
    var thirdSide: UByte = readln().toUByte()
    isReal(firstSide,secondSide,thirdSide)
    typeCheck(firstSide,secondSide,thirdSide)
}

fun isReal(firstSide:UByte, secondSide:UByte,thirdSide:UByte) {
    var forReal: Boolean =
        ((firstSide + secondSide) > thirdSide) && ((secondSide + thirdSide) > firstSide) && ((firstSide + thirdSide) > secondSide)
    if (forReal) {
        println("Существует")
    } else
        println("Не существует")
}

fun typeCheck(firstSide:UByte, secondSide:UByte,thirdSide:UByte) {

    var equilateralTriangle: Boolean = firstSide == secondSide && firstSide == thirdSide
    var isoscelesTriangle: Boolean =
        (firstSide == secondSide && firstSide != thirdSide) || (firstSide == thirdSide && firstSide != secondSide) || (secondSide == thirdSide && firstSide != secondSide)
    if (equilateralTriangle) {
        println("Треугольник равносторонний")
    } else if (isoscelesTriangle) {
        println("треугольник равнобедренный")
    } else
        println()
}