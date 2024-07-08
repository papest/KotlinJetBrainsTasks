package repeat

import java.util.*

fun main() {
    val size = readln().toInt()
    val list = MutableList(size) { readln().toInt() }
    val rotate = readln().toInt()
    Collections.rotate(list, rotate)
    println(list.joinToString(" "))
}

