var price:Double = readln().toDouble()

fun main() {
    var payment: Double = readln().toDouble()
    checkPrice(price)
}

fun checkPrice(price:Double) {
    if (price in 1000.0..5000.0){
        price = price - (price / 20)
    }
    else if (price > 5000.0) {
        price - (price / 10)
    } else {
        price
    }
}

fun checkPayment(price: Double, payment: Double){

}