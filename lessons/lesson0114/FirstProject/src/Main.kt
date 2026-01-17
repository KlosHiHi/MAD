import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.math.*

// комментарий

/*
многострочный комментарий
 */

fun main() {
    println("Hello World!")
    println("Hello World!")

    var b : Byte
    var s : Short
    var n: Int = 1
    var l : Long

    var x = 15
    var y = 5
    var f = 3.14F
    var d = 4.12e-2

    var result = "$x + $y = ${x+y}"

    var fortmat = String.format("%.2f %d", f, n)

    var obj : Any? = null
    obj = "qwe"

    var range = 1 ..5 step 2
    var range1 = 1..< 5
    var range2 = 1 until 5
    var range3 = 1 downTo 1

    print("123")
    print("123")
    println()
    println(range.toList())

    var data = readln().toIntOrNull()
    var data1 = readlnOrNull()
    println(data)
    println(data1)

    Random.nextDouble(1.0, 5.0)
    d.roundToInt()

}