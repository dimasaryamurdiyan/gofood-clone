package com.singaludra.register.domain

import com.singaludra.register.domain.request.UserData
import com.singaludra.shared.domain.UserRoot
import kotlinx.coroutines.flow.Flow

sealed class RegisterUserResult {
    data class Success(val user: UserRoot) : RegisterUserResult()
    data class Failure(val throwable: Throwable) : RegisterUserResult()
}
interface RegisterUser {
    fun register(user: UserData): Flow<RegisterUserResult>
}