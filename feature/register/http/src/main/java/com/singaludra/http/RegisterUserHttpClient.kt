package com.singaludra.http

import com.singaludra.http.request.UserDataRequest
import com.singaludra.shared.response.RemoteRootUser
import kotlinx.coroutines.flow.Flow


sealed class HttpClientRegisterResult {
    data class Success(val root : RemoteRootUser): HttpClientRegisterResult()
    data class Failure(val throwable: Throwable): HttpClientRegisterResult()
}

interface RegisterUserHttpClient {
    fun register(userData : UserDataRequest): Flow<HttpClientRegisterResult>
}