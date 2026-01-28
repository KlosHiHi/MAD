import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

fun main(){
    print("Введите х: ")
    var x:Double = readln().toDouble()
    print("Введите a: ")
    var a:Double = readln().toDouble()

    formule(x, a)
}

fun formule(x:Double, a:Double){
    var y:Double = 0.0

    when {
        x < 0 -> {
            y = a + (x * x * x)
        }

        x in 0.0..3.0 -> {
            y = sin(x) + cos(x)
        }

        x in 3.0..5.0 -> {
            if ((a - x) == 0.0) {
                println("Деление на ноль")
                return
            }
            y = 1.0 / (a - x)
        }

        x >= 5 -> {
            if (x - a < 0) {
                println("Корень из отрицательного числа")
                return
            }
            y = sqrt(x - a)
        }
    }

    val rounded = BigDecimal(y).setScale(3,RoundingMode.HALF_DOWN)

    println(rounded)
}