package repeat

open class Plant(val name: String)

open class Flower(name: String, val color: String) : Plant(name)

class Flowerbed(color: String, name: String) : Flower(name, color) {
    fun print() {
        println("This flowerbed has many $color ${name}s")
    }
}

fun main() {
    Flowerbed("red", "rose").print()
}