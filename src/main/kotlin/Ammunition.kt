data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val am = shipsList.map { it.ammunition }
    val res = "${am.distinct().count()}:${am.sum()}:${am.average()}"
    println(res)
}
