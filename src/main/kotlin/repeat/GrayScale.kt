package repeat

fun main() {
    val (x1, x2, x3) = readLine()!!.split(" ")
    val red = x1.toInt()
    val green = x2.toInt()
    val blue = x3.toInt()

    println(colorValueToGrayscale(red, green, blue))

}

fun colorValueToGrayscale(red: Int, green: Int, blue: Int): Int {
    return (red + green + blue) / 3
}