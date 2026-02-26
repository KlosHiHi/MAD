import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit>{
//    launch {
//        for (i in 0..5) {
//            println(i)
//            delay(1000)
//        }
//    }
//    var job = launch(context = Dispatchers.Default, start = CoroutineStart.LAZY) {
//        try {
//            for(i in 6..10){
//                println("$i ${Thread.currentThread().name}")
//                delay(1000)
//            }
//        }
//        catch (e: Exception){
//            println(e.message)
//        }
//
//    }
//    launch {
//        delay(3000)
//        job.cancel()
//    }
//    println("Begin")
//    job.start()
//    job.join() // ожидание завершения
//    println("The End")
    val deferred = async {
        getMessage()
    }

    withTimeout(1000){
        repeat(1000){
            println(it)
            delay(500)
        }
    }
    println(deferred.await())
}
suspend fun getMessage():String {
    delay(500)
    return "Hello"
}