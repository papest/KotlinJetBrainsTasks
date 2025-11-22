import java.util.Scanner

fun main() {

    val reader = Scanner(System.`in`)
    val limit = reader.nextInt()

    if (limit < 0) {
        println("Invalid Input")
    } else {
        var sum = 0
        var el = 1
        repeat(limit / 2) {
            sum += (++el) * el
            el++
        }
        println(sum)
    }
}
