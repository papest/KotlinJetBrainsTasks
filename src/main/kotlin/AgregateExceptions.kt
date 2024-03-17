import kotlinx.coroutines.*

suspend fun aggregateExceptions() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("${exception.message} caught")
        exception.suppressed.forEach {
            println("${it.message} caught")
        }
    }
    val cs = CoroutineScope(Job() + handler)
    val job = cs.launch {

        launch {
            delay(1)
            throw Exception("Primary exception")
        }
        launch {
            delay(2)
            throw Exception("Suppressed exception")
        }
    }
    job.join()
}

suspend fun main() {
    aggregateExceptions()
}
