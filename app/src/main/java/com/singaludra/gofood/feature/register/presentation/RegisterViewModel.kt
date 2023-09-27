package com.singaludra.gofood.feature.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.main.factories.register.RemoteRegisterUserFactory

sealed interface RegisterUIState{
    data class Error(val errorMessage: String?): RegisterUIState

    object Success: RegisterUIState
    object Loading: RegisterUIState
}

class RegisterViewModel(
    private val registerUser: RegisterUser
): ViewModel() {

    companion object {
        val FACTORY : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                RegisterViewModel(
                    RemoteRegisterUserFactory.createRemoteRegisterUser()
                )
            }
        }
    }


}