import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserPreferencesRepository {
    @ExperimentalCoroutinesApi
    private val _uiMode = MutableStateFlow(UiMode.LIGHT)
    @ExperimentalCoroutinesApi
    val uiMode: StateFlow<UiMode>
        get() = _uiMode


    @ExperimentalCoroutinesApi
    fun updateUiMode(newMode: UiMode) {
        if (_uiMode.value != newMode) {
            _uiMode.value = newMode
        }
    }
}

enum class UiMode { LIGHT, DARK }

@ExperimentalCoroutinesApi
fun main() {
    val userPreferencesRepository = UserPreferencesRepository()
    userPreferencesRepository.updateUiMode(UiMode.DARK)
    println(userPreferencesRepository.uiMode.value)
}
