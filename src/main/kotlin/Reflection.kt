fun main() {
    val secret = Secret()
    secret.javaClass.declaredMethods.forEach {
        it.isAccessible = true
        println(it.invoke(secret))
    }
    printCatFields()
}

fun printCatFields() {
    val cat = Cat()
    cat.javaClass.declaredFields.forEach {
        it.isAccessible = true
        println(it.get(cat))
    }
}

class Secret {

    private fun method1(): String {
        return "method1"
    }

    fun method2(): String = "method2"
    fun method3(): Int = 3
}

class Cat {
    private val name = "Cat"
    private val age = 15
}
