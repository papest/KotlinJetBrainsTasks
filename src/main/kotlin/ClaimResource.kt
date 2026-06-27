import kotlinx.atomicfu.atomic

val flag = atomic(false)
fun tryClaim() = if (flag.compareAndSet(expect = false, update = true)) "Claimed" else "Already claimed"

fun main() {
    println(tryClaim())
    println(tryClaim())
    println(tryClaim())
}