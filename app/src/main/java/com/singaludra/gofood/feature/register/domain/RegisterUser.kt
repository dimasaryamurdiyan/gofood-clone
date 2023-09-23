package com.singaludra.gofood.feature.register.domain

import com.singaludra.gofood.feature.register.http.request.RegistrationData
import kotlinx.coroutines.flow.Flow

sealed class RegisterUserResult {
    data class Success(val user: RegisterUserItem) : RegisterUserResult()
    data class Failure(val throwable: Throwable) : RegisterUserResult()
}
interface RegisterUser {
    fun register(user: RegistrationData): Flow<RegisterUserResult>
}