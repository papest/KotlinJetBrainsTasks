package repeat

fun main() {
    val n = readln().toInt()

    println(
        (1..n).flatMap {
            val a = it
            IntArray(it) { a }.toList()
        }
            .take(n)
            .joinToString(" ")
    )
}