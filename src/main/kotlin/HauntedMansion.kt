import java.util.Scanner

fun calculateGhosts(rooms: Int, ghosts: Int = 2) = rooms * ghosts

fun main() {
    val scanner = Scanner(System.`in`)
    val rooms = scanner.nextInt()
    println(if (scanner.hasNextInt()) calculateGhosts(rooms, scanner.nextInt()) else calculateGhosts(rooms))

}
