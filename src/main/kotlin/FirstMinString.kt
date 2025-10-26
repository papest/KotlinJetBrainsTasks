import java.io.File

fun main() {

    val text = File("src/main/resources/hyperskill-dataset-117379524.txt")
        .readText()
        .replace("\n", "")
    var s: String? = null
    var j = 7
    while (s == null && j <= text.length) {

        s = text
            .windowedSequence(j, 1)
            .filter { it.chars().distinct().count() == 7L }
            .firstOrNull()
        j++
    }
    println(s)
}

