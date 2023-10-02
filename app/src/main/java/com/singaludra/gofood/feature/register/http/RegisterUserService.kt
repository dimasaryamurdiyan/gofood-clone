package com.singaludra.gofood.feature.register.http

import com.singaludra.gofood.feature.register.http.request.UserDataRequest
import com.singaludra.shared.response.RemoteRootUser
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterUserService {
    @POST("register")
    suspend fun registerUser(@Body registrationData: UserDataRequest): com.singaludra.shared.response.RemoteRootUser
}