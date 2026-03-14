fun main() {

    readln()
        .split(" ")
        .maxByOrNull { it.length }
        .also { println(it) }
}