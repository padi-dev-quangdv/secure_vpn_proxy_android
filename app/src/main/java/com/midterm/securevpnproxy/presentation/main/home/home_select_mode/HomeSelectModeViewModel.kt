package com.midterm.securevpnproxy.presentation.main.home.home_select_mode

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.midterm.securevpnproxy.presentation.main.home.home_select_mode.HomeSelectModeViewModel.*
import com.tanify.library.dns.domain.model.server_list.ServerGroupType
import com.tanify.library.dns.domain.model.server_list.ServerModel
import com.tanify.library.dns.domain.usecase.server_list.ServerListParam
import com.tanify.library.dns.domain.usecase.server_list.ServerListUseCase
import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.tanify.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeSelectModeViewModel @Inject constructor(
    private val serverListUseCase: ServerListUseCase,
    private val userDataStore: UserDataStore,
) : BaseViewModel<ViewState, ViewEvent, ViewEffect>(
    ViewState()
) {

    private var getServerListJob: Job? = null
    private var userServerGroupTypeJob: Job? = null

    init {
        initServerList()
        subscribeServerGroupType()
    }

    private fun initServerList() {
        getServerListJob?.cancel()
        getServerListJob = serverListUseCase.execute(ServerListParam())
            .onEach {
                if(it is ResultModel.Success) {
                    handleServerList(it.result)
                }
            }
            .launchIn(coroutineScope)
    }

    private fun handleServerList(result: List<ServerModel>) {
        val data = result.map {
            it.groupType
        }.distinctBy {
            it.id
        }
        setState(currentState.copy(groupTypes = data))
    }

    private fun subscribeServerGroupType() {
        userServerGroupTypeJob?.cancel()
        userServerGroupTypeJob = userDataStore.getSelectedGroupType()
            .onEach { typeId ->
                val type = ServerGroupType.values()
                    .firstOrNull { it.id == typeId } ?: ServerGroupType.Standard
                setState(currentState.copy(currentGroupType = type))
            }
            .launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.SwitchServerGroupType -> setServerGroupType(event.idServerGroupType)
        }

    }

    private fun setServerGroupType(idServerGroupType: String) {
        coroutineScope.launch {
            userDataStore.saveSelectedGroupType(idServerGroupType)
            subscribeServerGroupType()
        }
    }

    override fun onCleared() {
        super.onCleared()
        getServerListJob?.cancel()
        userServerGroupTypeJob?.cancel()
    }

    data class ViewState(
        val currentGroupType: ServerGroupType? = null,
        val groupTypes: List<ServerGroupType> = listOf(),
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        data class SwitchServerGroupType(val idServerGroupType: String): ViewEvent
    }

    sealed interface ViewEffect : BaseViewEffect
}
