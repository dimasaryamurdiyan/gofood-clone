package com.singaludra.gofood.main.factories.login

import com.singaludra.gofood.feature.login.http.LoginUserService
import com.singaludra.shared.frameworks.HttpFactory

class LoginUserServiceFactory {
    companion object {
        fun createLoginUserService(): LoginUserService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(LoginUserService::class.java)
        }
    }
}