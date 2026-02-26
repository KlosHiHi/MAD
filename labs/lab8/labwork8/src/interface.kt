interface DataSource<T> {
    fun getNext(): T
}

class RandomDataSource : DataSource<Int> {
    override fun getNext(): Int = (0..100).random()
}

class StaticDataSource(private val data:Array<String>):DataSource<String> {
    private var index = 0
    override fun getNext(): String {
        val item = data[index]
        index = (index + 1) % data.size
        return item
    }
}

fun <T> printElements(source: DataSource<T>){
    repeat(10){
        println("Цифорка - ${source.getNext()}")
    }
}