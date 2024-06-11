package repeat

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val input = reader.readLine().split(" ").map(String::toInt)

    val printArraySum: (List<Int>) -> Unit = { println(it.sum()) }
    printArraySum(input)
}