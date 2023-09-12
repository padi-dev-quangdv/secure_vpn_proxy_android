package com.tanify.library.localdb.domain.usecase.get_app_device

import com.tanify.library.libcore.usecase.FlowResultUseCase
import com.tanify.library.localdb.domain.model.WhiteListAppModel

interface GetInstallAppPackageUseCase : FlowResultUseCase<Any,List<WhiteListAppModel>>