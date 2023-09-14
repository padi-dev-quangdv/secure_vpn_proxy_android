package com.midterm.securevpnproxy.presentation.main.about

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor() :
    BaseViewModel<AboutViewModel.ViewState, AboutViewModel.ViewEvent, AboutViewModel.ViewEffect>(ViewState()) {

    override fun onEvent(event: ViewEvent) {
    }

    class ViewState : BaseViewState

    interface ViewEvent : BaseViewEvent

    interface ViewEffect : BaseViewEffect

}