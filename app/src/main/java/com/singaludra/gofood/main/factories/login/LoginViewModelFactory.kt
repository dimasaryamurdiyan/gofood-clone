package com.singaludra.gofood.main.factories.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.gofood.feature.login.presentation.LoginViewModel
import com.singaludra.gofood.main.factories.user.PreferenceFactory

class LoginViewModelFactory {
    companion object{
        fun provideLoginViewModel(context: Context) : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel(
                    LoginUserDecoratorFactory.createLoginUserDecorator(
                        decorator = RemoteLoginUserFactory.createRemoteLoginUser(),
                        saveUserInfo = PreferenceFactory.createLocalSaveUserInfo(context)
                    )
                )
            }
        }
    }
}