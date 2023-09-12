package com.tanify.library.localdb.domain.usecase.crud_db.get_all

import com.tanify.library.libcore.usecase.FlowResultUseCase
import com.tanify.library.localdb.data.entity.WhiteListAppDbModel

interface GetAppsFromDbUseCase: FlowResultUseCase<Any,List<WhiteListAppDbModel>>