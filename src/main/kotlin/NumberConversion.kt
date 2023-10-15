const val COLOR_VALUE_MAX = 255
fun main() {
    val (x1, x2, x3) = readLine()!!.split(" ")
    val colorValue = x1.toInt()
    val factor = x2.toFloat()
    val offset = x3.toInt()

    println(newColorValue(colorValue, factor, offset))

}

fun newColorValue(colorValue: Int, factor: Float, offset: Int): Int =
    (colorValue * factor + offset).toInt().coerceIn(0..COLOR_VALUE_MAX)
