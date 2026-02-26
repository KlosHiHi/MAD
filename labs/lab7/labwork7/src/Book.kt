//class Book(name: String) {
//    var name: String = "Конституция"
//    var author: String = "Россия"
//    var year: Int = 2000
//    var pageQuantity: Int = 30

//    init {
//        this.name = name
//    }
//
//    constructor(name: String, author: String, year: Int, pageQuantity: Int) : this(name) {
//        this.author = author
//        this.year = year
//        this.pageQuantity = pageQuantity
//
//        println("$pageQuantity страниц")
//    }
//
//    fun showInfo() {
//        println("${name} - ${author} (${year}), ${pageQuantity} стр.")
//    }
//
//
//}

class Book() {
    var name: String = "Конституция"
        set(value) {
            if (value.count() > 1)
                field = value
        }
        get() {
            return field
        }

    var author: String = "Автор"
        set(value) {
            if (value.count() > 1)
                field = value
        }
        get() {
            return field
        }

    var year: Int = 2000
        set(value) {
            if (value > 0)
                field = value
        }
        get() {
            return field
        }

    var pageQuantity: Int = 30
        set(value) {
            if (value > 0)
                field = value
        }
        get() {
            return field
        }
}