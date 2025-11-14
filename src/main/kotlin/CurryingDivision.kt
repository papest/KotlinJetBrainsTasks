fun divide(i: Int): (Int) -> Double = { j -> i.toDouble() / j }
fun main() {
    println(divide(10)(3))
}