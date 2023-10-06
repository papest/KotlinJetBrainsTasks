package repeat

fun main() {
    val runnable = object : Runnable {
        override fun run() {
            println("I am running in ${Thread.currentThread().name}")
        }
    }
    runnable.run()
    Thread(runnable).start()
}