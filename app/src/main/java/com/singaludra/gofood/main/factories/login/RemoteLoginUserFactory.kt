package com.singaludra.gofood.main.factories.login

import com.singaludra.login.domain.LoginUser
import com.singaludra.http.usecases.RemoteLoginUser

class RemoteLoginUserFactory {
    companion object {
        fun createRemoteLoginUser(): com.singaludra.login.domain.LoginUser {
            return com.singaludra.http.usecases.RemoteLoginUser(
                LoginUserHttpClientFactory.createLoginUserHttpClientFactory()
            )
        }
    }
}