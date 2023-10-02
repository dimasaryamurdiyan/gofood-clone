package com.singaludra.gofood.main.factories.register

import com.singaludra.register.domain.RegisterUser
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import com.singaludra.gofood.main.decorators.RegisterUserDecorator

class RegisterUserDecoratorFactory {
    companion object {
        fun createRegisterUserDecorator(
            decorator: com.singaludra.register.domain.RegisterUser,
            saveUserInfo: SaveUserInfo
        ): com.singaludra.register.domain.RegisterUser {
            return  RegisterUserDecorator(
                decorator, saveUserInfo
            )
        }
    }
}