package com.singaludra.gofood.main.factories.login

import com.singaludra.gofood.feature.login.http.LoginUserHttpClient
import com.singaludra.gofood.feature.login.http.LoginUserRetrofitHttpClient

class LoginUserHttpClientFactory {
    companion object {
        fun createLoginUserHttpClientFactory(): LoginUserHttpClient {
            return LoginUserRetrofitHttpClient (
                LoginUserServiceFactory.createLoginUserService()
            )
        }
    }
}