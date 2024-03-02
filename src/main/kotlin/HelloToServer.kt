import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

fun sendHelloToServer(host: String, port: Int) {
    val sslSocketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
    val sslSocket = sslSocketFactory.createSocket(host, port) as SSLSocket
    sslSocket.use {
        it.startHandshake()
        val writer = it.outputStream.writer()
        writer.write("Hello, server!\n")
        writer.flush()
        val reader = it.inputStream.reader()
        val response = reader.readText()
        println("Server response: $response")
    }
}

fun main() {
    val host = "example.com"
    val port = 443 // HTTPS port for SSL/TLS
    sendHelloToServer(host, port)
}
