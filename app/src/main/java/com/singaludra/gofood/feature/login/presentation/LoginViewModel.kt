package com.singaludra.gofood.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.gofood.feature.login.domain.LoginData
import com.singaludra.gofood.feature.login.domain.LoginUser
import com.singaludra.gofood.feature.login.domain.LoginUserResult
import com.singaludra.gofood.feature.register.http.usecases.Connectivity
import com.singaludra.gofood.feature.register.http.usecases.InvalidData
import com.singaludra.gofood.main.factories.login.RemoteLoginUserFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface LoginUIState{
    data class Error(val errorMessage: String?): LoginUIState

    object Success: LoginUIState
    object Loading: LoginUIState
}

class LoginViewModel(
    private val loginUser: LoginUser
): ViewModel() {
    private val _loginUIState = MutableStateFlow<LoginUIState>(LoginUIState.Loading)
    val loginUIState = _loginUIState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val loginData = LoginData(
                email, password
            )
            loginUser.login(loginData).collect{ result ->
                when (result) {
                    is LoginUserResult.Success -> {
                        _loginUIState.value = LoginUIState.Success
                    }
                    is LoginUserResult.Failure -> {
                        val message = when(result.throwable) {
                            is Connectivity -> "Connectivity"
                            is InvalidData -> "Invalid Data"
                            else -> "Something Went Wrong"
                        }

                        _loginUIState.value = LoginUIState.Error(message)
                    }
                }
            }
        }
    }

    companion object {
        val FACTORY : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel(
                    RemoteLoginUserFactory.createRemoteLoginUser()
                )
            }
        }
    }
}