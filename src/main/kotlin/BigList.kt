import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun anonymousDelegate(words: List<String>) = object : ReadOnlyProperty<Any?, List<String>> {
    private val list = words.map { it.uppercase() }

    override fun getValue(thisRef: Any?, property: KProperty<*>): List<String> {
        return list
    }

}

fun main() {
    val input = readln().split(" ")
    val words: List<String> by anonymousDelegate(input)
    println(words)
}