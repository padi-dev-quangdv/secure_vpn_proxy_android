package com.midterm.securevpnproxy.presentation.main.white_list

import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.model.WhiteListAppModel
import com.tanify.library.localdb.domain.usecase.crud_db.WhiteListAppParam
import com.tanify.library.localdb.domain.usecase.crud_db.delete.DeleteAppFromDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.get_all.GetAppsFromDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.insert.InsertAppToDbUseCase
import com.tanify.library.localdb.domain.usecase.get_app_device.GetInstallAppPackageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WhiteListViewModel @Inject constructor(
    private val getInstallAppPackageUseCase: GetInstallAppPackageUseCase,
    private val insertAppToDbUseCase: InsertAppToDbUseCase,
    private val deleteAppFromUseCase: DeleteAppFromDbUseCase,
    private val getAllEnabledApps: GetAppsFromDbUseCase,
) : BaseViewModel<WhiteListViewModel.ViewState, WhiteListViewModel.ViewEvent, WhiteListViewModel.ViewEffect>
    (ViewState()) {

    private var getAllPackageNamesJob: Job? = null
    private var insertAppToDbUseCaseJob: Job? = null
    private var deleteAppFromDbUseCaseJob: Job? = null
    private var getAllEnabledAppsJob: Job? = null

    init {
        getAllPackageNames()
        getAllEnabledApps()
    }

    private fun getAllPackageNames() {
        getAllPackageNamesJob?.cancel()
        onLoading(true)
        getAllPackageNamesJob = getInstallAppPackageUseCase.execute(Any())
            .onEach {
                onLoading(false)
                if (it is ResultModel.Success) {
                    setState(
                        currentState.copy(
                            currentAppPackageNames = it.result.sortedBy { model ->
                                model.appName
                            }
                        )
                    )
                }
            }.launchIn(coroutineScope)
    }

    private fun addAppToLocalDb(appPackage: String, appName: String) {
        insertAppToDbUseCaseJob?.cancel()
        insertAppToDbUseCaseJob =
            insertAppToDbUseCase.execute(WhiteListAppParam(appPackage, appName))
                .onEach {
                    if (it is ResultModel.Error) {
                        setState(currentState.copy(insertError = it.t.toString()))
                    }
                }.launchIn(coroutineScope)
    }

    private fun deleteAppToLocalDb(appPackage: String, appName: String) {
        deleteAppFromDbUseCaseJob?.cancel()
        deleteAppFromDbUseCaseJob =
            deleteAppFromUseCase.execute(WhiteListAppParam(appPackage, appName))
                .onEach {
                    if (it is ResultModel.Error) {
                        setState(currentState.copy(deleteError = it.t.toString()))
                    }
                }.launchIn(coroutineScope)
    }

    private fun getAllEnabledApps() {
        getAllEnabledAppsJob?.cancel()
        getAllEnabledAppsJob = getAllEnabledApps.execute(Any())
            .onEach {
                if(it is ResultModel.Success) {
                    setState(currentState.copy(enabledApps = it.result.map { dbModel ->
                        WhiteListAppModel(dbModel.packageName ,dbModel.appName, null)
                    }))
                }
            }.launchIn(coroutineScope)
    }

    override fun onCleared() {
        super.onCleared()
        getAllPackageNamesJob?.cancel()
    }

    override fun onEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.AddAppToDb -> addAppToLocalDb(event.packageName, event.appName)
            is ViewEvent.DeleteAppFromDb -> deleteAppToLocalDb(event.deletePackageName, event.deleteAppName)
            is ViewEvent.GetAllEnabledApps -> getAllEnabledApps()
        }
    }

    data class ViewState(
        val currentAppPackageNames: List<WhiteListAppModel> = mutableListOf(),
        val enabledApps: List<WhiteListAppModel> = mutableListOf(),
        val insertError: String? = null,
        val deleteError: String? = null,
    ) : BaseViewState

    sealed interface ViewEvent : BaseViewEvent {
        data class AddAppToDb(val packageName: String, val appName: String) : ViewEvent
        data class DeleteAppFromDb(val deletePackageName: String, val deleteAppName: String) :
            ViewEvent

        object GetAllEnabledApps : ViewEvent
    }

    interface ViewEffect : BaseViewEffect {

    }

}