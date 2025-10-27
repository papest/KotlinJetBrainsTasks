import java.io.File
import java.util.*
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.streams.asSequence
import kotlin.streams.toList

fun Vector<Int>.distance(next: Vector<Int>): Double {
    var sum = 0.0
    val count = min(next.size, this.size)
    for (i in 0 until count) {
        sum += (next[i] - this[i]) * (next[i] - this[i])
    }
    return ceil(sqrt(sum))
}

fun main() {

    File("src/main/resources/hyperskill-dataset-117411456.txt")
        .readLines()
        .stream()
        .map { Vector(it.split(",").stream().map { it1 -> it1.toInt() }.toList()) }
        .asSequence()
        .windowed(2, 1)
        .sumOf { it[0].distance(it[1]) }
        .also { println(it.toInt()) }
}