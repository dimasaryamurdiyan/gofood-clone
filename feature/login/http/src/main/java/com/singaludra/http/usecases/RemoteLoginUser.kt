package com.singaludra.http.usecases

import com.singaludra.login.domain.LoginUser
import com.singaludra.login.domain.LoginUserResult
import com.singaludra.http.HttpClientLoginResult
import com.singaludra.http.LoginUserHttpClient
import com.singaludra.http.request.LoginDataRequest
import com.singaludra.shared.response.mapToDomain
import com.singaludra.shared.utils.Connectivity
import com.singaludra.shared.utils.ConnectivityException
import com.singaludra.shared.utils.InvalidData
import com.singaludra.shared.utils.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteLoginUser constructor(
    private val loginUserHttpClient: LoginUserHttpClient
): com.singaludra.login.domain.LoginUser {
    override fun login(email: String, password: String): Flow<com.singaludra.login.domain.LoginUserResult> = flow {
        val request = LoginDataRequest(
            email, password
        )
        loginUserHttpClient.login(request).collect{ result ->
            when (result) {
                is HttpClientLoginResult.Success -> {
                    val data = result.root.data
                    emit(com.singaludra.login.domain.LoginUserResult.Success(data.mapToDomain()))
                }
                is HttpClientLoginResult.Failure -> {
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(com.singaludra.login.domain.LoginUserResult.Failure(Connectivity()))
                        }
                        is InvalidDataException -> {
                            emit(com.singaludra.login.domain.LoginUserResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }
}