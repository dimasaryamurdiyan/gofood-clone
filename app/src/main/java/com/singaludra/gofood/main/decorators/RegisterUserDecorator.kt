package com.singaludra.gofood.main.decorators

import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.feature.register.domain.RegisterUserResult
import com.singaludra.gofood.feature.register.domain.request.UserData
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class RegisterUserDecorator constructor(
    private val registerUser: RegisterUser,
    private val saveUserInfo: SaveUserInfo
) : RegisterUser {
    override fun register(user: UserData): Flow<RegisterUserResult> {
        return flow {
            registerUser.register(user).collect{ result ->
                if(result is RegisterUserResult.Success) {
                    saveUserInfo.save(result.user)
                }
                emit(result)
            }
        }
    }
}