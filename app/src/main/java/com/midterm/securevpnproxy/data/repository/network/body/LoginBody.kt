package com.midterm.securevpnproxy.data.repository.network.body

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginBody(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
)
