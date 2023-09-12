package com.tanify.library.localdb.domain.model

import android.graphics.drawable.Drawable
import com.tanify.library.localdb.data.entity.WhiteListAppDbModel

data class WhiteListAppModel(
    val packageName: String,
    val appName : String,
    val appIcon: Drawable?,
) {

    fun toWhiteListAppDbModel(): WhiteListAppDbModel {
        return WhiteListAppDbModel(
            packageName = packageName,
            appName = appName,
        )
    }
}
