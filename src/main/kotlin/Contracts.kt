import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun String?.isBlankOrNull(): Boolean {
    contract {
        returns(false) implies (this@isBlankOrNull != null)
    }
    return this == null || this.isBlank()
}

fun printLength(s: String?) {
    if (!s.isBlankOrNull()) println(s.length)
}

@OptIn(ExperimentalContracts::class)
fun myRun(block: () -> Unit) {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    block()
}

fun square(value: Int) {
    val x: Int

    myRun {
        x = value
    }

    println(x * x)
}

fun main() {
    printLength(readln())
    square(5)
}