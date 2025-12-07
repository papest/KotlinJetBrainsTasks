fun power(base: Int): (Int) -> (Int) =
    { exponent -> Math.pow(base.toDouble(), exponent.toDouble()).toInt() }

fun main() {
    println(power(3)(2))
}