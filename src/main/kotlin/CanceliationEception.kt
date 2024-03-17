import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun cancellationException() = runBlocking {
    runCatching {
        throw CancellationException("cancellation exception")
    }.onFailure {
        println("Caught ${it.message}")
    }
}

fun main() {
    cancellationException()
}
