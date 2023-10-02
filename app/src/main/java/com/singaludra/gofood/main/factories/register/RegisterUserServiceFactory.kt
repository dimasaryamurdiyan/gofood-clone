package com.singaludra.gofood.main.factories.register

import com.singaludra.http.RegisterUserService
import com.singaludra.shared.frameworks.HttpFactory

class RegisterUserServiceFactory {
    companion object {
        fun createRegisterUserService(): com.singaludra.http.RegisterUserService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(com.singaludra.http.RegisterUserService::class.java)
        }
    }
}