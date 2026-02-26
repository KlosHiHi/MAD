fun enterNumbersList(){
    println("Введите кол-во элементов ")
    val count = readln().toInt()

    val numbers = mutableListOf<Int>()

    for (i in 0 until count){
        print("Введите число ${i+1}: ")
        numbers.add(readln().toInt())
    }
    println("Список: $numbers")
    println(numbers.indexOf(100))
    println(numbers.sum())
    println(numbers.average())
    println(numbers.all{it>0})
    println(numbers.filter{it%2 != 0})
}