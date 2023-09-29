package repeat

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

fun getArgs(args: Array<String>): Int {
    val parser = ArgParser("Number parser")
    val num by parser.option(ArgType.Int).required()
    parser.parse(args)
    return num
}
