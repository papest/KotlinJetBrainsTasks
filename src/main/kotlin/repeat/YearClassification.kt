package repeat

import kotlin.system.exitProcess

fun main() {
    val year = readln().toIntOrNull()
    if (year == null) {
        println("Invalid input. Please enter a valid year.")
        exitProcess(1)
    }

    classifyYear(year)
}

const val VINTAGE = 1980
const val MODERN = 1999
fun classifyYear(year: Int) {
    println(if (year < VINTAGE) "Vintage" else if (year > MODERN) "Modern" else "Classic")
}
