import java.security.MessageDigest

fun hashPassword(password: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hashBytes = digest.digest(password.toByteArray())
    val hexString = StringBuilder()

    for (b in hashBytes) {
        val i = String.format("%02x", b)
        hexString.append(i)
    }
    return hexString.toString()
}

fun main() {
    println(hashPassword("Secret"))
}