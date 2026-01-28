import java.math.RoundingMode

fun main() {
    println("Введите сумму")
    var rub: Double = readln().toDouble()
    println("Введите валюту")
    var currency: String = readln().toString()

    Convert(rub, currency)
}

fun Convert(rub:Double, currency:String) {
    if (currency == "$" || currency == "dollar" || currency == "доллар") {
        var rub: Double = rub * 0.0125
        val rounded = rub.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
        println("$rub долларов")
    } else if (currency == "euro" || currency == "e" || currency == "евро") {
        var rub: Double = rub * 0.01
        val rounded = rub.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
        println("$rub евро")
    } else {
        print("Неверная валюта ")
        println(rub)
    }
}