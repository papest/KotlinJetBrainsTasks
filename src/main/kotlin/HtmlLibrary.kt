import kotlinx.html.*
import kotlinx.html.dom.*

fun main() {
    val document = document { }
    document.append {
        h1 {
            +"Hello, Mike!"
        }
    }
    println(document.serialize())

    val myDocument = document { }
    myDocument.append {
        html {
            body {
                for (i in 1..10) {
                    div {
                        +i.toString()
                    }
                }
            }
        }
    }
    println(myDocument.serialize())
}