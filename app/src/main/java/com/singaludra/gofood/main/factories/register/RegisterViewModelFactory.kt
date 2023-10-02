package com.singaludra.gofood.main.factories.register

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.presentation.RegisterViewModel
import com.singaludra.gofood.main.factories.user.PreferenceFactory

class RegisterViewModelFactory {
    companion object {
        fun provideRegisterViewModel(context: Context) : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                com.singaludra.presentation.RegisterViewModel(
                    RegisterUserDecoratorFactory.createRegisterUserDecorator(
                        decorator = RemoteRegisterUserFactory.createRemoteRegisterUser(),
                        saveUserInfo = PreferenceFactory.createLocalSaveUserInfo(context)
                    )
                )
            }
        }
    }
}