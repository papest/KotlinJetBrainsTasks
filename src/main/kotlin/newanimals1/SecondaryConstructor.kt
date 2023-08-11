package newanimals1

open class Animal(val name: String, val age: Int)

class Dog(name: String, age: Int) : Animal(name, age) {
    var breed: String = "shepherd"

    constructor(name: String, age: Int, breed: String) : this(name, age) {
        this.breed = breed
    }

    @Override
    override fun toString() = "$name $age $breed"

}

fun main() {

    println(Dog("Bob", 10))
    println(Dog("Cally", 11, "mastiff"))

}
