package com.singaludra.gofood.feature.login.http

import com.singaludra.gofood.feature.login.http.request.LoginDataRequest
import com.singaludra.gofood.shared.http.response.RemoteRootRegisterUser
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginUserService {
    @POST("login")
    suspend fun login(@Body loginData: LoginDataRequest): RemoteRootRegisterUser
}