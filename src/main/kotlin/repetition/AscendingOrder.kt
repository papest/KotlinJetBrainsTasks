package repetition

fun isAscending(array: IntArray): Boolean {
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) return false
    }
    return true
}

fun main() {
    val array = IntArray(readln().toInt()) { readln().toInt() }
    println(if (isAscending(array)) "YES" else "NO")
}