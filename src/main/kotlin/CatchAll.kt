open class BaseException : Exception()
open class MidException : BaseException()
class DerivedException : MidException()

fun main() {
    val exceptionList = listOf(DerivedException(), MidException(), BaseException())
    for (ex in exceptionList) {
        try {
            throw ex
        } catch (ex: Exception) {
            println("Caught a ${ex.javaClass.canonicalName}!")
        }
    }
}