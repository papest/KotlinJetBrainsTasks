class CounterThread : Thread() {
    @Volatile
    var counter: Long = 0
    override fun run() {
        val thread = currentThread()
        while (true) {
            counter++
            if (thread.isInterrupted) {
                println("It was interrupted")
                break
            }
        }
    }
}

fun main() {
    with(CounterThread()) {
        start()
        Thread.sleep(10)
        interrupt()
        println(counter)
    }
}