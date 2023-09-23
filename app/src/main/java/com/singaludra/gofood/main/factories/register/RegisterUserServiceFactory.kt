package com.singaludra.gofood.main.factories.register

import com.singaludra.gofood.feature.register.http.RegisterUserService
import com.singaludra.gofood.frameworks.HttpFactory

class RegisterUserServiceFactory {
    companion object {
        fun createRegisterUserService(): RegisterUserService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(RegisterUserService::class.java)
        }
    }
}