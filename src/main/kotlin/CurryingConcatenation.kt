fun concatenate(s1: String): (String) -> String = { s2 -> s1 + s2 }

fun main() {
    println(concatenate("Hello, ")("World!"))
}
