package twelveDaysOfCoding

import java.io.File

var count = 0

class Fork(val number: Int, var owner: String = "") {
    val map = mapOf(Pair("pick", ::pick), Pair("release", ::release))
    fun pick(newOwner: String) {

        if (newOwner != owner && owner.isNotEmpty()) count++ else owner = newOwner
    }

    fun release(newOwner: String) {
        if (newOwner == owner) owner = ""
    }
}

fun main() {
    val forks = List(4) { Fork(it + 1) }

    File("src/main/resources/hyperskill-dataset-119032493.txt")
        .readText()
        .split("\n")
        .forEach {
            if (it.isNotEmpty()) {
                it
                    .split(",")
                    .also {
                        forks[it[2].toInt() - 1].map[it[1]]
                            .also { i -> i?.invoke(it[0]) }
                    }
            }
        }
    println(count)
}