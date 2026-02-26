var cars = mutableListOf("BMW", "Mercedes", "Lada", "Ferrari", "Renault")
fun enterCarsList(){
    for(i in 1 .. 3){
        println("Введите марку автомобиля")
        val input = readln()
        cars.add(input)
    }
}
fun showCarsList(){
    var i:Int = 0
    cars.forEachIndexed{ index, value->
        println("${index + 1} - $value")
    }
}