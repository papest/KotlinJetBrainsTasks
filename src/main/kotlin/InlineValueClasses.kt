@JvmInline
value class Email(val email: String)

fun Email.valid() = email.matches(".{1,64}@.{1,250}\\..{1,3}".toRegex())

@JvmInline
value class Age(val age: Int)

const val ADULT_AGE = 18
fun isAdult(value: Age) = value.age >= ADULT_AGE

@JvmInline
value class Temperature(val celsius: Double)

fun getConvertedTemperature(temp: Temperature) = "${temp.celsius}°C is ${temp.celsius * 9 / 5 + 32}°F"

fun main() {
    println(Email("hhhh@jk.ru").valid())
    println(isAdult(Age(19)))
    println(getConvertedTemperature(Temperature(10.0)))
}