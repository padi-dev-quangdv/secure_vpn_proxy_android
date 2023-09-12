package com.tanify.library.authentication.domain.usecase.logout

import com.tanify.library.authentication.domain.datasource.AuthDataSource
import com.tanify.library.libcore.usecase.ResultModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutUseCaseImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : LogoutUseCase{
    override fun execute(param: Any): Flow<ResultModel<Boolean>> {
        return authDataSource.logout()
    }
}