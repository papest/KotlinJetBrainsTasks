fun main() {
    val floorNumber = readln().toInt()
    println(
        when (floorNumber) {
            in 13..18, in 21..25 -> "Boo!"
            else -> "Safe"
        }
    )
}
