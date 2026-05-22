import kotlinx.coroutines.*
import java.io.IOException

fun nestedExceptions() = runBlocking {
    val handler = CoroutineExceptionHandler { _, _ ->
        println("Nested exception caught")
    }
    val scope1 = CoroutineScope(Job())
    val scope2 = CoroutineScope(Job())
    scope2.launch {
        scope1.launch(handler) {
            throw IOException()
        }.join()
    }.join()
}

fun main() {
    nestedExceptions()
}
