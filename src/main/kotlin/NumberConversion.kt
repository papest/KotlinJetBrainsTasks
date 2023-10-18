const val COLOR_VALUE_MAX = 255
fun main() {
    additionBlend()

    val (x1, x2, x3) = readLine()!!.split(" ")
    val colorValue = x1.toInt()
    val factor = x2.toFloat()
    val offset = x3.toInt()

    println(newColorValue(colorValue, factor, offset))


}

fun newColorValue(colorValue: Int, factor: Float, offset: Int): Int =
    (colorValue * factor + offset).toInt().coerceIn(0..COLOR_VALUE_MAX)

fun additionBlend() {
    val (red1, green1, blue1) = readln().split(" ").map { it.toInt() }
    val (red2, green2, blue2) = readln().split(" ").map { it.toInt() }

    println(
        "${(red1 + red2).coerceAtMost(COLOR_VALUE_MAX)} ${(green1 + green2).coerceAtMost(COLOR_VALUE_MAX)} ${
            (blue1 + blue2).coerceAtMost(
                COLOR_VALUE_MAX
            )
        }"
    )
}

