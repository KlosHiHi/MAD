abstract class Figure{
    abstract val name:String
    abstract fun area():Double
    abstract fun perimeter():Double
    abstract fun answer()
}

class Circle(val radius:Double):Figure() {
    override val name: String = "Круг"
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
    override fun answer() {
        println("Фигура - $name\nРадиус - $radius\nПлощадь - ${area()}\nПериметр - ${perimeter()}")
    }
}