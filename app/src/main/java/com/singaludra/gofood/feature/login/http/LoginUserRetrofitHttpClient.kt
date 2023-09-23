package com.singaludra.gofood.feature.login.http

import com.singaludra.gofood.feature.login.domain.LoginData
import com.singaludra.gofood.feature.register.http.ConnectivityException
import com.singaludra.gofood.feature.register.http.InvalidDataException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class LoginUserRetrofitHttpClient constructor(
    private val loginUserService: LoginUserService
): LoginUserHttpClient {
    override fun login(userData: LoginData): Flow<HttpClientLoginResult> = flow {
        try {
            emit(HttpClientLoginResult.Success(loginUserService.login(userData)))
        } catch (throwable: Throwable) {
            when(throwable) {
                is IOException -> {
                    emit(HttpClientLoginResult.Failure(ConnectivityException()))
                }
                is HttpException -> {
                    if (throwable.code() == 422) {
                        emit(HttpClientLoginResult.Failure(InvalidDataException()))
                    }
                }
                else -> {
                    emit(HttpClientLoginResult.Failure(InvalidDataException()))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}