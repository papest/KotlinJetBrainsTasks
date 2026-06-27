import kotlinx.atomicfu.AtomicInt
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.getAndUpdate

fun safeDecrement(atomicInt: AtomicInt): Int =
    with(atomicInt.getAndUpdate { if (it > 0) it - 1 else it }) { if (this > 0) this - 1 else -1 }

fun main() {
    println(safeDecrement(atomic(0)))
    println(safeDecrement(atomic(2)))
    println(safeDecrement(atomic(-1)))
}