package repeat

fun changeName(): String {
    return with(Cat()) {
        val field = javaClass.getDeclaredField("catName")
        field.isAccessible = true
        field.set(this, readln())
        field.get(this) as String
    }
}

class Cat {
    private val catName = "name"
}

fun main() {
    println(changeName())
}
