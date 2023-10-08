import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

data class Message(val from: String, val to: String, val text: String)

interface AsyncMessageSender {
    fun sendMessages(messages: List<Message>)
    fun stop()
}

class AsyncMessageSenderImpl(val repeatFactor: Int) : AsyncMessageSender {
    val executor: ExecutorService = Executors.newFixedThreadPool(2)

    override fun sendMessages(messages: List<Message>) {
        for (msg in messages) {
            repeat(repeatFactor) {
                executor.submit {
                    println("(${msg.from}>${msg.to}): ${msg.text}")
                }
            }
        }
    }

    override fun stop() {
        executor.shutdown()
        if (executor.awaitTermination(1000, TimeUnit.MICROSECONDS)) println("Completed.")
    }
}

fun main() {
    val sender: AsyncMessageSender = AsyncMessageSenderImpl(3)

    val messages: List<Message> = listOf(
        Message("John", "Mary", "Hello!"),
        Message("Clara", "Bruce", "How are you today?")
    )

    sender.sendMessages(messages)
    sender.stop()

    notifyAboutEnd() // it prints something after the sender successfully stops
}

fun notifyAboutEnd() {
    println("The end")
}
