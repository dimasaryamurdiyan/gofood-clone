package com.singaludra.gofood.feature.login.http

import com.singaludra.gofood.feature.login.domain.LoginData
import com.singaludra.gofood.feature.register.http.response.RemoteRootRegisterUser
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginUserService {
    @POST("login")
    fun login(@Body loginData: LoginData): RemoteRootRegisterUser
}