//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(3 shl 2)
    var n = 4

    var isIn = n !in 1..5

    var i = readln().toInt()

    var j = if (i > 0) {
        1
    } else if (i < 0) {
        2
    } else {
        3
    }

    var k = when (i) {
        1 -> print(1)
        2 -> print(34)
        3, 4 -> println('t')
        6 + j -> println('h')
        in 6..10 -> println(3)

        else -> {
            println(5)
            println(8)
        }
    }

    when {
        (j > 0) -> println()
        (i == 0) -> println()
    }

    for (m in 1..10) {
        println(4)
    }

    while (true) {
        break
    }

    do {

    } while (false)

    outerloop@ for (i1 in 1..10) {
        for (i2 in 1..10) {
            break@outerloop
        }
    }

    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    val empty = arrayOfNulls<Int>(5) // 5, 5, 5

    var numbers1 = Array(3, { 5 })
    var numbers2 = Array(3, { i++ * 2 }) // 2, 4, 6

    numbers[0] = 1
    for (num in numbers) {
        println(num)
    }

    for (i1 in 0..<numbers.size) {
        println(numbers[i1])
    }
    for (i1 in 0..numbers.lastIndex) {
        println(numbers[i1])
    }
    for (i1 in numbers.indices) {
        println(i1)
    }

    val intArray = intArrayOf(1, 2, 3)
    val doubleArray = doubleArrayOf(1.0, 2.0, 3.0)

    if (3 in intArray) {

    }

    numbers.shuffle() //развернуть
    numbers.reverse() //перемещать
    numbers.random() //случайные элемент
    numbers.sort() //сортировка

    var table: Array<Array<Int>> =
        Array(5, { Array(3, { 0 }) })

    table[0][0] = 1

    for (row in table) {
        for (cell in row)
            print("$cell\t")
        println()
    }


}