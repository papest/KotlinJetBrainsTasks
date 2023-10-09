import java.util.concurrent.*

fun howManyIsDone(items: List<Future<Int>>): Int = items.count { it.isDone }
fun executeCallableObjects(items: List<Future<Callable<Int>>>): Int = items.reversed()
    .sumBy { it.get().call() }

fun determineCallableDepth(callable: Callable<*>): Int {
    var count = 1
    var callable = callable

    while (true) {
        val a = callable.call()
        if (a is Callable<*>) {
            count++
            callable = a
        } else break
    }
    return count
}

fun getCallable() = Callable { readln() }
fun getCallableIntList() = readln().split(" ").map { Callable { it.toInt() } }

fun transactionSystem(transactions: List<Callable<Int>>): Int {
    val executor = Executors.newFixedThreadPool(4)
    var sum = 0
    for (transaction in transactions) {
        val a = executor.submit(transaction)
        val res = a.get()
        if (res + sum >= 0) {
            sum += res
        } else break
    }
    executor.shutdown()
    return sum
}

fun main() {
    println(transactionSystem(getCallableIntList()))
}