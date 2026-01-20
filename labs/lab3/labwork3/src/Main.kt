//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //meth()
    ibm()
    //time()
    //year()
    //square()
}

fun meth() {
    println("Введите а")
    var a = readln().toInt()
    println("Введите b")
    var b = readln().toInt()

    println("$a + $b = ${a + b}")
    println("$a - $b = ${a - b}")
    println("$a * $b = ${a * b}")
    println("$a / $b = ${a / b}")
    println("$a % $b = ${a % b}")
}

fun ibm() {
    print("Введите ваше имя: ")
    var name = readln().toString()
    print("Введите ваше рост: ")
    var height = readln().toFloat()
    print("Введите ваше вес: ")
    var weight = readln().toFloat()
    height = height / 100

    var ibm = weight / (height * height)

    println("$name, ваш ИМТ = $ibm")
}

fun time() {
    print("Введите кол-во секунд: ")
    var s = readln().toInt()
    val day = 86400
    val sHour = 3600
    val sMinute = 60

    s = s%day
    var hour = s / sHour
    var minute = (s % sHour) / sMinute
    var sec = (s % sHour) % sMinute

    val secTime = "%02d:%02d:%02d".format(hour, minute, sec)
    println(secTime)
}

fun year() {
    print("Введите год: ")
    var year = readln().toInt()
    println((((year % 4 == 0) and (year % 100 != 0)) || (year % 400 == 0)))
}

fun square() {
    print("Введите ваше внутренний радиус: ")
    var inRad = readln().toInt()
    print("Введите ваше внешний радиус: ")
    var outRad = readln().toInt()

    val pi = 3.14
    var sqr = pi * ((outRad * outRad) - (inRad * inRad))

    val answer = String.format("%.3f", sqr)
    println(answer)
}