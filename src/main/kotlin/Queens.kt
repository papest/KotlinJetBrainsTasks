import java.util.Scanner
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val (x, y, x1, y1) = List(4) {sc.nextInt()}
    println (if (x == x1 || y == y1 || (abs(x - y) == abs(x1 - y1))) "YES" else "NO")
}