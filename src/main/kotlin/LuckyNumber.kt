fun main() {
    with(readln())
    {
        windowed(
            length / 2, length / 2
        )
        { it.sumOf { i -> i.digitToInt() } }
            .run {
                println(if (first() == last()) "YES" else "NO")
            }
    }
}