import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun doAllTheJob() {
    println("Working...")

    val firstJob = GlobalScope.launch {
        doLotsOfWork1() // 5 ms
    }

    val secondJob = GlobalScope.launch {
        doLotsOfWork2() // 5 ms
    }

    runBlocking {
        firstJob.join()
        secondJob.join()
    }

    println("Finishing")
}

suspend fun doLotsOfWork2() {
    delay(5000)
    println("work2")
}

suspend fun doLotsOfWork1() {
    delay(5000)
    println("work1")
}

fun main() {
    doAllTheJob()
}
