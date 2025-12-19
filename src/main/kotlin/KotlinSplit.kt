fun main() {
    val string = readln()
    val n = readln().toInt()
    println(string.split(Regex(" +"), limit = n).joinToString("\n"))
}