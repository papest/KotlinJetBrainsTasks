import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

@Suppress("MagicNumber")
suspend fun simulateWarehouse(): List<Int> = withContext(Dispatchers.Default) {
    val channel = Channel<Int>(5)
    launch {
        for (i in 1..20) {
            channel.send(i)
            delay(100)
        }
    }

    val boxes = List(20) {
        withContext(Dispatchers.Default) {
            channel.receive()
        }
    }
    channel.close()
    boxes
}

suspend fun main() {
    println(simulateWarehouse())
}
