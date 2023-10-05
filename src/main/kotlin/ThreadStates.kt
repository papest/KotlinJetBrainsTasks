fun printNameOfTerminatedThread(threads: List<Thread>) =
    threads.first { it.state == Thread.State.TERMINATED }
        .also { println(it.name) }

fun createThreadInNewState() = Thread()
fun findAndStartThread(threads: List<Thread>) =
    threads.firstOrNull { it.state == Thread.State.NEW }
        .run {
            if (this != null) {
                start()
                join()
            }
        }
