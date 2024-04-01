import java.util.*


fun main() {
    val text = "Comment vas-tu?!"
    println(Base64.getEncoder().encodeToString(text.toByteArray()))
}
