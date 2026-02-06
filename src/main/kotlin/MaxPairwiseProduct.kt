fun main() {

    List(readln().toInt()) { readln().toInt() }
        .sorted()
        .reversed()
        .run {
            println(if (size == 1) first() else first() * this[1])
        }
}