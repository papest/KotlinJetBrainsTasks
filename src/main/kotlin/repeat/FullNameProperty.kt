package repeat

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Person {
    var firstName: String = ""
    var lastName: String = ""
    var fullName: String by FullNameDelegate
}

object FullNameDelegate : ReadWriteProperty<Person, String> {
    override fun getValue(thisRef: Person, property: KProperty<*>): String {
        return "${thisRef.firstName} ${thisRef.lastName}"
    }

    override fun setValue(thisRef: Person, property: KProperty<*>, value: String) {
        with(value.split(" ")) {
            thisRef.firstName = this[0]
            thisRef.lastName = this[1]
        }
    }
}

fun main() {
    Person().apply {
        fullName = readln()
    }.also { println(it.lastName) }
}

