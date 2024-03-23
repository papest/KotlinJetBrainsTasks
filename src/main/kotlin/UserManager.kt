val users: MutableMap<Int, String> = mutableMapOf()
fun main() {
    while (true) {
        val input = readln()
        if (input.equals("end", ignoreCase = true)) break
        operate(input)
    }
    users.forEach { println("${it.key} ${it.value}") }
}

val reg: Regex = "(add|remove) (\\d+)( [A-Za-z]+)?".toRegex()
fun add(id: Int, name: String) = if (users.contains(id)) println("ID exists") else users[id] = name
fun remove(id: Int) = users.remove(id)

@Suppress("MagicNumber")
fun operate(input: String) {
    if (input.matches(reg)) {
        val groups = reg.matchEntire(input)?.groups
        val command = groups?.get(1)?.value
        val id = Integer.parseInt(groups?.get(2)?.value)
        if (command?.equals("add", true) == true) {
            val name: String = groups[3]?.value!!.trim()
            add(id, name)
        } else {
            remove(id)
        }
    }
}
