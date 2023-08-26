package repetition

import java.lang.ArithmeticException

fun main() {
    val numerator = readln()
    val denominator = readln()
    try {
        val result = numerator.toInt() / denominator.toInt()
        println(result)
    } catch (e: IllegalArgumentException) {
        println("Numerator and denominator must be valid integers.")
    } catch (e: ArithmeticException) {
        println(if (denominator == "0") "Cannot divide by zero!" else e.message)
    } catch (e: Exception) {
        println(e.message)
    }
}