interface Auth {
    fun login()
    fun logout()
}

class AdminAuth : Auth {
    override fun login() {
        println("Admin logged in.")
    }

    override fun logout() {
        println("Admin logged out.")
    }
}

class UserAuth : Auth {
    override fun login() {
        println("User logged in.")
    }

    override fun logout() {
        println("User logged out.")
    }
}

val user = UserAuth()
val admin = AdminAuth()

class SystemUser(val userName: String, private val isAdmin: Boolean) : Auth by if (isAdmin) admin else user

fun main() {
    val vasil = SystemUser("Vasyl", true)
    val mary = SystemUser("Mary", false)
    vasil.login()
    mary.login()
    vasil.logout()
    mary.logout()
}