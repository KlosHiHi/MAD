fun main(){
    val answer = scope(1,2,1,20,4,5,6)
    println("Размах: $answer")
}

fun scope(vararg numberSeries:Int):Int{
    val maxNumber = numberSeries.max()
    val minNumber = numberSeries.min()
    return maxNumber - minNumber
}