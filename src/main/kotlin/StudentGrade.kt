import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Student {
    var name: String = ""

    var grade: Int by Grade
}

const val MAX_GRADE = 100

object Grade {
    private var value: Int = 0

    operator fun getValue(student: Student, property: KProperty<*>) = this.value

    operator fun setValue(student: Student, property: KProperty<*>, value: Int) {
        this.value = when {
            value < 0 -> 0
            value > MAX_GRADE -> MAX_GRADE
            else -> value
        }
        println("The new grade is ${this.value}")
    }
}

fun main() {
    Student().apply {
        name = "Pavel"
        grade = 110
    }
}
