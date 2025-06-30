package repeat

fun calculateRank(weight: Int) =
    when {
        weight < 30 -> 1
        weight < 50 -> 2
        weight < 70 -> 3
        else -> 4
    }

fun main() {

    val weight = readln().toInt()
    println(calculateRank(weight))
}

