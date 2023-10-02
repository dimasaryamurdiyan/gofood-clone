package com.singaludra.gofood.feature.login.http

import com.singaludra.gofood.feature.login.http.request.LoginDataRequest
import com.singaludra.shared.response.RemoteRootUser
import kotlinx.coroutines.flow.Flow

sealed class HttpClientLoginResult {
    data class Success(val root : RemoteRootUser): HttpClientLoginResult()
    data class Failure(val throwable: Throwable): HttpClientLoginResult()
}

interface LoginUserHttpClient {
    fun login(userData : LoginDataRequest): Flow<HttpClientLoginResult>
}