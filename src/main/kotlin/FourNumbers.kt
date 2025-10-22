import java.io.File

fun main() {
    val text = File("src/main/resources/hyperskill-dataset-117253802.txt").readText()
    val map = mutableMapOf<Int, Int>()
    for (char in text) {
        try {
            val key = char.digitToInt()
            map.merge(key, 1, ::sum)
        } catch (e: Exception) {
//            println(e.message)
//            println( "Char - ${
//                char.code} ")
        }
    }
    println(map
        .entries
        .sortedByDescending { entry -> entry.value * 100 + entry.key }
        .slice(0..3)
        .map { entry -> entry.key }
        .toString()
        .replace(Regex("[ ,\\[\\]]"), ""))
}
