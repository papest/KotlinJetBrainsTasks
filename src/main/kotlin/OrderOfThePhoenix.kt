open class Wizard(val name: String)

class HogwartsStudent(name: String) : Wizard(name) {
    fun study() {
        println("Studying at Hogwarts")
    }
}

class DarkWizard(name: String) : Wizard(name) {
    fun castSpell() {
        println("Casting a dark spell")
    }
}

class OrderOfThePhoenix<in T>
    (private val members: MutableList<T>) where T:Wizard
{
    fun addMember(member: T)  {
        members.add(member)
    }
}

fun main() {
    val hogwartsStudents = mutableListOf<HogwartsStudent>()
    val darkWizards = mutableListOf<DarkWizard>()

    val orderOfThePhoenixHogwarts: OrderOfThePhoenix<HogwartsStudent> = OrderOfThePhoenix(hogwartsStudents)
    val orderOfThePhoenixDark: OrderOfThePhoenix<DarkWizard> = OrderOfThePhoenix(darkWizards)

    orderOfThePhoenixHogwarts.addMember(HogwartsStudent("Harry Potter"))
    orderOfThePhoenixDark.addMember(DarkWizard("Lord Voldemort"))

    for (member in hogwartsStudents) {
        println("Hogwarts student: ${member.name}")
        member.study()
    }

    for (member in darkWizards) {
        println("Dark wizard: ${member.name}")
        member.castSpell()
    }
}