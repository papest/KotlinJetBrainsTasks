import kotlin.properties.Delegates.observable

class PersonAge {

    var age: Int by observable(0) { _, _, new ->
        if (new >= 18) isAdult = true
    }

    var isAdult: Boolean = false
        private set
}

fun main() {
    with(PersonAge()) {
        age = 13
        println(isAdult)
        age = 19
        println(isAdult)
    }
}