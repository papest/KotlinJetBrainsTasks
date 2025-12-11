import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    MutableList(sc.nextInt()) { sc.nextInt() }.apply {
        val num = sc.nextInt() % size
        for (i in 1..num) {
            add(0, this[size - 1])
            removeAt(size - 1)
        }
        println(joinToString(" ", "", ""))
    }
}