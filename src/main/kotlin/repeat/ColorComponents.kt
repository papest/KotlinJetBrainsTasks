package repeat

import java.awt.Color

fun printColorFloat() {
    val (red, green, blue) = readln().split(" ").map { it.toInt() }
    println(
        if (red in 0..255 && blue in 0..255 && green in 0..255) {
            Color(red, green, blue).getRGBComponents(null)
                .run { "${get(0)} ${get(1)} ${get(2)}" }
        } else {
            "Invalid input"
        }
    )
}

fun main() {
    printColorFloat()
}
