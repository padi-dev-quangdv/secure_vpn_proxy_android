package com.midterm.securevpnproxy.presentation.main.white_list

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.model.WhiteListAppModel
import com.tanify.library.localdb.domain.usecase.GetInstallAppPackageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WhiteListViewModel @Inject constructor(
    private val getInstallAppPackageUseCase: GetInstallAppPackageUseCase,
) : BaseViewModel<WhiteListViewModel.ViewState, WhiteListViewModel.ViewEvent, WhiteListViewModel.ViewEffect>
    (ViewState()) {

    private var getAllPackageNamesJob: Job? = null

    init {
        getAllPackageNames()
    }

    private fun getAllPackageNames() {
        getAllPackageNamesJob?.cancel()
        getAllPackageNamesJob = getInstallAppPackageUseCase.execute(String())
            .onEach {
                if(it is ResultModel.Success) {
                    setState(
                        currentState.copy(
                            currentAppPackageNames = it.result
                        )
                    )
                }
            }.launchIn(coroutineScope)
    }

    override fun onCleared() {
        super.onCleared()
        getAllPackageNamesJob?.cancel()
    }

    override fun onEvent(event: ViewEvent) {

    }

    data class ViewState(
        val currentAppPackageNames: List<WhiteListAppModel> = mutableListOf(),
    ) : BaseViewState

    interface ViewEvent : BaseViewEvent {

    }

    interface ViewEffect : BaseViewEffect {

    }

}