package com.singaludra.http

import com.singaludra.http.request.UserDataRequest
import com.singaludra.shared.utils.ConnectivityException
import com.singaludra.shared.utils.InvalidDataException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class RegisterUserRetrofitHttpClient constructor(
    private val registerUserService: RegisterUserService
): RegisterUserHttpClient {
    override fun register(userData: UserDataRequest): Flow<HttpClientRegisterResult> =  flow {
        try {
            emit(HttpClientRegisterResult.Success(registerUserService.registerUser(userData)))
        } catch (throwable: Throwable) {
            when(throwable) {
                is IOException -> {
                    emit(HttpClientRegisterResult.Failure(ConnectivityException()))
                }
                is HttpException -> {
                    if (throwable.code() == 422) {
                        emit(HttpClientRegisterResult.Failure(InvalidDataException()))
                    }
                }
                else -> {
                    emit(HttpClientRegisterResult.Failure(InvalidDataException()))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}