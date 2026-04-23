import java.util.Collections.binarySearch

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    b.forEach {
        val it1 = it.coerceIn(a.first(), a.last())
        val ind = binarySearch(a, it1)
        print(
            "${
                if (ind >= 0) it1 else if (it1 - a[-ind - 2] <= a[-ind - 1] - it1) a[-ind - 2] else a[-ind - 1]
            } "
        )
    }
}