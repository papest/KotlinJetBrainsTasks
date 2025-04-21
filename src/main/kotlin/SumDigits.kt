import java.util.*

fun main() {

    val scan = Scanner(System.`in`)
    var message = "Invalid Input"
    if (scan.hasNextInt()) {
        val num = scan.nextInt()
        if (num in 1..9999) {
            message = num
                .toString()
                .sumOf { it.digitToInt() }
                .toString()
        }
    }
    println(message)

}

