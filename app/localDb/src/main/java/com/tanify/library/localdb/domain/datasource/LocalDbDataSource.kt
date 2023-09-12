package com.tanify.library.localdb.domain.datasource

import com.tanify.library.localdb.data.entity.WhiteListAppDbModel
import com.tanify.library.localdb.domain.model.WhiteListAppModel
import com.tanify.library.localdb.domain.payload.WhiteListAppPayload
import kotlinx.coroutines.flow.Flow

interface LocalDbDataSource {
    fun getAllAppDevice(): Flow<List<WhiteListAppModel>>

    fun getAppsFromDb(): Flow<List<WhiteListAppDbModel>>

    suspend fun insertAppToDb(whiteListAppPayload: WhiteListAppPayload)

    suspend fun deleteAppFromDb(whiteListAppPayload: WhiteListAppPayload)
}