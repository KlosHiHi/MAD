var leapYear: Boolean = true

fun main(){
    print("Введите год: ")
    val year: Int = readln().toInt()
    print("Введите месяц: ")
    val month: Int = readln().toInt()
    yearDeterm(year)
    monthDayDeterm(month, leapYear)
    seasonDetern(month)
}

fun yearDeterm(year:Int) {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        println("Год високосный")
        leapYear = true
    } else {
        println("Год обычный")
        leapYear = false
    }
}

fun monthDayDeterm(month:Int, leapYear:Boolean) {
    when (month) {
        1, 3, 5, 7, 8, 10, 12 -> println("31 день в месяце")
        4, 6, 9, 11 -> println("30 дней в месяце")
        2 -> println(if(leapYear) "29 дней в месяце" else "28 дней в месяце")
        else -> println("неккоректный месяц")
    }
}

fun seasonDetern(month: Int) {
    when (month) {
        12, 1, 2 -> println("Зима")
        3, 4, 5 -> println("Весна")
        6, 7, 8 -> println("Лето")
        9, 10, 11 -> println("Осень")
    }
}