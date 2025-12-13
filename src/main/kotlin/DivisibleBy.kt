fun main() {
    with(readln().toInt()) {
        for (i in arrayOf(2, 3, 5, 6)) if (this % i == 0) println("Divisible by $i")
    }
}
