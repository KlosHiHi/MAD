fun main(){
    print("Введите a ")
    var a:Double = readln().toDouble()
    print("Введите b ")
    var b:Double = readln().toDouble()
    print("Введите x1 ")
    var x1:Int = readln().toInt()
    print("Введите x2 ")
    var x2:Int = readln().toInt()
    println()
    cycleFormule(a,b,x1,x2)
}

fun cycleFormule(a:Double, b:Double, x1:Int,x2:Int) {
    for (x in x1..x2){
        println((a*x)+b)
    }
}