class EmployeeMap(map: MutableMap<String, Any>) {
    val name: String by map
    val age: Int by map
    val salary: Double by map
}

fun main() {
    val (n, a, s) = readln().split("-")
    val employee = EmployeeMap(
        mutableMapOf(
            "name" to n,
            "age" to a.toInt(),
            "salary" to s.toDouble()
        )
    )

    println("Name: ${employee.name}")
    println("Age: ${employee.age}")
    println("Salary: ${employee.salary}")
}