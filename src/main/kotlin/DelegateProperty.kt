import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate("initialValue")
}

class Delegate(initialValue: String) {
    private var value: String = initialValue
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

fun main() {
    println(Example().p)
    println(
        with(Example()) {
            p = "a"
            p
        }
    )
}