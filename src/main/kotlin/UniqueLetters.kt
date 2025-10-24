import java.io.File

fun main() {

    val text = File("src/main/resources/hyperskill-dataset-117317652.txt").readText()
    val map = mutableMapOf<Char, Int>()
    for (char in text) {
        map.merge(char, 1, ::sum)
    }

    map
        .entries
        .filter { it.value == 1 }
        .map { it.key }
        .toString()
        .replace(Regex("[ ,\\[\\]]"), "")
        .also { println(it) }
}

