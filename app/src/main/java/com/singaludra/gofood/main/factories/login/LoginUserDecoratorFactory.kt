package com.singaludra.gofood.main.factories.login

import com.singaludra.gofood.feature.login.domain.LoginUser
import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import com.singaludra.gofood.main.decorators.LoginUserDecorator

class LoginUserDecoratorFactory {
    companion object {
        fun createLoginUserDecorator (
            decorator: LoginUser,
            saveUserInfo: SaveUserInfo
        ): LoginUser {
            return LoginUserDecorator(
                decorator, saveUserInfo
            )
        }
    }
}