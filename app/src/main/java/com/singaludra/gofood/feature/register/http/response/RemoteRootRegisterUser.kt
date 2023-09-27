package com.singaludra.gofood.feature.register.http.response

import com.singaludra.gofood.feature.register.domain.RegisterUserItem
import com.singaludra.gofood.feature.register.domain.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteRootRegisterUser(
    @Json(name = "data")
    val data: RemoteRegisterUserItem
)

@JsonClass(generateAdapter = true)
data class RemoteRegisterUserItem(
    @Json(name = "access_token")
    val accesToken: String,
    @Json(name = "token_type")
    val tokenType: String,
    @Json(name = "user")
    val user: RemoteUser
)

@JsonClass(generateAdapter = true)
data class RemoteUser(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "address")
    val address: String,
    @Json(name = "houseNumber")
    val houseNumber: String,
    @Json(name = "phoneNumber")
    val phoneNumber: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "profile_photo_url")
    val profilePhotoUrl: String
)
fun RemoteRegisterUserItem.mapToDomain(): RegisterUserItem{
    return RegisterUserItem(
        accesToken = this.accesToken,
        tokenType = this.tokenType,
        user = User(
            this.user.id, this.user.name, this.user.email, this.user.address, this.user.houseNumber, this.user.phoneNumber, this.user.city, this.user.profilePhotoUrl
        )
    )
}