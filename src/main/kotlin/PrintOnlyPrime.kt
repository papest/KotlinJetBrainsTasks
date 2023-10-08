import java.math.BigInteger
import java.util.concurrent.*

fun main() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()
    val numbers: List<Int> = readln().split(" ").map { el -> el.toInt() }

    for (number in numbers) {
        executor.submit(PrintIfPrimeTask(number))
    }
    executor.shutdown()
    if (executor.awaitTermination(1000, TimeUnit.MICROSECONDS)) println("Completed.")
}

class PrintIfPrimeTask(private val number: Int) : Runnable {
    override fun run() {
        if (BigInteger(number.toString()).isProbablePrime(1000)) println(number)
    }
}
