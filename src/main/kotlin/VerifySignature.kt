import java.security.KeyFactory
import java.security.PublicKey
import java.security.Signature
import java.security.spec.X509EncodedKeySpec
import java.util.*

fun verifySignature(plainText: String, signatureText: String, publicKey: ByteArray): Boolean {
    val signature = Signature.getInstance("SHA256withDSA")
    val kf = KeyFactory.getInstance("DSA")
    val kp: PublicKey = kf.generatePublic(X509EncodedKeySpec(publicKey))
    signature.initVerify(kp)
    signature.update(plainText.toByteArray())
    return signature.verify(Base64.getDecoder().decode(signatureText))
}

