abstract class Polygon : Shape() {
    abstract override fun calculateArea(): Double
    abstract override fun calculatePerimeter(): Double
}

open class Shape {
    open fun calculateArea(): Double {
        return 0.0
    }

    open fun calculatePerimeter(): Double {
        return 0.0
    }
}

class Rectangle(val width: Double, val length: Double) : Polygon() {
    override fun calculateArea(): Double {
        return length * width
    }

    override fun calculatePerimeter(): Double {
        return 2 * (length + width)
    }
}

fun main() {
    val width = readln().toDouble()
    val length = readln().toDouble()

    val rectangle = Rectangle(width, length)

    println("Area = ${rectangle.calculateArea()}")
    println("Perimeter = ${rectangle.calculatePerimeter()}")
}