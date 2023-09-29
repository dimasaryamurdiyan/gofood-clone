package com.singaludra.gofood.feature.register.domain.request

data class UserData(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
    val address: String,
    val city: String,
    val houseNumber: String,
    val phoneNumber: String
)
