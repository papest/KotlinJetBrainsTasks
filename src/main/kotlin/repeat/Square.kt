package repeat

abstract class Shape {
    abstract val area: Double
}

class Square(val side: Double) : Shape() {
    override val area: Double
        get() = side * side
}