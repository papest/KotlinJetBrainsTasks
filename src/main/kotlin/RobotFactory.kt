import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

@Suppress("MagicNumber")
suspend fun simulateFactory(): List<Int> = withContext(Dispatchers.Default) {
    val result = ArrayList<Int>()
    val channel = Channel<Int>()
    var i = 1
    val sendJob = launch {
        while (true) {
            delay(100)
            channel.send(i++)
        }
    }

    val receiveJob = launch {
        while (true) {
            delay(1)
            result.add(channel.receive())
        }
    }

    launch {
        delay(1100)
        receiveJob.cancel()
        sendJob.cancel()
        channel.close()
    }
    result
}

suspend fun main() {
    println(simulateFactory())
}
