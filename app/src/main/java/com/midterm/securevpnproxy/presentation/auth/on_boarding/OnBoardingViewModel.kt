package com.midterm.securevpnproxy.presentation.auth.on_boarding


import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.localdb.tanify.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userDataStore: UserDataStore,
): BaseViewModel<OnBoardingViewModel.ViewState, OnBoardingViewModel.ViewEvent, OnBoardingViewModel.ViewEffect>(
    ViewState()
) {

    private var checkFirstTimeOpenAppJob: Job? = null

    init {
        isFirstTimeOpenApp()
    }

    private fun setFirstTimeOpenApp() {
        coroutineScope.launch {
            userDataStore.setFirstTimeOpenApp(false)
        }
    }

    private fun isFirstTimeOpenApp() {
        checkFirstTimeOpenAppJob?.cancel()
        checkFirstTimeOpenAppJob = userDataStore.isFirstTimeOpenApp().onEach {
            setState(currentState.copy(isFirstTimeOpenApp = it))
        }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.MoveToFirstPage -> moveToFirstPage()
            is ViewEvent.MoveToSecondPage -> moveToSecondPage()
            is ViewEvent.MoveToThirdPage -> moveToThirdPage()
            is ViewEvent.ClickButtonStarted -> setFirstTimeOpenApp()
        }
    }

    private fun moveToFirstPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_product_launch,
            titleRes = R.string.title_on_boarding_1,
            descRes = R.string.description_on_boarding_1,
            buttonText = R.string.btn_continue_text
        ))
    }

    private fun moveToSecondPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_coding,
            titleRes = R.string.title_on_boarding_2,
            descRes = R.string.description_on_boarding_2,
            buttonText = R.string.btn_continue_text
        ))
    }

    private fun moveToThirdPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_location,
            titleRes = R.string.title_on_boarding_3,
            descRes = R.string.description_on_boarding_3,
            buttonText = R.string.btn_get_started_text
        ))
    }

    data class ViewState(
        val imageRes: Int = R.drawable.ic_product_launch,
        val titleRes: Int = R.string.title_on_boarding_1,
        val descRes: Int = R.string.description_on_boarding_1,
        val buttonText: Int = R.string.btn_continue_text,
        val isFirstTimeOpenApp: Boolean = true,
    ): BaseViewState

    sealed interface ViewEvent: BaseViewEvent {
        object MoveToFirstPage: ViewEvent
        object MoveToSecondPage: ViewEvent
        object MoveToThirdPage: ViewEvent
        object ClickButtonStarted: ViewEvent
    }

    sealed interface ViewEffect: BaseViewEffect


}