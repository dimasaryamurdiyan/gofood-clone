package com.singaludra.gofood.main.factories.register

import com.singaludra.http.usecases.RemoteRegisterUser

class RemoteRegisterUserFactory {
    companion object {
        fun createRemoteRegisterUser(): com.singaludra.register.domain.RegisterUser {
            return com.singaludra.http.usecases.RemoteRegisterUser(
                RegisterUserHttpClientFactory.createRegisterUserHttpClientFactory()
            )
        }
    }
}