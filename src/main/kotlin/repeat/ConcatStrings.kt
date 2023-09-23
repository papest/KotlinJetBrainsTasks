package repeat

fun concatenate(list: List<String>, separator: String) = list.joinToString(separator)

fun main() {
    println(concatenate(listOf("one", "two", "three", "four", "five"), " - "))
}