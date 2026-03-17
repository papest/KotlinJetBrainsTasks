import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    val gen = Random(seed)
    return List(10) { gen.nextInt(33, 127).toChar() }.joinToString("")
}

fun main() {
    println(generatePredictablePassword(55))
}