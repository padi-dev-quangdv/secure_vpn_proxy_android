package com.tanify.library.localdb.data.dto

import android.graphics.drawable.Drawable
import com.tanify.library.localdb.domain.model.WhiteListAppModel

data class WhiteListAppDto (
    val packageName: String = "",
    val appName: String = "",
    val appIcon: Drawable? = null,
)

fun WhiteListAppDto.toModel(): WhiteListAppModel {
    return WhiteListAppModel(
        packageName = packageName,
        appName = appName,
        appIcon = appIcon
    )
}