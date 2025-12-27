package twelveDaysOfCoding

import java.io.File
import java.util.*

fun main() {
    val list =
        File("src/main/resources/hyperskill-dataset-119005701.txt")
            .readText()
            .split("\n")
            .map { Pair(it, securityScore(it)) }
    list
        .first { i -> i.second == list.maxOf { it.second } }
        .also { println(it) }
}

fun coefficient(pass: String): (String) -> Double = { x -> if (pass.contains(x.toRegex())) 1.0 else 0.75 }

fun securityScore(pass: String): Double {
    if (pass.isEmpty()) return 0.0
    val co: (regex: String) -> Double = coefficient(pass)

    var result = pass.length * co("[a-z]") * co("[A-Z]") * co("[0-9]") * co("[!@#\$%^&*]")
    result -=
        pass
            .map { Collections.frequency(pass.toList(), it) }
            .maxOf { it } - 1.0
    return result
}

