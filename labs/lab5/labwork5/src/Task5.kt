fun main(){
    val char1 = 'x'
    val char2 = 'o'

    val charArray = CharArray(64){
        index->if (index < 8) char1 else char2
    }

    charArray.shuffle()
    var a:Int= 0
    while (a != 64)
    for (i in 1..8){
        for (j in 1..8){
            print(" ${charArray[a]}\t")
            a++
        }
        println()
    }
}