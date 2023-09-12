package com.midterm.securevpnproxy.presentation.auth.reset_password

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckEmailViewModel @Inject constructor():
BaseViewModel<CheckEmailViewModel.ViewState, CheckEmailViewModel.ViewEvent, CheckEmailViewModel.ViewEffect>(ViewState){

    object ViewState: BaseViewState

    sealed interface ViewEvent: BaseViewEvent

    interface ViewEffect: BaseViewEffect

    override fun onEvent(event: ViewEvent) {
    }
}