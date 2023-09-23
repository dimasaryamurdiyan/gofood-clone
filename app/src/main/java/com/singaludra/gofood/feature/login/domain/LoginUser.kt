package com.singaludra.gofood.feature.login.domain

import com.singaludra.gofood.feature.register.domain.RegisterUserItem
import kotlinx.coroutines.flow.Flow

sealed class LoginUserResult {
    data class Success(val user: RegisterUserItem) : LoginUserResult()
    data class Failure(val throwable: Throwable) : LoginUserResult()
}
interface LoginUser {
    fun login(user: LoginData): Flow<LoginUserResult>
}