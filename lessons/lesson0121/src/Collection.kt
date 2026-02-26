// Iterable

fun main() {
    var numbers = listOf(1, 2, 3, 4, 5)

    println(numbers.all { x -> x > 3 })


    try {
        throw ArithmeticException()
        throw IllegalArgumentException()
    } catch (e: Exception) {

    } finally {

    }

    numbers.forEach {
        println(it)
    }

    var list = numbers.map(Int::toDouble)
    var list1 = numbers.map { it.toDouble() }
    var list2 = numbers.map { item -> item.toDouble() }

    numbers = numbers + 4 - listOf(1, 2)

    numbers.shuffled()

    var number = 0
    val seq = generateSequence {
        number += 2
        number
    }
    seq.drop(55).take(3).let { println(it.joinToString()) }

    val seq1= sequence {
        var start = 0
        while (true) yield(start++)
    }
}