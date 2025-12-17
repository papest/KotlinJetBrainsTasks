fun main() {
    with(readln().toInt()) {
        println(if (this % 4 == 0 && (this % 100 != 0) || (this % 400 == 0)) "Leap" else "Regular")
    }
}

