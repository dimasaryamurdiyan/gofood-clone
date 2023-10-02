package com.singaludra.http.usecases

import android.util.Log
import com.singaludra.http.HttpClientRegisterResult
import com.singaludra.http.RegisterUserHttpClient
import com.singaludra.http.request.UserDataRequest
import com.singaludra.shared.response.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteRegisterUser constructor(
    private val registerUserHttpClient: RegisterUserHttpClient
): com.singaludra.register.domain.RegisterUser {
    override fun register(user: com.singaludra.register.domain.request.UserData): Flow<com.singaludra.register.domain.RegisterUserResult> = flow {
        val userDataRequest = UserDataRequest.fromDomain(user)
        registerUserHttpClient.register(userData = userDataRequest). collect { result ->
            when (result) {
                is HttpClientRegisterResult.Success -> {
                    val data = result.root.data
                    emit(com.singaludra.register.domain.RegisterUserResult.Success(data.mapToDomain()))
                }

                is HttpClientRegisterResult.Failure -> {
                    Log.d("register", "Failure")
                    when (result.throwable) {
                        is com.singaludra.shared.utils.ConnectivityException -> {
                            emit(com.singaludra.register.domain.RegisterUserResult.Failure(com.singaludra.shared.utils.Connectivity()))
                        }

                        is com.singaludra.shared.utils.InvalidDataException -> {
                            Log.d("register", "InvalidData")
                            emit(com.singaludra.register.domain.RegisterUserResult.Failure(com.singaludra.shared.utils.InvalidData()))
                        }
                    }
                }
            }
        }
    }
}
