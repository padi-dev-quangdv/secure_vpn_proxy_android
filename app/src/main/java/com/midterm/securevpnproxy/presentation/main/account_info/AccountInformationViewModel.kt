package com.midterm.securevpnproxy.presentation.main.account_info

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.midterm.securevpnproxy.presentation.main.account_info.AccountInformationViewModel.ViewEffect
import com.midterm.securevpnproxy.presentation.main.account_info.AccountInformationViewModel.ViewEvent
import com.midterm.securevpnproxy.presentation.main.account_info.AccountInformationViewModel.ViewState
import com.tanify.library.authentication.domain.usecase.logout.LogoutUseCase
import com.tanify.library.libcore.usecase.ResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AccountInformationViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
) : BaseViewModel<ViewState, ViewEvent, ViewEffect>(ViewState()) {

    private var signOutJob: Job? = null

    private fun signOut() {
        signOutJob?.cancel()
        signOutJob = logoutUseCase.execute(Any()).onEach {
            onLoading(false)
            when (it) {
                is ResultModel.Success -> {
                    setEffect(ViewEffect.SignOutSuccess)
                }

                is ResultModel.Error -> {
                    setEffect(
                        ViewEffect.Error(
                            message = it.t.localizedMessage ?: "Unknown error"
                        )
                    )
                }
            }
        }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.SignOut -> signOut()
        }
    }

    class ViewState : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        object SignOut : ViewEvent
    }

    sealed interface ViewEffect : BaseViewEffect {
        object SignOutSuccess : ViewEffect
        data class Error(val message: String) : ViewEffect
    }

}