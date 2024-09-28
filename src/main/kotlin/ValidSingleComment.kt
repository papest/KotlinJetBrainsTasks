fun main() =
    readln()
        .startsWith("// ")
        .let {
            println(if (it) "Valid" else "Invalid")
        }


