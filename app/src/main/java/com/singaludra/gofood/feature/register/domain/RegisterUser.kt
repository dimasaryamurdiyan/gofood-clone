package com.singaludra.gofood.feature.register.domain

import com.singaludra.gofood.feature.register.domain.request.UserData
import com.singaludra.gofood.shared.domain.UserRoot
import kotlinx.coroutines.flow.Flow

sealed class RegisterUserResult {
    data class Success(val user: UserRoot) : RegisterUserResult()
    data class Failure(val throwable: Throwable) : RegisterUserResult()
}
interface RegisterUser {
    fun register(user: UserData): Flow<RegisterUserResult>
}