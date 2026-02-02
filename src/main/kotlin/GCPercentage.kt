fun main() {
    with(readln()) {
        println((1 - replace(Regex("[gGcC]"), "").length.toDouble() / length) * 100)
    }
}