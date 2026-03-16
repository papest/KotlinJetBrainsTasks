fun main() {
    readln()
        .apply {
            println(removeRange(length / 2 - 1 + length % 2, length / 2 + 1))
        }
}