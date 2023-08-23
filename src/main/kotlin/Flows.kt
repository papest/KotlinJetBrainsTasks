import kotlinx.coroutines.flow.*

suspend fun main() {
    val intFlow = flowOf(0).transform {
        var value = it
        while (true) {
            emit(value++)
        }
    }
    val intFlow1 = (0..Int.MAX_VALUE).asFlow()

    val flow = intFlow.filter { it > 99 && it % 2 == 0 }.take(10).map { it.toString(16) }
    flow.collect { print(it) }

    intFlow1.map { it * 20 }.take(20).collect { println(it) }
}