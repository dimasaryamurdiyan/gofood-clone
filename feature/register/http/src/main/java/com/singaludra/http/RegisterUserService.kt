package com.singaludra.http

import com.singaludra.http.request.UserDataRequest
import com.singaludra.shared.response.RemoteRootUser
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterUserService {
    @POST("register")
    suspend fun registerUser(@Body registrationData: UserDataRequest): RemoteRootUser
}