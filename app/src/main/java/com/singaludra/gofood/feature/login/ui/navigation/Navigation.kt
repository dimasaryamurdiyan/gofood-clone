package com.singaludra.gofood.feature.login.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.singaludra.login.presentation.LoginViewModel
import com.singaludra.gofood.feature.login.ui.LoginScreen
import com.singaludra.gofood.main.factories.login.LoginViewModelFactory

const val LOGIN_GRAPH_ROUTE = "login-graph"
const val LOGIN = "login"

fun NavGraphBuilder.loginGraph(
    context: Context,
    onBtnRegisterClick: () -> Unit,
) {
    navigation(
        route = LOGIN_GRAPH_ROUTE,
        startDestination = LOGIN,
    ) {
        composable(LOGIN) {
            LoginUserRoute(viewModel = viewModel(factory = LoginViewModelFactory.provideLoginViewModel(context)), onBtnRegisterClick = onBtnRegisterClick)
        }
    }
}

@Composable
fun LoginUserRoute (
    viewModel: LoginViewModel,
    onBtnRegisterClick: () -> Unit,
) {
    val loginUIState by viewModel.loginUIState.collectAsStateWithLifecycle()

    LoginScreen(
        loginUIState = loginUIState,
        onBtnRegisterClick = onBtnRegisterClick
    ) { email, password ->
        viewModel.login(email, password)
    }
}