fun bigFunction(num: Int, func: (Int, Int) -> (Int)): ((Int) -> Int) {
    return { a: Int -> func(num, a) }
}

fun multi(a: Int, b: Int) = a * b
fun sum(a: Int, b: Int) = a + b

fun main() {
    val identity = bigFunction(1, ::multi)
    val triple = bigFunction(3, ::multi)
    val same = bigFunction(0, ::sum)
    val increment = bigFunction(1, ::sum)

    println(identity(7))
    println(triple(7))
    println(same(7))
    println(increment(7))
}