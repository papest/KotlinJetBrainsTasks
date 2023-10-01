class Square(private val x: Double) {
    val area: Double by lazy {
        print("First time: ")
        x * x
    }
}

fun main() {
    val square = Square(5.0)
    println(square.area)
    println(square.area)
    println(Square(3.0).area)
}