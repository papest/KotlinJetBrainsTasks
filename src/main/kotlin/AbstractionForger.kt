abstract class Employee(private val name: String, private val surname: String) {

    abstract val age: Int
    abstract fun doWork()
    fun fullName() = "$name $surname"
}
@Suppress("MagicNumber")
class Worker(name: String, surname: String) : Employee(name, surname) {
    override val age = 40

    override fun doWork() {
        println("I am working!")
    }
}

fun main() {
    val name = readln()
    val surname = readln()

    val worker = Worker(name, surname)

    println("My name is: ${worker.fullName()}")
    worker.doWork()
}
