open class Droid(val name: String)

class AstromechDroid(name: String) : Droid(name) {
    fun repair() {
        println("Repairing a starship")
    }
}

class ProtocolDroid(name: String) : Droid(name) {
    fun translate() {
        println("Translating languages")
    }
}

class Republic<out T>(private val androids: List<T>)
{
    fun getDroids(): List<T> {
        return androids
    }
}

fun main() {
    val astromechDroids = listOf(AstromechDroid("R2-D2"), AstromechDroid("BB-8"))
    val protocolDroids = listOf(ProtocolDroid("C-3PO"), ProtocolDroid("D-O"))

    val republicAstromechs: Republic<AstromechDroid> = Republic(astromechDroids)
    val republicProtocols: Republic<ProtocolDroid> = Republic(protocolDroids)

    val astromechList: List<AstromechDroid> = republicAstromechs.getDroids()
    val protocolList: List<ProtocolDroid> = republicProtocols.getDroids()

    for (astromech in astromechList) {
        println("Astromech Droid name: ${astromech.name}")
        astromech.repair()
    }

    for (protocol in protocolList) {
        println("Protocol Droid name: ${protocol.name}")
        protocol.translate()
    }
}