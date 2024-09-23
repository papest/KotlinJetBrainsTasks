fun main() = print(readln().split(" ").mapIndexed { i, s -> (i + 1) % 2 * s.length }.sum())

