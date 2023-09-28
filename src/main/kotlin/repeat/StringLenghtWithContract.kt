package repeat

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun strLength(value: Any?): Int {
    return if (value.isString()) {
        value.length
    } else {
        0
    }
}

@OptIn(ExperimentalContracts::class)
fun Any?.isString(): Boolean {
    contract {
        returns(true) implies (this@isString is String)
    }
    return this is String
}