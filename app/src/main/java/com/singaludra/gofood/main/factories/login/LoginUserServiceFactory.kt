package com.singaludra.gofood.main.factories.login

import com.singaludra.http.LoginUserService
import com.singaludra.shared.frameworks.HttpFactory

class LoginUserServiceFactory {
    companion object {
        fun createLoginUserService(): com.singaludra.http.LoginUserService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(com.singaludra.http.LoginUserService::class.java)
        }
    }
}