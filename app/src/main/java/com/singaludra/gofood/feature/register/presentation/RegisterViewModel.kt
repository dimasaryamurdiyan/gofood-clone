package com.singaludra.gofood.feature.register.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.gofood.feature.register.domain.RegisterUser
import com.singaludra.gofood.feature.register.domain.RegisterUserResult
import com.singaludra.gofood.feature.register.domain.request.UserData
import com.singaludra.gofood.feature.register.http.usecases.Connectivity
import com.singaludra.gofood.feature.register.http.usecases.InvalidData
import com.singaludra.gofood.main.factories.register.RemoteRegisterUserFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class RegistrationFormState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val address: String = "",
    val city: String = "",
    val houseNumber: String = "",
    val phoneNumber: String = ""
) {
    fun mapToDomain(): UserData = UserData (
        name, email, password, passwordConfirmation, address, city, houseNumber, phoneNumber
    )
}
data class RegisterUIState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean? = null,
    val errorMessage: String = "",
    val registrationFormState: RegistrationFormState =  RegistrationFormState()
)


class RegisterViewModel(
    private val registerUser: RegisterUser
): ViewModel() {
    private val _registerUIState = MutableStateFlow<RegisterUIState>(RegisterUIState())
    val registerUIState = _registerUIState.asStateFlow()

    fun updateRegistrationFormData(registrationFormState: RegistrationFormState) {
        _registerUIState.value = _registerUIState.value.copy(
            registrationFormState = registrationFormState
        )
    }
    fun register(registrationFormState: RegistrationFormState) {
        viewModelScope.launch {
            _registerUIState.value = _registerUIState.value.copy(isLoading = true)
            registerUser.register(registrationFormState.mapToDomain()).collect{ result ->
                Log.d("registerViewModel", result.toString())
                when (result) {
                    is RegisterUserResult.Success -> {
                        _registerUIState.value = _registerUIState.value.copy(
                            isLoading = false,
                            isSuccess = true
                        )
                    }
                    is RegisterUserResult.Failure -> {
                        val message = when(result.throwable) {
                            is Connectivity -> "Connectivity"
                            is InvalidData -> "Invalid Data"
                            else -> "Something Went Wrong"
                        }

                        _registerUIState.value = _registerUIState.value.copy(
                            isLoading = false,
                            isSuccess = false,
                            errorMessage = message
                        )
                    }
                }
            }
        }
    }
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