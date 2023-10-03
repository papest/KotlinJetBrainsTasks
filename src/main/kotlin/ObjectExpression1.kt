open class MyClass {
    open fun myMethod() {
        println("My method")
    }
}

val obj = object : MyClass() {
    override fun myMethod() {
        println("Hello, Kotlin!")
    }
}

fun main() {
    obj.myMethod()
}