package repetition

fun reverseSentence(sentence: String): String {
    val words = sentence.split(" ")

    return buildString {
        words.reversed().forEach { append(it).append(" ") }
    }.trim()
}
