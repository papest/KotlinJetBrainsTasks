package repetition

class Guitar(name: String) : Instrument(name), Portable {

    override fun play() {
        println("Playing the $name")
    }

    override fun carry() {
        println("Carrying the $name")
    }
}

abstract class Instrument(val name: String) {
    abstract fun play()
}

interface Portable {
    fun carry()
}

fun main() {
    val name = readln()
    val guitar = Guitar(name)
    guitar.play()
    guitar.carry()
}