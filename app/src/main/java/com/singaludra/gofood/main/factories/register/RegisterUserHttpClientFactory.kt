package com.singaludra.gofood.main.factories.register

import com.singaludra.http.RegisterUserHttpClient
import com.singaludra.http.RegisterUserRetrofitHttpClient

class RegisterUserHttpClientFactory {
    companion object {
        fun createRegisterUserHttpClientFactory(): com.singaludra.http.RegisterUserHttpClient {
            return com.singaludra.http.RegisterUserRetrofitHttpClient(
                RegisterUserServiceFactory.createRegisterUserService()
            )
        }
    }
}