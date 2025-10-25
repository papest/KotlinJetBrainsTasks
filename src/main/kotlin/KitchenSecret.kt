import java.io.File

enum class Direction(val deltaX: Int, val deltaY: Int) {
    UP(0, -1),
    DOWN(0, 1),
    RIGHT(1, 0),
    LEFT(-1, 0);
}

fun getChar(line: String): Char {
    val desk = arrayOf(
        "ABCD",
        "EFGH",
        "IJKL",
        "MNOP"
    )
    val sizeX = desk[0].length
    val sizeY = desk.size
    var x = 0
    var y = 0

    line
        .split(",")
        .forEach {
            if (it.isNotEmpty()) {
                val dir = Direction.valueOf(it)
                x = (x + dir.deltaX).coerceIn(0 until sizeX)
                y = (y + dir.deltaY).coerceIn(0 until sizeY)
            }
        }
    return desk[y][x]

}

fun main() {

    File("src/main/resources/hyperskill-dataset-117354503.txt")
        .readLines()
        .forEach {
            getChar(it)
                .also { char -> print(char) }
        }
}


