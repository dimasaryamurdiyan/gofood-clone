package com.singaludra.gofood.feature.register.http.request

data class RegistrationData(
    val name: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
    val address: String,
    val city: String,
    val houseNumber: String,
    val phoneNumber: String
)
