package com.singaludra.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singaludra.login.domain.LoginUser
import com.singaludra.login.domain.LoginUserResult
import com.singaludra.shared.utils.Connectivity
import com.singaludra.shared.utils.InvalidData
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
            loginUser.login(email, password).collect{ result ->
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

}