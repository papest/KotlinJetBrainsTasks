package repeat

import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun decryptAndroids(androids: String, secret: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val key = SecretKeySpec(secret.toByteArray(), "AES")
    cipher.init(Cipher.DECRYPT_MODE, key)
    val encryptedBytes = Base64.getDecoder().decode(androids)
    val decryptedBytes = cipher.doFinal(encryptedBytes)
    return String(decryptedBytes)
}
