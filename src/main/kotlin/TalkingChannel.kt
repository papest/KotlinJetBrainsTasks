import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.withContext

suspend fun main() {
    val channel = Channel<String>(Channel.UNLIMITED)
    sender(channel)
    sender(channel)
    receiver(channel)
    receiver(channel)
}

suspend fun sender(channel: Channel<String>) = withContext(Dispatchers.Default) {
    channel.send(readln())
}

suspend fun receiver(channel: Channel<String>) = withContext(Dispatchers.Default) {
    println("Message received: ${channel.receive()}")
}
