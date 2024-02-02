import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.updateAndGet

val counter = atomic(0)
val countTrueCompare = atomic(0)

fun incrementWhenEven() {
    val currentValue = counter.value
    if (currentValue % 2 == 0)
        if (counter.compareAndSet(currentValue, currentValue + 1)) {
            countTrueCompare.incrementAndGet()
        }
}

fun incrementCounter(): Int {
    return counter.getAndIncrement()
}

fun updateValue(): Int {
    return counter.updateAndGet { it + 1 }
}

fun main() {
    val threads = List(10) {
        Thread {
            incrementWhenEven()
            println("${Thread.currentThread().name} : ${incrementCounter()}")
            println("${Thread.currentThread().name} : ${updateValue()}")
        }
    }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
    println("Final counter value: ${counter.value}")
    println("Final countTrueCompare: ${countTrueCompare.value}")
}


