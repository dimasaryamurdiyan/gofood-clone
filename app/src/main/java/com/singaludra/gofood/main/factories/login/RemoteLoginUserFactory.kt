package com.singaludra.gofood.main.factories.login

import com.singaludra.gofood.feature.login.domain.LoginUser
import com.singaludra.gofood.feature.login.http.usecases.RemoteLoginUser

class RemoteLoginUserFactory {
    companion object {
        fun createRemoteLoginUser(): LoginUser {
            return RemoteLoginUser (
                LoginUserHttpClientFactory.createLoginUserHttpClientFactory()
            )
        }
    }
}