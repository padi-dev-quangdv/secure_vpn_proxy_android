package com.midterm.securevpnproxy.presentation.auth.on_boarding

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.localdb.tanify.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userDataStore: UserDataStore,
): BaseViewModel<OnBoardingViewModel.ViewState, OnBoardingViewModel.ViewEvent, OnBoardingViewModel.ViewEffect>(
    ViewState()
) {

    init {
        isFirstTimeOpenApp()
    }

    private fun setFirstTimeOpenApp() {
        coroutineScope.launch {
            userDataStore.setFirstTimeOpenApp(false)
        }
    }

    private fun isFirstTimeOpenApp() {
        coroutineScope.launch {
            userDataStore.isFirstTimeOpenApp().collectLatest {
                setState(currentState.copy(isFirstTimeOpenApp = it))
            }
        }
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
            currentPage = OnBoardingPages.PageOne
        ))
    }

    private fun moveToSecondPage() {
        setState(currentState.copy(
            currentPage = OnBoardingPages.PageTwo
        ))
    }

    private fun moveToThirdPage() {
        setState(currentState.copy(
           currentPage = OnBoardingPages.PageThree
        ))
    }

    data class ViewState(
        val currentPage: OnBoardingPages = OnBoardingPages.PageOne,
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