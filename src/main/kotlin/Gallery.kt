import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

@Suppress("MagicNumber")
suspend fun simulateGallery(): List<Int> = withContext(Dispatchers.Default) {
    val channel = Channel<Int>(Channel.CONFLATED)
    var i = 1
    launch {

        repeat(10) {
            channel.send(i++)
            delay(100)
        }
    }

    val galleryList = List(10) {
        withContext(Dispatchers.Default) {
            channel.receive()
        }
    }
    galleryList
}

suspend fun main() {
    println(simulateGallery())
}