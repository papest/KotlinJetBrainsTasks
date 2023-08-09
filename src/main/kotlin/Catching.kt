fun main() {
    val input = readln()
    try {

        val list = input.split(",")
        if (list == listOf("")) {
            throw IllegalArgumentException()
        }
        val numbers = list.map { it.toInt() }
        val average = numbers.average()
        println(average)

    } catch (e: Exception) {
        println(
            when (e) {
                is NumberFormatException -> "Invalid input!"
                is IllegalArgumentException -> "Cannot calculate average of an empty list!"
                else -> "An error occurred!"
            }
        )
    }
}