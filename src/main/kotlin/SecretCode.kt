@JvmInline
value class SecretCode(val value: String)

fun main() {
    val code = SecretCode(readln())
    println(code.value)
}