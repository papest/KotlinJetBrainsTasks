package repeat

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun printIncrement(value: Int?) {
    val x: Int? = value
    if (x.isPositive()) {
        println(x + 1)
    } else {
        println("Can't increment a negative value")
    }
}

@OptIn(ExperimentalContracts::class)
fun Int?.isPositive(): Boolean {
    contract {
        returns(true) implies (this@isPositive != null)
    }
    return this != null && this >= 0
}