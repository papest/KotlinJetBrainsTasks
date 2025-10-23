import java.io.File

fun main() {
    File("src/main/resources/hyperskill-dataset-117285456.txt")
        .readText().split(",")
        .sumOf { it.replace("\n", "").toInt() }
        .also {
            println(if (it < 0) it % 360 + 360 else it % 360)
        }
}
