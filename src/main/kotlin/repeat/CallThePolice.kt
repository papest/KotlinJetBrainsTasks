package repeat

import kotlinx.coroutines.delay

suspend fun call() {
    println("Call the police!")
    delay(5)
}

suspend fun main() {
    call()
}