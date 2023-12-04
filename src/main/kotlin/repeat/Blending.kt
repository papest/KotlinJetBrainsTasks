package repeat

import java.lang.Integer.max

fun subtractionBlend() {
    val first  = readln().split(" ")
    val second = readln().split(" ")
    for (i in 0..2) {
        print(max(first[i].toInt() - second[i].toInt(), 0))
        print(" ")
    }
}

fun main() {
    subtractionBlend()
}

