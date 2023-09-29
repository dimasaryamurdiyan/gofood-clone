package com.singaludra.gofood.main.factories.register

import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import com.singaludra.gofood.main.decorators.RegisterUserDecorator

class RegisterUserDecoratorFactory {
    companion object {
        fun createRegisterUserDecorator(
            decorator: RegisterUser,
            saveUserInfo: SaveUserInfo
        ): RegisterUser {
            return  RegisterUserDecorator(
                decorator, saveUserInfo
            )
        }
    }
}