import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val list = List(sc.nextInt()) { sc.nextInt() }
    val (p, m) = List(2) { sc.nextInt() }
    list
        .windowed(2, 1)
        .firstOrNull { (it.first() == p && it.last() == m) || (it.first() == m && it.last() == p) }
        .also { println(if (it.isNullOrEmpty()) "YES" else "NO") }
}
