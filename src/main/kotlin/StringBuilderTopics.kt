fun upperEvenLetters(message: String): String = buildString {
    append(message)
    for (i in indices step 2) {
        setCharAt(i, get(i).uppercaseChar())
    }
}

/**
 * As part of his training, Neo needs to decode a series of encoded messages. You have been asked to help him and write a program that uses StringBuilder or buildString to decode the messages. The program should iterate over the encoded message and perform the following:
 * Check if the character is a vowel. If it is, append it to the decoded message.
 * If the character is not a vowel, check if it is a lowercase letter. If it is, append the uppercase version of it to the decoded massage.
 * If the character is neither a vowel nor a lowercase letter, discard it.
 */

fun decodeMessage(encodedMessage: String) = buildString {
    val vowels = "aeiouAEIOU"
    for (ch in encodedMessage) {
        if (vowels.contains(ch)) {
            append(ch)
            continue
        }
        if (ch.isLowerCase()) append(ch.uppercaseChar())
    }
}

