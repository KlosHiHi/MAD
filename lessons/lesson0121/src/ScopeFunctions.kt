package scope

data class Person(val name:String, var email:String?)

fun main(){
    //let
    val tom = Person("Thomas", "tom@mail.com")
    tom.email?.let{ println(it)}
    //println(tom.email) - то же что и выше
    val tomNull = Person("Thomas", null)
    tomNull.email?.let{ println(it)}

    //with

    with(tom){
        if (email == null) email="defaultemail@mail.com"
        email
    }
}