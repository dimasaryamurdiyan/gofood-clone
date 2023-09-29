package com.singaludra.gofood.feature.register.http.usecases

import android.util.Log
import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.feature.register.domain.RegisterUserResult
import com.singaludra.gofood.feature.register.domain.User
import com.singaludra.gofood.feature.register.http.ConnectivityException
import com.singaludra.gofood.feature.register.http.HttpClientRegisterResult
import com.singaludra.gofood.feature.register.http.InvalidDataException
import com.singaludra.gofood.feature.register.http.RegisterUserHttpClient
import com.singaludra.gofood.feature.register.http.request.RegistrationData
import com.singaludra.gofood.feature.register.http.response.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class RemoteRegisterUser constructor(
    private val registerUserHttpClient: RegisterUserHttpClient
): RegisterUser {
    override fun register(user: RegistrationData): Flow<RegisterUserResult> = flow {
        registerUserHttpClient.register(userData = user). collect { result ->
            when (result) {
                is HttpClientRegisterResult.Success -> {
                    val data = result.root.data
                    emit(RegisterUserResult.Success(data.mapToDomain()))
                }

                is HttpClientRegisterResult.Failure -> {
                    Log.d("register", "Failure")
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(RegisterUserResult.Failure(Connectivity()))
                        }

                        is InvalidDataException -> {
                            Log.d("register", "InvalidData")
                            emit(RegisterUserResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }
}

class InvalidData : Throwable()
class Connectivity : Throwable()