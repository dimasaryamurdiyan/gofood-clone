package com.singaludra.gofood.feature.login.http

import com.singaludra.gofood.feature.login.domain.LoginData
import com.singaludra.gofood.feature.register.http.HttpClientRegisterResult
import com.singaludra.gofood.feature.register.http.response.RemoteRootRegisterUser
import kotlinx.coroutines.flow.Flow

sealed class HttpClientLoginResult {
    data class Success(val root : RemoteRootRegisterUser): HttpClientLoginResult()
    data class Failure(val throwable: Throwable): HttpClientLoginResult()
}

interface LoginUserHttpClient {
    fun login(userData : LoginData): Flow<HttpClientLoginResult>
}