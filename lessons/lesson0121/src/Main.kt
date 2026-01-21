fun hello() {
    fun pl() {
        println("Hello")
    }

    println("Hello")
}

fun name(param1:Int,
         param2:String = "Hello",
         param3 : Int) : Int {
    return 1
}

fun printLines(vararg lines:String) {
    for (line in lines)
        println(line)
}

fun compareAge(age1:Int, age2:Int) {
    fun isAgeValid(age: Int): Boolean {
        return age > 0 && age < 150
    }

    if (isAgeValid(age1) && isAgeValid(age2)) {

    }
}

fun square(x: Int) = x * x
fun square(x: Int, y: Int) = x * y

fun main() {
    hello()
    hello()

    var h = ::hello

    h()
    h()

    name(1, param3 = 3)

    printLines("1", "2", "3", "4", "5")
    var arr = arrayOf("1", "2", "3", "4", "5")

    printLines(*arr)

    // анонимные функции
    val anonFun = fun(x: Int) = x + x

    // лямбда функции
    val lambda = { println() }

    var lambda1 = { x: Int -> println(x) }
    lambda1 = { _ -> println() }

    val lambda2: () -> Unit

    //функции высокого порядка
    displayMessage(::morning)
    displayMessage({println("Добрый вечер")})
    displayMessage { println("Добрый день") }

    action(1, 2, ::sum)
    action(6, 3, ::sub)

    var counter = createCounter()
    counter()
    counter()
    counter()
}

fun displayMessage(msg: () ->Unit) {
    msg();
}

fun morning() = println("Доброе утро")

fun action(a: Int, b: Int, op: (Int, Int) -> Int) {
    val result = op(a, b)
    println(result)
}

fun sum(a: Int, b:Int) = a + b
fun sub(a: Int, b:Int) = a - b

fun selectAction(op: String) : (Int, Int) -> Int {
    return when (op) {
        "+" -> ::sum
        "-" -> ::sub
        else -> { _, _ -> 0 }
    }
}

fun createCounter(): () -> Unit{
    var n = 0

    fun counter(){
        println(n++)
    }

    return ::counter
}