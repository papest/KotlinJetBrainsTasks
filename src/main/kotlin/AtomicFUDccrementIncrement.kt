import kotlinx.atomicfu.atomic

private val counter1 = atomic(0)

fun decrement() {
    counter1.decrementAndGet()
}

fun increment() {
    counter1.incrementAndGet()
}

fun getCounterValue() = counter1.value
@Suppress("MagicNumber")
fun counterIsZero() {
    val threads = List(10) {
        Thread {
            repeat(100) {
                increment()
            }
        }
    } + List(10) {
        Thread {
            repeat(100) {
                decrement()
            }
        }
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }
    println(getCounterValue())
}

fun main() {
    counterIsZero()
}
