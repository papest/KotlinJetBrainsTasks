import kotlinx.coroutines.delay
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@Suppress("MagicNumber")
suspend fun bakeCake() {
    println("I'm a cyber baker. I'm starting to bake fast!")
    delaySeconds(5)
    println("The cake is ready!")
}

suspend fun delaySeconds(i: Int) {
    delay(1000L * i)
}

@Suppress("MagicNumber")
fun main() {
    runBlocking {
        repeat(3) {
            async {
                bakeCake()
            }
        }
    }
}