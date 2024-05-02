package repeat

import java.security.KeyFactory
import java.security.spec.PKCS8EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

fun decryptAndroidsWithRSA(androids: String, privateKey: ByteArray): String {
    val cipher = Cipher.getInstance("RSA")
    val keyFactory = KeyFactory.getInstance("RSA")
    val privateKeySpec = PKCS8EncodedKeySpec(privateKey)
    val privateKeyObj = keyFactory.generatePrivate(privateKeySpec)
    cipher.init(Cipher.DECRYPT_MODE, privateKeyObj)
    val decodedBytes = Base64.getDecoder().decode(androids)
    val decryptedBytes = cipher.doFinal(decodedBytes)
    return String(decryptedBytes)
}
