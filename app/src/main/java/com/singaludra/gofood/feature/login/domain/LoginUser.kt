package com.singaludra.gofood.feature.login.domain

import com.singaludra.shared.domain.UserRoot
import kotlinx.coroutines.flow.Flow

sealed class LoginUserResult {
    data class Success(val user: UserRoot) : LoginUserResult()
    data class Failure(val throwable: Throwable) : LoginUserResult()
}
interface LoginUser {
    fun login(email: String, password: String): Flow<LoginUserResult>
}