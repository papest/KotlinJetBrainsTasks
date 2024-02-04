package repeat

fun interface Operation {
    fun execute(a: Int, b: Int): Int
}

fun performOperation(a: Int, b: Int, operation: Operation) = operation.execute(a, b)
