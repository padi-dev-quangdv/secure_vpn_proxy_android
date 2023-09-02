package com.tanify.library.localdb.domain.usecase

import com.tanify.library.libcore.usecase.FlowResultUseCase
import com.tanify.library.localdb.domain.model.WhiteListAppModel

interface GetInstallAppPackageUseCase : FlowResultUseCase<Any,List<WhiteListAppModel>>