package com.tanify.library.localdb.domain.usecase.crud_db.insert

import com.tanify.library.libcore.usecase.FlowResultUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.WhiteListAppParam

interface InsertAppToDbUseCase : FlowResultUseCase<WhiteListAppParam, Unit>