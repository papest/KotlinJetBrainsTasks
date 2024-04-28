package repeat

import java.util.*

fun main() {
    val encodedUri = readln()
    println(String(Base64.getDecoder().decode(encodedUri)))
}

