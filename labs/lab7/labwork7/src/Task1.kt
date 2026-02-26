fun main() {
    var idiot = Book()
    idiot.name = ""
    idiot.author = "Достоевский"
    idiot.year = -1868
    idiot.pageQuantity = 256
    println("${idiot.name} - ${idiot.author} (${idiot.year}), ${idiot.pageQuantity} стр.")

}