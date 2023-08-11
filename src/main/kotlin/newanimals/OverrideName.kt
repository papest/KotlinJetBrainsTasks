package newanimals

open class Animal(open val name: String, val age: Int)

class Dog(name: String, age: Int) : Animal(name, age) {
    override val name: String
        get() = "Dog: ${super.name}"
}