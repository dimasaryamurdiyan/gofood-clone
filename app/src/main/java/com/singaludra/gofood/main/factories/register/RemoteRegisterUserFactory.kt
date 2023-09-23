package com.singaludra.gofood.main.factories.register

import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.feature.register.http.usecases.RemoteRegisterUser

class RemoteRegisterUserFactory {
    companion object {
        fun createRemoteRegisterUser(): RegisterUser {
            return RemoteRegisterUser (
                RegisterUserHttpClientFactory.createRegisterUserHttpClientFactory()
            )
        }
    }
}