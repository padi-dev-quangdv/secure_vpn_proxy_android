package com.tanify.library.localdb.domain.usecase.crud_db.get_all

import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import com.tanify.library.localdb.data.entity.WhiteListAppDbModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAppsFromDbUseCaseImpl(
    private val localDbDataSource: LocalDbDataSource,
) : GetAppsFromDbUseCase {
    override fun execute(param: Any): Flow<ResultModel<List<WhiteListAppDbModel>>> {
        return localDbDataSource.getAppsFromDb().map {
            ResultModel.Success(it)
        }
    }

}