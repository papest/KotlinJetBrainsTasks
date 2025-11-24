import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val count = scanner.nextInt()

    val list = List(count) { scanner.nextInt() }

    println(list.sum())
}