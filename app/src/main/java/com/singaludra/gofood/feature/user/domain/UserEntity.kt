package com.singaludra.gofood.feature.user.domain

import com.singaludra.shared.domain.UserRoot

data class UserEntity(
    val accesToken: String,
    val tokenType: String,
    val user: UserEntityItem
) {
    companion object {
        fun mapFromDomain(userRoot: com.singaludra.shared.domain.UserRoot): UserEntity =
            UserEntity(
                accesToken = userRoot.accesToken,
                tokenType = userRoot.tokenType,
                user = UserEntityItem(
                    id = userRoot.user.id,
                    name = userRoot.user.name,
                    email = userRoot.user.email,
                    address = userRoot.user.address,
                    houseNumber = userRoot.user.houseNumber,
                    phoneNumber = userRoot.user.phoneNumber,
                    city = userRoot.user.city,
                    profile_photo_url = userRoot.user.profile_photo_url,
                )
            )
    }
}

data class UserEntityItem(
    val id: Int = 1,
    val name: String,
    val email: String,
    val address: String,
    val houseNumber: String,
    val phoneNumber: String,
    val city: String,
    val profile_photo_url: String?
)
