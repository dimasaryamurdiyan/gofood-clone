package com.singaludra.gofood.feature.login.http.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDataRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)
