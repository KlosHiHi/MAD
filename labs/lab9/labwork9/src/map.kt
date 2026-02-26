var map = mutableMapOf("Arkhangelsk" to 300000, "New-York" to 8400000, "London" to 8800000)
fun enterCitiesMap(){
    for(i in 1 .. 3){
        println("Введите город и население")
        val inputKey = readln()
        val inputValue = readln().toInt()
        map.set(inputKey, inputValue)
    }
}
fun showCititesMap(){
    map.forEach { (string, int) ->
        println("$string - $int") }
    println("${map.size} - элементов словаря")
}
fun search(){
    println("Введите ключ")
    var searchKey = readln()
    if(map.containsKey(searchKey)){
        println("Ключ существует")
    }
    else
        println("Ключ не существует")

    map.getOrDefault(searchKey, " ")
    println("Кол-во совпадений: ${map.keys.count{it==searchKey}}")
    map.remove(searchKey)
    showCititesMap()
}