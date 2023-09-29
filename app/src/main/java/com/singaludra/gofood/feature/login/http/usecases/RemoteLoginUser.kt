package com.singaludra.gofood.feature.login.http.usecases

import com.singaludra.gofood.feature.login.domain.LoginUser
import com.singaludra.gofood.feature.login.domain.LoginUserResult
import com.singaludra.gofood.feature.login.http.HttpClientLoginResult
import com.singaludra.gofood.feature.login.http.LoginUserHttpClient
import com.singaludra.gofood.feature.login.http.request.LoginDataRequest
import com.singaludra.gofood.feature.register.http.ConnectivityException
import com.singaludra.gofood.feature.register.http.InvalidDataException
import com.singaludra.gofood.shared.http.response.mapToDomain
import com.singaludra.gofood.feature.register.http.usecases.Connectivity
import com.singaludra.gofood.feature.register.http.usecases.InvalidData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteLoginUser constructor(
    private val loginUserHttpClient: LoginUserHttpClient
): LoginUser {
    override fun login(email: String, password: String): Flow<LoginUserResult> = flow {
        val request = LoginDataRequest(
            email, password
        )
        loginUserHttpClient.login(request).collect{ result ->
            when (result) {
                is HttpClientLoginResult.Success -> {
                    val data = result.root.data
                    emit(LoginUserResult.Success(data.mapToDomain()))
                }
                is HttpClientLoginResult.Failure -> {
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(LoginUserResult.Failure(Connectivity()))
                        }
                        is InvalidDataException -> {
                            emit(LoginUserResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }
}