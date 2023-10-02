package com.singaludra.gofood.main.factories.login

import com.singaludra.http.LoginUserHttpClient
import com.singaludra.http.LoginUserRetrofitHttpClient

class LoginUserHttpClientFactory {
    companion object {
        fun createLoginUserHttpClientFactory(): com.singaludra.http.LoginUserHttpClient {
            return com.singaludra.http.LoginUserRetrofitHttpClient(
                LoginUserServiceFactory.createLoginUserService()
            )
        }
    }
}