package com.singaludra.gofood.main.decorators

import com.singaludra.login.domain.LoginUser
import com.singaludra.login.domain.LoginUserResult
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUserDecorator constructor(
    private val loginUser: com.singaludra.login.domain.LoginUser,
    private val saveUserInfo: SaveUserInfo
) : com.singaludra.login.domain.LoginUser {
    override fun login(email: String, password: String): Flow<com.singaludra.login.domain.LoginUserResult> {
        return flow {
            loginUser.login(email, password).collect{ result ->
                if(result is com.singaludra.login.domain.LoginUserResult.Success) {
                    saveUserInfo.save(result.user)
                }
                emit(result)
            }
        }
    }
}