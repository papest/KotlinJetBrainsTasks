import java.time.LocalTime

fun printGroups(matchResult: MatchResult?) {
    println("Full match: ${matchResult?.value}")
    val notNullMatchResult: MatchResult = matchResult!!
    val (year, month, day) = notNullMatchResult.destructured
    println(
        """Year: $year
Month: $month
Day: $day"""
    )
}

fun printMap(regex: Regex, input: String) =
    println(
        regex.findAll(input)
            .map { with(it) { "${groups["key"]?.value}=${groups["value"]?.value}" } }
            .joinToString(", ", "{", "}")
    )

fun convertToSeconds(durations: List<String>, regex: Regex) = durations.forEach {
    regex.find(it)?.run {
        println(LocalTime.parse(value).toSecondOfDay())
    }
}

fun main() {
    val match = Regex("""(\w+) (\d+)""").find("A 01-B 02")!!
    println(match.value)
    println(match.groups[0]?.value)
    println(match.groupValues[1])
    println(match.groups[1]?.value)
    println(match.groupValues[0])

    var regex = """(\d{4})-(\d{2})-(\d{2})""".toRegex()
    var input = "The event will happen on 2024-04-12."

    val matchResult = regex.find(input)

    printGroups(matchResult)

    regex = """(?<key>\w+): (?<value>[^,]+)""".toRegex()

    input = "username: user123, age: 42, role: admin"

    printMap(regex, input)

    regex = """(\d{2}):(\d{2}):(\d{2})""".toRegex()
    val durations = "05:03:40 01:12:31 03:07:15".split(" ")
    convertToSeconds(durations, regex)
    convertToSeconds("kk 05:03:40".split(" "), regex)

}


