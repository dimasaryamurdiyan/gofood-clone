package com.singaludra.gofood.main.factories.login

import com.singaludra.login.domain.LoginUser
import com.singaludra.shared.user.domain.SaveUserInfo
import com.singaludra.gofood.main.decorators.LoginUserDecorator

class LoginUserDecoratorFactory {
    companion object {
        fun createLoginUserDecorator (
            decorator: com.singaludra.login.domain.LoginUser,
            saveUserInfo: SaveUserInfo
        ): com.singaludra.login.domain.LoginUser {
            return LoginUserDecorator(
                decorator, saveUserInfo
            )
        }
    }
}