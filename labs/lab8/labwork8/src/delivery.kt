interface DeliveryService {
    val serviceName:String
    fun deliver(orderId:Int)
}

class FoodService(override val serviceName:String):DeliveryService{
    override fun deliver(orderId: Int){
        println("Заказ №$orderId передан вдоставку через $serviceName")
    }
}

class DeliveryApp(service: DeliveryService):DeliveryService by service{
    fun createOrder(id:Int){
        deliver(id)
    }
}