package com.tanify.library.localdb.domain.datasource

import com.tanify.library.localdb.domain.model.WhiteListAppModel
import kotlinx.coroutines.flow.Flow

interface LocalDbDataSource {
    fun getAllAppDevice(): Flow<List<WhiteListAppModel>>
}