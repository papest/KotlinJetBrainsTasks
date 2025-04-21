fun <T> isSpookyChar(ch: T)  : Boolean {
    val a = ch.toString().first().lowercaseChar()
    return a in listOf('b', 'o') ||  ch.toString() == "👻"

}
fun  main() {
    val ghost  = "👻"
    val boo = "BOO!"
    println("Is '$ghost' spooky? ${isSpookyChar(ghost)}")
    println("Spooky count in '$boo': ${boo.count { isSpookyChar(it) }}")
}







