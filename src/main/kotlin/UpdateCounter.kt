import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.updateAndGet

class UpdateCounter {
    private val counter = atomic(1)

    fun updateBasedOn(input: Int) = counter.updateAndGet { it + if (input % 2 == 0) input + input else 1 }

}

fun main() {
    with(UpdateCounter()) {
        println(updateBasedOn(15))
        println(updateBasedOn(6))
    }
}