import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NotificationManager {
    private val _notifications = MutableStateFlow<List<String>>(emptyList())
    val notifications = _notifications.asStateFlow()
    fun addNotification(notification: String) {
        _notifications.value += notification
    }
}

fun main() = runBlocking<Unit> {

    val notificationManager = NotificationManager()
    val senderJobA = launch {
        notificationManager.addNotification("User A sent a message")
    }
    val senderJobB = launch {
        delay(500)
        notificationManager.addNotification("User B upload a photo")
    }
    val senderJobC = launch {
        delay(1000)
        notificationManager.addNotification("User C commented of your post")
    }
    val collectorJob = launch {
        notificationManager.notifications.collect { notifications ->
            println("New notifications: $notifications")
        }
    }


    joinAll(senderJobA, senderJobB, senderJobC)
    delay(1000)
    delay(1000)
    collectorJob.cancel()
}