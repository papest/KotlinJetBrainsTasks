package repeat

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required


fun checkWords(args: Array<String>) {
    val parser = ArgParser("Number Parser")
    val text by parser.option(ArgType.String).required()
    parser.parse(args)
    if (text == text.reversed()) {
        println("$text is a palindrome")
    } else {
        println("$text is not a palindrome")
    }
}