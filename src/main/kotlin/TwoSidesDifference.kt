import java.io.File

fun main() {
    File("src/main/resources/hyperskill-dataset-117522363.txt")
        .readLines()
        .forEach {
            val sl = it.substring(0..7).toMutableList()
            val sr = it.substring(8..15).toMutableList()
            val iterator = sl.iterator()

            while (iterator.hasNext()) {

                val char = iterator.next()

                if (sr.contains(char)) {

                    iterator.remove()
                    sr.remove(char)
                }
            }
            print("${sl[0]}${sr[0]}")
        }
}

