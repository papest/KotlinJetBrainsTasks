import kotlin.properties.Delegates

class StudentNotNullId {
    var id: Int by Delegates.notNull()
}

fun main() {
    val student = StudentNotNullId()
    val id = readln().toInt()
    try {
        println(student.id)
    } catch (e: Exception) {
        println(e.message)
    }
    student.id = id
    println(student.id)
}