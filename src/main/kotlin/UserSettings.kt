interface UserSettings {
    var language: String
    var theme: String
}

class UserSettingsImpl : UserSettings {
    override var language: String = "English"
    override var theme: String = "Light"
}

class LoggingUserSettingsDelegate(userSettings: UserSettings) : UserSettings {

    override var language: String = userSettings.language
        set(value) {
            println("Language changed from $field to $value")
            field = value
        }
    override var theme: String = userSettings.theme
        set(value) {
            println("Theme changed from $field to $value")
            field = value
        }
}

class UserSettingsWithLogging(userSettings: UserSettings) : UserSettings by LoggingUserSettingsDelegate(userSettings)

fun main() {
    val impl = UserSettingsImpl()
    val user = UserSettingsWithLogging(impl)
    user.language = "Spanish"
    user.theme = "Dark"
}