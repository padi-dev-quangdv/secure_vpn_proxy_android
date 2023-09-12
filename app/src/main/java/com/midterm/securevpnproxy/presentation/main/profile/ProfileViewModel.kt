package com.midterm.securevpnproxy.presentation.main.profile

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.midterm.securevpnproxy.presentation.ui_model.UiUserDataModel
import com.tanify.library.authentication.domain.datasource.AuthManager
import com.tanify.library.authentication.domain.usecase.get_user_info.GetUserInfoUseCase
import com.tanify.library.authentication.domain.usecase.logout.LogoutUseCase
import com.tanify.library.libcore.usecase.ResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userInfoUseCase: GetUserInfoUseCase,
    private val logoutUseCase: LogoutUseCase,
) : BaseViewModel<ProfileViewModel.ViewState, ProfileViewModel.ViewEvent, ProfileViewModel.ViewEffect>(
    ViewState()
) {

    private var userInfoJob: Job? = null
    private var logoutJob: Job? = null

    init {
        listenUserInfo()
    }

    private fun listenUserInfo() {
        userInfoJob?.cancel()
        userInfoJob = userInfoUseCase.execute(Any()).onEach {
            Timber.d("==> $it")
            when (it) {
                is ResultModel.Success -> {
                    setState(currentState.copy(userModel = UiUserDataModel.fromDomainModel(it.result)))
                }
            }
        }.launchIn(coroutineScope)
    }

    override fun onCleared() {
        super.onCleared()
        userInfoJob?.cancel()
        logoutJob?.cancel()
    }

    private fun signOut() {
        logoutJob?.cancel()
        onLoading(true)
        logoutJob = logoutUseCase.execute(Any()).onEach {
            onLoading(false)
            when(it) {
                is ResultModel.Success -> {
                    setEffect(ViewEffect.SignOutSuccess)
                }
                is ResultModel.Error -> {
                    setEffect(ViewEffect.Error(message = it.t.localizedMessage ?: "Unknown error"))
                }
            }
        }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.SignOut -> signOut()
        }
    }

    data class ViewState(
        val userModel: UiUserDataModel? = null
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        object SignOut: ViewEvent
    }

    sealed interface ViewEffect : BaseViewEffect {
        object SignOutSuccess: ViewEffect
        data class Error(val message: String): ViewEffect
    }
}
