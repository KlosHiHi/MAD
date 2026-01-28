fun main() {
    val tom: Person = Person("Tom")

    print(tom.name)
    print(" ")
    println(tom.age)

    tom.name = "Thomas"
    tom.age = 36

    print(tom.name)
    print(" ")
    println(tom.age)

    tom.sayHello()
}


class Person (var name:String){
    //var name: String = "Undefined"
    var age: Int = 18

    init{
        name = "qwe" + name
    }

    //вторичный конструктор
    constructor(_name:String, age:Int) : this(_name) {
        //name = _name
        this.age = age
    }

    fun sayHello() {
        println("Hello, I'm ${this.name}")
    }
}

//equals
//hashCode
//toString
//copy
data class Cat(val name: String)

//open - ключевое слово для возможности наследования
open class Animal

class Dog: Animal() {
    init {
        super.toString() //обращение к родительскому классу
    }
}

abstract class Figure{
    abstract val name: String
    abstract fun Square():Int
}

class Rect(var a:Int, var b:Int):Figure() {
        override val name: String
        get() = "Прямоугольник"

    override fun Square(): Int = a * b
}

//final - запрещает наследование
//sealed - ограниченное наследование (только для определлённых классов)

sealed class Shape{
    class Circle():Shape()
}

enum class WeekDay(val value: Int){
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    fun daysUntil(day: WeekDay):Int{
        return day.value - value
    }
}

enum class Screen{
    HOME{
        override fun show() = println("home")
    },
    SETTINGS{
        override fun show() = println("settings")
    };

    abstract fun show()
}

interface Movable{
    var speed:Double
    fun move(){
        println("едем на машине")
    }
}

class Car:Movable{
    override var speed: Double = 0.0
    override fun move() {
        println("едем на машине")
    }
}

class Human(override var speed: Double):Movable

interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer: VideoPlayable, AudioPlayable {
    override fun play() {
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}

interface Base {
    fun doSomething() {
        println("do ...")
    }
}

class Derived(someBase: Base): Base by someBase

interface Messenger {
    fun send(message: String)
}

class InstantMessenger(val programName:String="Max"):Messenger {
    override fun send(message: String) {
        println("$programName sent: $message")
    }
}

class SmartPhone(val name: String, m:Messenger):Messenger by m

class User(val name:String) {
    init {
        counter++
    }

    companion object {
        var counter = 0
        fun printCounter() = println(counter)
    }
}

fun meow() {
    //var length = WeekDay.MONDAY.daysUntil(WeekDay.FRIDAY)
    var max = InstantMessenger()
    var pocoX6 = SmartPhone("POCO X6 5G", max)

    pocoX6.send("hello, friend")
    println(5.square())
    println(5.double)
}

fun Int.square():Int{
    return this*this
}

val Int.double:Double
    get()=this.toDouble()