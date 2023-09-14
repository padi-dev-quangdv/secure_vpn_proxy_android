package com.midterm.securevpnproxy.presentation.main.premium

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PremiumViewModel @Inject constructor(

) :
    BaseViewModel<PremiumViewModel.ViewState, PremiumViewModel.ViewEvent, PremiumViewModel.ViewEffect>(ViewState()) {


    private fun switchSubscription(value: Boolean) {
        setState(currentState.copy(isAnnuallySubscription = value))
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.SwitchSub -> switchSubscription(event.value)
        }
    }

    data class ViewState(
        val isAnnuallySubscription: Boolean = false
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        data class SwitchSub(val value: Boolean): ViewEvent
    }

    interface ViewEffect : BaseViewEffect
}