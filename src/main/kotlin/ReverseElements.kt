fun main() {
    readln()
        .split(" ")
        .reversed()
        .also { println(it.joinToString(" ")) }
}