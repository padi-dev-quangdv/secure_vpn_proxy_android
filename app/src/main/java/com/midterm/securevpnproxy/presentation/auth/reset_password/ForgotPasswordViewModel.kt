package com.midterm.securevpnproxy.presentation.auth.reset_password

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.authentication.domain.usecase.reset_password.ResetPasswordParam
import com.tanify.library.authentication.domain.usecase.reset_password.ResetPasswordUseCase
import com.tanify.library.libcore.usecase.ResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val resetPasswordUseCase: ResetPasswordUseCase
    ) :
    BaseViewModel<ForgotPasswordViewModel.ViewState, ForgotPasswordViewModel.ViewEvent, ForgotPasswordViewModel.ViewEffect>(
        ViewState()
    ) {

    private var resetJob: Job? = null

    private fun resetPassword() {
        val email = currentState.email
        val validateEmail = validateEmail(email)
        if (!validateEmail) return
        resetJob?.cancel()
        resetJob = resetPasswordUseCase.execute(ResetPasswordParam(email))
            .onEach {
                when(it) {
                    is ResultModel.Success -> {
                        setEffect(ViewEffect.SendSuccess)
                    }
                    is ResultModel.Error -> {
                        setEffect(ViewEffect.Error(
                            message = it.t.localizedMessage ?: "Unknown Error"
                        ))
                    }
                }
            }.launchIn(coroutineScope)
    }


    private fun validateEmail(email: String): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            setState(
                currentState.copy(
                    emailError = "Invalid email"
                )
            )
            return false
        }
        setState(currentState.copy(emailError = null))
        return true
    }

    private fun updateEmail(newValue: String) {
        setState(currentState.copy(email = newValue))
    }

    data class ViewState(
        val email: String = "",
        val emailError: String? = null,
        val emailPlaceHolder: String = "email@example.com"
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        object ResetPasswordEvent : ViewEvent
        data class UpdateEmail(val email: String): ViewEvent
    }

    override fun onEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.ResetPasswordEvent -> resetPassword()
            is ViewEvent.UpdateEmail -> updateEmail(event.email)
        }
    }

    interface ViewEffect : BaseViewEffect {
        data class Error(val message: String): ViewEffect
        object SendSuccess: ViewEffect
    }

}