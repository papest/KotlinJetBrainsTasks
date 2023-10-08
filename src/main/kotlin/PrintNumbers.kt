import java.lang.Thread.sleep

class PrintNumbers : Runnable {

    override fun run() {
        val thread = Thread.currentThread()
        var count = 0
        while (!thread.isInterrupted)
            try {
                println(count)
                count = ++count % 10
                sleep(1000)

            } catch (e: InterruptedException) {
                break
            }
    }
}

fun main() {
    with(Thread(PrintNumbers())) {
        start()
        sleep(20000)
        interrupt()

    }
}