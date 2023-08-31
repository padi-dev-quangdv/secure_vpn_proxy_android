package com.midterm.securevpnproxy.presentation.main.white_list

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WhiteListViewModel @Inject constructor() : BaseViewModel<WhiteListViewModel.ViewState, WhiteListViewModel.ViewEvent, WhiteListViewModel.ViewEffect>
    (ViewState()) {

    class ViewState : BaseViewState {

    }

    interface ViewEvent : BaseViewEvent {

    }

    interface ViewEffect : BaseViewEffect {

    }

    override fun onEvent(event: ViewEvent) {

    }

}