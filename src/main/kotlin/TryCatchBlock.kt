import java.lang.NumberFormatException

fun main() {
    val strNumber = readln()
    println(
        try {
            strNumber.toInt()
            "Operation successful"
        } catch (e: NumberFormatException) {
            "Operation failed: Non-numeric string"
        } catch (e: Throwable) {
            "Operation failed: Unexpected error"
        }
    )
}