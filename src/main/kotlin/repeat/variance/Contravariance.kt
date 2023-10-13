package repeat.variance

open class Person(val name: String)

class Student(name: String, val grade: Int) : Person(name)

class Teacher(name: String, val subject: String) : Person(name)

interface Comparator<in T> {
    fun compare(item1: T, item2: T): Int
}

fun main() {
    val personComparator: Comparator<Person> = object : Comparator<Person> {
        override fun compare(item1: Person, item2: Person): Int {
            return item1.name.compareTo(item2.name)
        }
    }

    val student: Student = Student("Alice", 10)
    val teacher: Teacher = Teacher("Bob", "Math")

    val result: Int = personComparator.compare(student, teacher)
    println(result) // Output: -1
}
