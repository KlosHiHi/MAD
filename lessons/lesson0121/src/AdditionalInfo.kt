package additional

import javax.xml.transform.Source

fun main() {
    val counter1 = Counter(5)
    val counter2 = Counter(2)
    val counterSum = counter1 + counter2

    counter1.put(15)

    counter1 put 2
    val Том = Person("Том")
    Том говорит "Привет"

    val i1 =Item<String>("Hello")
    val i2 = Item(1)
}

class Item<T>(val value: T){
    fun check(value: T):Boolean{
        return this.value==value
    }
}

class Word<K,V>(val source: K, val target:V)

fun <T> getBiggest(a:T, b:T):T where T:Comparable<T>, T:Number{
    return if(a>b)a else b
}

class Person(val name:String) {
    infix fun говорит(words: String) {
        println("$name говорит $words")
    }
}

class Counter(var value: Int) {
    operator fun compareTo(counter: Counter): Int {
        return this.value - counter.value
    }

    operator fun plus(counter: Counter): Counter {
        return Counter(this.value + counter.value)
    }

    operator fun Int.plus(counter: Counter): Counter {
        return Counter(this + counter.value)
    }

    infix fun put(amount: Int) {
        value += amount
    }
}