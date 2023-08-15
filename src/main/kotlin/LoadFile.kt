import kotlinx.coroutines.*
import kotlin.random.Random

const val LOAD_DELAY = 9000L
const val PRINT_DELAY = 1000L

fun doAllTheJob1() {
    GlobalScope.launch {
        printProgress()
    }
    runBlocking {
        loadData()
    }
}

suspend fun loadData() {
    delay(LOAD_DELAY)
}

suspend fun printProgress() {
    while (true) {
        repeat(Random.nextInt(1, 7)) { print("*") }
        delay(PRINT_DELAY)
    }
}

fun main() {
    doAllTheJob1()
}
