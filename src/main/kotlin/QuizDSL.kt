class Quiz {
    val questions = mutableListOf<Question>()

    fun question(text: String, init: Question.() -> Unit) {
        questions.add(Question(text).apply(init))
    }
}

class Question(val text: String) {

    val options = mutableListOf<String>()

    var answer: String? = null

    fun option(optionText: String, isAnswer: Boolean = false) {

        options.add(optionText)

        if (isAnswer) answer = optionText

    }

}

fun quiz(init: Quiz.() -> Unit) = Quiz().apply(init)
fun main() {

    val myQuiz = quiz {

        question("What is the capital of France?") {

            option("Paris", isAnswer = true)

            option("London")

            option("Rome")

        }

        question("Which planet is known as the Red Planet?") {

            option("Earth")

            option("Mars", isAnswer = true)

            option("Jupiter")

        }

    }

    myQuiz.questions.forEach { println(it.answer) }
}

