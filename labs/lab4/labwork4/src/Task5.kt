import kotlin.math.round


fun main() {
    println("Введите сумму")
    var price:Double = readln().toDouble()
    checkPrice(price)
    println("Введите оплату")
    var payment: Double = readln().toDouble()
    checkPayment(price, payment)
}

fun checkPrice(price:Double) {
    if (price in 1000.0..5000.0){
        var price = price - (price / 20.0)
        println("Сумма с учётом скидки 5% ${String.format("%.2f", price)}")
    }
    else if (price > 5000.0) {
        var price = price - (price / 10.0)
        println("Сумма с учётом скидки 10% ${String.format("%.2f", price)}")
    } else {
        println("Сумма ${round(price)}")
    }
}

fun checkPayment(price: Double, payment: Double){
    if (payment < price){
        println("Требуется доплатить ${price-payment}")
    }
    else if (payment > price){
        println("Возьмите сдачу ${payment-price}")
    }
    else{
        println("Спасибо!")
    }
}