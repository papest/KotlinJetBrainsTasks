fun main() {
    var text = readln()
    text = text
        .replace(Regex("\\b(Am|A|Em|E|Dm|D|G|C)\\b ?"), "")
    println(text)
}
