fun getCombination(codes: List<String>): ArrayDeque<String> {
    val deque = ArrayDeque<String>()
    deque.addAll(codes.reversed())
    return deque
}

fun main() {
    println(getCombination(readln().split(" ")))
}

