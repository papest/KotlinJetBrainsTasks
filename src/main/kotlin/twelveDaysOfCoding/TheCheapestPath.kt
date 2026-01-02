package twelveDaysOfCoding

import java.io.File
import java.util.Scanner
import kotlin.math.min

fun main() {
    val sc = Scanner(File("src/main/resources/hyperskill-dataset-119160051.txt"))
    sc.useDelimiter("[,\n]")
    val inList = List(20) { List(20) { sc.nextInt() } }
    val matrix = List(20) { MutableList(20) { 0 } }
    matrix[0][0] = inList[0][0]
    for (i in 1..19) {
        matrix[0][i] = matrix[0][i - 1] + inList[0][i]
    }
    for (j in 1..19) {
        matrix[j][0] = matrix[j - 1][0] + inList[j][0]
    }
    for (j in 1..19) {
        for (i in 1..19) {
            matrix[j][i] = min(matrix[j - 1][i] + inList[j][i], matrix[j][i - 1] + inList[j][i])
        }
        for (i in 18 downTo 0) matrix[j][i] = min(matrix[j][i], matrix[j][i + 1] + inList[j][i])

    }
    println(matrix[19][19])
}

