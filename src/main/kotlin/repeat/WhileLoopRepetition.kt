package repeat

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var number: Int
    while ((scanner.nextInt().also { number = it }) > 0) println("*".repeat(number))

}
