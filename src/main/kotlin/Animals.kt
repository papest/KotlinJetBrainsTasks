open class Animal {
    open val sound = "unknown"
}

class Dog : Animal() {
    override val sound = "woof"
}