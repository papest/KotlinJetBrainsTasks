import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class LoadingViewModel {
    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState

    //Function to simulate loading data
    fun loadData() {
        GlobalScope.launch {
            _loadingState.value = true
            delay(2000)
            _loadingState.value = false
        }
    }
}

@ExperimentalCoroutinesApi
fun main() = runBlocking {

    val viewModel = LoadingViewModel()
    viewModel.loadData()
    val job = launch {
        viewModel.loadingState.collect { isLoading ->
            println(isLoading)
        }
    }
    delay(3000)
    job.cancel()

}



