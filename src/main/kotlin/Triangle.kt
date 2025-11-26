import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    repeat(n) {
        println("*".repeat(it + 1))
    }
}