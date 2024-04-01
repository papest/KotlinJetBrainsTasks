import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

fun encryptPassword(password: String, publicKey: ByteArray): String {
    val cipher = Cipher.getInstance("RSA")
    val keyFactory = KeyFactory.getInstance("RSA")
    val publicKeySpec = X509EncodedKeySpec(publicKey)
    val publicKeyObj = keyFactory.generatePublic(publicKeySpec)
    cipher.init(Cipher.ENCRYPT_MODE, publicKeyObj)
    val encryptedBytes = cipher.doFinal(password.toByteArray())
    val encodedBytes = Base64.getEncoder().encode(encryptedBytes)
    return String(encodedBytes)
}
