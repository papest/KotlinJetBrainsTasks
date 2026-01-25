import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    List(sc.nextInt()) { sc.nextInt() }.groupBy {
        when (it) {
            1 -> "larger"
            -1 -> "smaller"
            0 -> "perfect"
            else -> "d"
        }

    }.also { println("${it["perfect"]?.size} ${it["larger"]?.size} ${it["smaller"]?.size}") }

}