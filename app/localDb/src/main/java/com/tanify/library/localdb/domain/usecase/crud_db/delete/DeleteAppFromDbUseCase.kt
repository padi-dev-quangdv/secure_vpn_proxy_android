package com.tanify.library.localdb.domain.usecase.crud_db.delete

import com.tanify.library.libcore.usecase.FlowResultUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.WhiteListAppParam

interface DeleteAppFromDbUseCase : FlowResultUseCase<WhiteListAppParam, Unit>