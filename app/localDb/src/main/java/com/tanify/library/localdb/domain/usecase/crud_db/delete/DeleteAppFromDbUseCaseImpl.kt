package com.tanify.library.localdb.domain.usecase.crud_db.delete

import com.tanify.library.libcore.usecase.ResultModel
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import com.tanify.library.localdb.domain.payload.WhiteListAppPayload
import com.tanify.library.localdb.domain.usecase.crud_db.WhiteListAppParam
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DeleteAppFromDbUseCaseImpl @Inject constructor(
    private val localDbDataSource: LocalDbDataSource
): DeleteAppFromDbUseCase{
    override fun execute(param: WhiteListAppParam): Flow<ResultModel<Unit>> {
        val payload = WhiteListAppPayload(param.packageName, param.appName)
        return flow {
            try {
                emit(ResultModel.Success(localDbDataSource.deleteAppFromDb(payload)))
            }catch (e: IOException) {
                emit(ResultModel.Error(e))
            } catch (e: Exception) {
                emit(ResultModel.Error(e))
            }
        }
    }
}