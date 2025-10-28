import java.io.File
import java.math.BigInteger

fun main() {
    BigInteger(File("src/main/resources/hyperskill-dataset-117441947.txt").readLines()[0])
        .divideAndRemainder(BigInteger("4294967296"))
        .also { print("${it[0]},${it[1].toString(2)}") }
}
