fun main() {
    val n = readln().toInt()
    println(with(Array(2) { readln().toInt() }) {
        sort()
        n in get(0)..get(1)
    })
}