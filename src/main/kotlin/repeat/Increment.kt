package repeat

interface Increment {
    fun increment()
}

class IncrementHandler(private val counter: Counter) : Increment {
    override fun increment() {
        counter.count++
    }
}

class Counter(var count: Int, incrementHandlerFactory: (Counter) -> Increment) : Increment {

    private val incrementHandler: Increment = incrementHandlerFactory(this)

    override fun increment() {
        incrementHandler.increment()
    }
}

fun main() {
    val counter = Counter(0) { IncrementHandler(it) }
    for (i in 1..5) {
        counter.increment()
        println("Count: ${counter.count}")
    }
}