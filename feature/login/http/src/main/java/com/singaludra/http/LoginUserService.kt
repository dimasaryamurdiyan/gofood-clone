package com.singaludra.http

import com.singaludra.http.request.LoginDataRequest
import com.singaludra.shared.response.RemoteRootUser
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginUserService {
    @POST("login")
    suspend fun login(@Body loginData: LoginDataRequest): RemoteRootUser
}