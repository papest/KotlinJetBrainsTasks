import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

fun parser(args: Array<String>) {
    val parser = ArgParser("Number Parser")
    val num1 by parser.option(ArgType.Int).required()
    val num2 by parser.option(ArgType.Int).required()
    parser.parse(args)
    println("The sum is: ${num1 + num2}")
}

fun main(args: Array<String>) {
    parser(args)
}