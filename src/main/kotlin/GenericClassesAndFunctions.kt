import java.util.*

fun <T : Comparable<T>> maxOfTwo(first: T, second: T): T = if (first > second) first else second

class Box<T>(var value: T) {
    fun get() = value
    fun set(value: T) {
        this.value = value
    }
}

class GenericStack<T> : Stack<T>() {
    override fun pop(): T? = if (super.isEmpty()) null else super.pop()
    override fun peek(): T? = if (super.isEmpty()) null else super.peek()
}

fun main() {
    val stringStack = GenericStack<String>()
    stringStack.push("First")
    stringStack.push("second")
    stringStack.peek()
    assert(stringStack.size() == 2)
}

operator fun Int.invoke(): Int = this

