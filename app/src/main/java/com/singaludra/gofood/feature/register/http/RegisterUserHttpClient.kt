package com.singaludra.gofood.feature.register.http

import com.singaludra.gofood.feature.register.http.request.UserDataRequest
import com.singaludra.shared.response.RemoteRootUser
import kotlinx.coroutines.flow.Flow


sealed class HttpClientRegisterResult {
    data class Success(val root : com.singaludra.shared.response.RemoteRootUser): HttpClientRegisterResult()
    data class Failure(val throwable: Throwable): HttpClientRegisterResult()
}

interface RegisterUserHttpClient {
    fun register(userData : UserDataRequest): Flow<HttpClientRegisterResult>
}