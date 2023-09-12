package com.tanify.library.localdb.domain.usecase.get_app_device

import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import com.tanify.library.localdb.domain.model.WhiteListAppModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetInstallAppPackageUseCaseImpl @Inject constructor(
    private val localDbDataSource: LocalDbDataSource
) : GetInstallAppPackageUseCase {
    override fun execute(param: Any): Flow<ResultModel<List<WhiteListAppModel>>> {
        return localDbDataSource.getAllAppDevice().map {
            ResultModel.Success(it)
        }
    }

}