package com.singaludra.gofood.feature.register.http

import com.singaludra.gofood.feature.register.http.request.RegistrationData
import com.singaludra.gofood.feature.register.http.response.RemoteRootRegisterUser
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterUserService {
    @POST("register")
    fun registerUser(@Body registrationData: RegistrationData): RemoteRootRegisterUser
}