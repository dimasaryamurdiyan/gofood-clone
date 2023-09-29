package com.singaludra.gofood.shared.domain


data class RegisterUserItem(
    val accesToken: String,
    val tokenType: String,
    val user: User
)

data class User(
    val id: Int = 1,
    val name: String,
    val email: String,
    val address: String,
    val houseNumber: String,
    val phoneNumber: String,
    val city: String,
    val profile_photo_url: String?
)
