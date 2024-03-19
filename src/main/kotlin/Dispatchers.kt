import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking(Dispatchers.Default) {
    // Modify this code to make sure data loading and storing
    // happens in Dispatchers.IO, but data printing in Dispatchers.Default
    // which is already defined for you as a replacement for Dispatchers.Main
    val mainJob = launch (Dispatchers.IO) {
        val data = loadData1()

       val job = launch (Dispatchers.Default) { printData(data)}
        job.join()
        storeData(data)
    }
    mainJob.join()
}

suspend fun printData(data: CoroutineContext) {
    delay(3)
    println(currentCoroutineContext())
    println(data)
}

suspend fun storeData(data: CoroutineContext) {
    delay(3)
    println("Store..")
    println(currentCoroutineContext())
}

suspend fun loadData1() : CoroutineContext {
    return currentCoroutineContext()
}
