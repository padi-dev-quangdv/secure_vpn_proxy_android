package com.midterm.securevpnproxy.presentation.main.setting

import androidx.lifecycle.ViewModel
import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.usecase.crud_db.get_all.GetAppsFromDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getAppsFromDbUseCase: GetAppsFromDbUseCase
): BaseViewModel<SettingsViewModel.ViewState, SettingsViewModel.ViewEvent, SettingsViewModel.ViewEffect>(
    ViewState()
) {

    private var getAppsFromDbUseCaseJob: Job? = null

    init {
        getWhiteListAppSize()
    }

    private fun getWhiteListAppSize() {
        getAppsFromDbUseCaseJob?.cancel()
        getAppsFromDbUseCaseJob = getAppsFromDbUseCase.execute(Any())
            .onEach {
                if (it is ResultModel.Success) {
                    setState(currentState.copy(whiteListAppSize = it.result.size))
                }
            }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {

    }

    data class ViewState(
        val whiteListAppSize: Int = 0,
    ): BaseViewState

    sealed interface ViewEvent: BaseViewEvent {

    }

    sealed interface ViewEffect: BaseViewEffect {

    }

    override fun onCleared() {
        super.onCleared()
        getAppsFromDbUseCaseJob?.cancel()
    }
}