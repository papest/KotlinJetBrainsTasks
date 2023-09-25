import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun Any?.isPerson(): Boolean {
    contract {
        returns(true) implies (this@isPerson is Person)
    }
    return this is Person
}

class Person(val name: String?, val age: Int)
fun isAdult(value: Any?): Boolean {
    return if (value.isPerson()) {
        value.age >= 18
    } else {
        false
    }
}

fun main() {
println(isAdult(Person(readln(), readln().toInt())))
}