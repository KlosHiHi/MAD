fun main() {
    print("Введите вклад: ")
    var contribution: Double = readln().toDouble()
    print("Введите процент: ")
    var percent: Float = readln().toFloat()

    gain(contribution, percent)
}

fun gain(contribution:Double, percent:Float) {
    var year: Int = 0
    var contributionCycle: Double = contribution
    while (contributionCycle < 1000000) {
        contributionCycle = contributionCycle * (1 + (percent / 100))
        year++
        print("прошёл ${year} год/а ")
        println("сумма %.2f".format(contributionCycle))
    }
}