package com.singaludra.gofood.main.factories.register

import com.singaludra.gofood.feature.register.http.RegisterUserHttpClient
import com.singaludra.gofood.feature.register.http.RegisterUserRetrofitHttpClient

class RegisterUserHttpClientFactory {
    companion object {
        fun createRegisterUserHttpClientFactory(): RegisterUserHttpClient {
            return RegisterUserRetrofitHttpClient (
                RegisterUserServiceFactory.createRegisterUserService()
            )
        }
    }
}