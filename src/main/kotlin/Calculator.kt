abstract class Calculator(val left: Int, val right: Int) {
    abstract fun perform(): Int
}

class Add(left: Int, right: Int) : Calculator(left, right) {
    override fun perform() = left + right

}

class Multiply(left: Int, right: Int) : Calculator(left, right) {
    override fun perform() = left * right

}

fun main() {
    val left = readln().toInt()
    val right = readln().toInt()

    println(Add(left, right).perform())
    println(Multiply(left, right).perform())
}

