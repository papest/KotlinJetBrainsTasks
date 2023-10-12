package repeat

abstract class AnotherShape {
    abstract fun calculateArea(): Double
    abstract fun calculatePerimeter(): Double

    fun printDescription() {
        println("This is a shape.")
    }
}

class AnotherSquare(private val side: Double) : AnotherShape() {
    override fun calculateArea(): Double = side * side
    override fun calculatePerimeter(): Double = 4 * side
}

fun main() {
    val square = AnotherSquare(readln().toDouble())
    println("Area = ${square.calculateArea()}")
    println("Perimeter = ${square.calculatePerimeter()}")
}

