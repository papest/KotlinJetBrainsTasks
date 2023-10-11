import java.lang.Thread.sleep
import java.util.concurrent.*

val executor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

fun alarm(): ScheduledFuture<*> {
    println("It's time to get up!")
    var count = 0
    return executor.scheduleAtFixedRate({
        count++
        println("You overslept by $count seconds, it's time to get up!")
    }, 1, 1, TimeUnit.SECONDS)
}

fun main() {
    val future = alarm()
    sleep(5000)
    future.cancel(true)
    executor.shutdownNow()
}