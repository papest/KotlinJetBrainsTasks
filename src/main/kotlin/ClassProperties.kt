import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

data class User(val name: String, val age: Int, private val password: String)

fun getProperties(kClass: KClass<*>): Collection<String> {
    return kClass.memberProperties.map { it.name }
}

fun main() {
    println(getProperties(User::class))
}