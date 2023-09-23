import kotlin.reflect.full.memberFunctions

class TestClass {
    fun sayHello() {
        println("Hello, Reflection!")
    }
}

fun callFunction(instance: Any, functionName: String) {
    val function = instance::class.memberFunctions.first { it.name == functionName }
    function.call(instance)
}

fun main() {
    callFunction(TestClass(), "sayHello")
}