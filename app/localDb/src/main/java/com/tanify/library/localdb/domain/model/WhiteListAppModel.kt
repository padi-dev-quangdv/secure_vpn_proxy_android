package com.tanify.library.localdb.domain.model

import android.graphics.drawable.Drawable

data class WhiteListAppModel(
    val packageName: String,
    val appName : String,
    val appIcon: Drawable?,
)
