package com.singaludra.gofood.feature.register.http.request

import com.singaludra.gofood.feature.register.domain.request.UserData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDataRequest(
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
    @Json(name = "password_confirmation")
    val passwordConfirmation: String,
    @Json(name = "address")
    val address: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "houseNumber")
    val houseNumber: String,
    @Json(name = "phoneNumber")
    val phoneNumber: String
) {
    companion object {
        fun fromDomain(userData: UserData) =
            UserDataRequest (
            password = userData.password,
            passwordConfirmation = userData.password,
            address = userData.address,
            phoneNumber = userData.phoneNumber,
            city = userData.address,
            name = userData.name,
            houseNumber = userData.houseNumber,
            email = userData.email
            )
    }
}

