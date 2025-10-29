import java.io.File

fun main() {

    File("src/main/resources/hyperskill-dataset-117473337.txt")
        .readLines()[0]
        .split(" ")
        .groupBy {
            it.asSequence().sorted()
                .joinToString("")
        }
        .filter { it.value.size == 1 }
        .values
        .stream()
        .findFirst()
        .get()
        .also { print(it[0]) }

}
