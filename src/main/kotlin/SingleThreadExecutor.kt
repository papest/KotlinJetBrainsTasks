import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val messageCounts: Int = readln().toInt()
    val messages: MutableList<String> = mutableListOf()
    for (i in 0 until messageCounts) {
        messages.add(readln())
    }
    val sender: MailSender = MockMailSender()
    asyncSend(sender, messages)
}

const val TIMEOUT = 3L
fun asyncSend(sender: MailSender, messages: List<String>) {
    val executor = Executors.newSingleThreadExecutor()
    messages.forEach { executor.submit { sender.send(it) } }
    executor.shutdown()
    executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)
}

interface MailSender {
    fun send(message: String)
}

class MockMailSender : MailSender {
    override fun send(message: String) {
        println("Message $message was sent")
    }
}