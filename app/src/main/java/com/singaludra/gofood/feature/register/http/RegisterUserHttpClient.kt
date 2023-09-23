package com.singaludra.gofood.feature.register.http

import com.singaludra.gofood.feature.register.http.request.RegistrationData
import com.singaludra.gofood.feature.register.http.response.RemoteRootRegisterUser
import kotlinx.coroutines.flow.Flow


sealed class HttpClientRegisterResult {
    data class Success(val root : RemoteRootRegisterUser): HttpClientRegisterResult()
    data class Failure(val throwable: Throwable): HttpClientRegisterResult()
}

class InvalidDataException : Throwable()
class ConnectivityException : Throwable()

interface RegisterUserHttpClient {
    fun register(userData : RegistrationData): Flow<HttpClientRegisterResult>
}