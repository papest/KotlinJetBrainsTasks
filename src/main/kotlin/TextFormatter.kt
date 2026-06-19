class TextFormatter {
    var text: String = ""
        set(value) {
            field = value
                .replace(Regex("[0-9]"), "")
                .lowercase()
            println(text)
        }
}


fun main() {
    TextFormatter().text = "Remember, remember, the 5th of month 11"

}