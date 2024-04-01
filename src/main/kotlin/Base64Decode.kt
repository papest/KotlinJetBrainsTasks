import java.util.*

fun main() {
    val encodedText = "Q8OzbW8gZXN0w6E/"
    println(String(Base64.getDecoder().decode(encodedText)))
}
