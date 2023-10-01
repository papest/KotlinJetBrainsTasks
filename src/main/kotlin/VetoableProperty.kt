import kotlin.properties.Delegates

class Counter {
    var maxCount: Int = 0

    var count: Int by Delegates.vetoable(0) { _, _, new ->
        new <= maxCount
    }
}

fun main() {
    val counter = Counter()
    val maxCount = readln().toInt()
    counter.maxCount = maxCount
    counter.count = 101
    print("${counter.count} ")

    for (i in maxCount - 2..maxCount + 2) {
        counter.count = i
        print("${counter.count} ")
    }
}
