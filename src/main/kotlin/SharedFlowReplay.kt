import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>(
        replay = 5,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    launch {

        for (i in 1..20) {
            sharedFlow.emit(i)
            delay(100)
        }
    }

    delay(1000)

    val collectJob: Job = launch {
        sharedFlow.collect { value ->
            println("Collected value: $value")
        }
    }

    delay(2500)
    collectJob.cancel()
}
