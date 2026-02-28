import java.util.*
import kotlin.math.max

fun main() {
    val sc = Scanner(System.`in`)
    var curr: Int
    var max = Int.MIN_VALUE
    while (sc.nextInt().run { curr = this; this != 0 }) {
        max = max(curr, max)
    }
    println(max)
}