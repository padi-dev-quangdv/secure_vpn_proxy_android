package com.midterm.securevpnproxy.presentation.main.home.home_select_mode

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.midterm.securevpnproxy.presentation.main.home.home_select_mode.HomeSelectModeViewModel.*
import com.tanify.library.dns.domain.model.server_list.ServerGroupType
import com.tanify.library.localdb.tanify.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeSelectModeViewModel @Inject constructor(
    private val userDataStore: UserDataStore,
) : BaseViewModel<ViewState, ViewEvent, ViewEffect>(
    ViewState()
) {

    private var userServerGroupTypeJob: Job? = null

    init {
        subscribeServerGroupType()
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

    data class ViewState(
        val currentGroupType: ServerGroupType? = null
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        data class SwitchServerGroupType(val idServerGroupType: String): ViewEvent
    }

    sealed interface ViewEffect : BaseViewEffect
}
