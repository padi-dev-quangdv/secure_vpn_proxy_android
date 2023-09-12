package com.tanify.library.localdb.domain.payload

data class WhiteListAppPayload(
    val packageName: String,
    val appName: String,
)
