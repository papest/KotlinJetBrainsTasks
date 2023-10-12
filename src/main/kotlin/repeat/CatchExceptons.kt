package repeat

fun main() {
    val input = readlnOrNull()
    try {
        with(input) {
            if (this == null) throw Exception()
            this.toInt()
        }.run {
            require(this >= 0)
            println(this * this)
        }
    } catch (e: Exception) {
        when (e) {
            is NumberFormatException -> println("The input must be a valid integer.")
            is IllegalArgumentException -> println("The number must be non-negative.")
            else -> println("Unknown error has happened!")
        }
    }
}