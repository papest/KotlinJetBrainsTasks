fun main() {
    val n = readln()
    if (n.replace("[0-9]".toRegex(), "").isNotEmpty()) println("Wrong Type")
    println(n)
}