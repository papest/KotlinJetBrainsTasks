fun main() {
    val st = readln()
    val subSt = readln()

    st
        .windowed(subSt.length, 1)
        .filter { it == subSt }
        .size
        .also { println(it) }
}