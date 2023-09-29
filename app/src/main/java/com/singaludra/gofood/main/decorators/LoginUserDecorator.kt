package com.singaludra.gofood.main.decorators

import com.singaludra.gofood.feature.login.domain.LoginUser
import com.singaludra.gofood.feature.login.domain.LoginUserResult
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUserDecorator constructor(
    private val loginUser: LoginUser,
    private val saveUserInfo: SaveUserInfo
) : LoginUser {
    override fun login(email: String, password: String): Flow<LoginUserResult> {
        return flow {
            loginUser.login(email, password).collect{ result ->
                if(result is LoginUserResult.Success) {
                    saveUserInfo.save(result.user)
                }
                emit(result)
            }
        }
    }
}