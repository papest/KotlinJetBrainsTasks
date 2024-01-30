fun main() {
    stringProcessor("greet: ")("Hello")(", WELCOME aboard!")
        .also { println(it) }
    multiply(2)(3).also { println(it) }

}

fun stringProcessor(s: String): (String) -> ((String) -> (String)) {

    return { s1 ->
        { s2 ->
            StringBuilder()
                .apply {
                    append(s.uppercase())
                    append(s1)
                    append(s2.lowercase())
                }
                .toString()
        }
    }
}

fun multiply(a: Int): (Int) -> (Int) = { b -> a * b }