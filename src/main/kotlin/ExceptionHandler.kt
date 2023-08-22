import kotlinx.coroutines.*
import java.lang.Exception

// Define a proper scope here
// Don't ignore the error only log them
private val handler = CoroutineExceptionHandler { _, exception ->
    println("Error: ${exception.message}")
}

private val mainScope = CoroutineScope(handler)

suspend fun main() {
    // we load data in the main scope
    // make the scope log errors thrown by `loadData`
    // no need to modify this code
    mainScope.loadData("http://url1").join()
    mainScope.loadData("http://url2").join()
    mainScope.launch {
        throw Exception("Handler test")
    }
    delay(200)
}

fun CoroutineScope.loadData(html: String) = launch {
    println("Loaded data from $html")
}
