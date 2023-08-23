package repetition

fun main() {
    println(
        with(readln()) {
            if (toInt() < 0) length - 1 else length
        }
    )
}