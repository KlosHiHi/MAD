package scope

data class Person(val name:String, var email:String?)

fun main() {
    //let
    val tom = Person("Thomas", "tom@mail.com")
    tom.email?.let { println(it) }
    //println(tom.email) - то же что и выше
    val tomNull = Person("Thomas", null)
    tomNull.email?.let { println(it) }

    //with

    var result = with(tom) {
        if (email == null) email = "defaultemail@mail.com"
        email
    }

    //run

    result = tom.run {
        if (email == null) email = "defaultemail@mail.com"
        email
    }

    //apply

    tom.apply {
        if (email == null) email = "defaultemail@mail.com"
    }

    val bob = Employee()

    bob.name("Robert")
        .age(54)
        .company("ACT")

    //also

    bob.also { it.name = "" }
}

data class Employee (var name:String ="", var age:Int=0, var company:String="") {
    fun age(_age: Int): Employee = apply { age = _age }
    fun name(_name: String): Employee = apply { name = _name }
    fun company(_company: String): Employee = apply { company = _company }
}