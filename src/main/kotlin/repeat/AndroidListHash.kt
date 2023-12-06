package repeat

import java.security.MessageDigest
import java.util.stream.Collectors

data class Android(val name: String, val energy: Int)

fun calculateAndroidsHash(androids: List<Android>): String {
    // write your code here
    // First create one string to contain all the android strings value in one
    // the return the SHA-512 hash
    val instance = MessageDigest.getInstance("SHA-512")
    val ands = androids.stream().map { "${it.name}${it.energy}" }.collect(Collectors.joining())
    val byteArrayDigest = instance.digest(ands.toByteArray())
    val hashString = StringBuilder()
    for (b in byteArrayDigest) {
        val i = String.format("%02x", b)
        hashString.append(i)
    }

    return hashString.toString()
}

fun main() {
    println(calculateAndroidsHash(listOf(Android("R2D2",100),Android("C3PO",200))))
}
