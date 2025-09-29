class Server(val configuration: ServerConfiguration) {
    override fun toString(): String = with(configuration) {
        (if (useSSL) "https://" else "http://") + "$domain:$port/"
    }
}

class ServerConfiguration {
    var domain: String = ""
    var port: Int = 0
    var useSSL: Boolean = false
}
@Suppress("Call can be replaced")
fun server(configuration: ServerConfiguration.() -> Unit): Server =
    Server(ServerConfiguration().also { it.configuration() })

fun main() {
    println(server {
        domain = "google.com"
        port = 8080
        useSSL = true
    })

}