open class Character(val name: String)

class Hero(name: String) : Character(name) {
    fun attack() {
        println("Hero is attacking")
    }
}

class Villain(name: String) : Character(name) {
    fun defend() {
        println("Villain is defending")
    }
}

class Adventure<in I, out O>(private var inputCharacter: I, private val outputCharacter: O)
        where I : Character, O : Character {
    fun setInputCharacter(character: I) {
        this.inputCharacter = character
    }

    fun getOutputCharacter(): O {
        return outputCharacter
    }
}

fun main() {
    val link = Hero("Link")
    val ganon = Villain("Ganon")

    val adventure: Adventure<Character, Character> = Adventure(link, ganon)

    adventure.setInputCharacter(ganon)
    val outputCharacter = adventure.getOutputCharacter()

    if (outputCharacter is Villain) {
        outputCharacter.defend()
    } else {
        println("This character cannot defend!")
    }
}