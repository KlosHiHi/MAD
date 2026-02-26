open class Person(var name:String, var age:Int){
    open val info:String
        get() = "Имя: $name, Возраст: $age"
    override fun toString():String{
        return "Человек-$name"
    }
    open fun fullInfo(){
        println("Имя - $name\nВозраст - $age")
    }
}
class Student(name: String, age: Int, val group:String):Person(name,age) {
    override val info: String
        get() = "${super.info}, Группа - $group"

    override fun toString(): String {
        return super.toString() + "(Студент группы $group)"
    }

    override fun fullInfo() {
        super.fullInfo()
        println("Группа $group")
    }
}