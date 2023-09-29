package com.singaludra.gofood.feature.register.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.singaludra.gofood.feature.register.presentation.RegisterViewModel
import com.singaludra.gofood.feature.register.ui.AddressScreen
import com.singaludra.gofood.feature.register.ui.RegisterScreen

const val REGISTER_GRAPH_ROUTE = "register-graph"
const val REGISTER = "register"
const val REGISTER_ADDRESS = "register/address"

fun NavGraphBuilder.registerGraph(
    navHostController: NavHostController,
    onArrowClick: () -> Unit,
    onButtonClick: () -> Unit,
) {
    navigation(
        route = REGISTER_GRAPH_ROUTE,
        startDestination = REGISTER,
    ) {
        composable(REGISTER) {
            RegisterScreenRoot(
                viewModel = viewModel(factory = RegisterViewModel.FACTORY),
                onArrowClick = onArrowClick,
                onButtonClick = onButtonClick
            )
        }

        composable(REGISTER_ADDRESS) {
            val registerViewModel = rememberParentViewModelStoreOwner(
                navController = navHostController,
                parentRoute = REGISTER
            )

            AddressScreenRoot(
                viewModel = viewModel(registerViewModel),
                onArrowClick = onArrowClick,
            )
        }
    }
}

@Composable
fun rememberParentViewModelStoreOwner(
    navController: NavHostController,
    parentRoute: String,
): ViewModelStoreOwner {
    return remember(navController.currentBackStackEntry) {
        object : ViewModelStoreOwner {
            override val viewModelStore =
                navController.getBackStackEntry(parentRoute).viewModelStore
        }
    }
}

@Composable
fun RegisterScreenRoot(
    viewModel: RegisterViewModel,
    onArrowClick: () -> Unit,
    onButtonClick: () -> Unit,
) {
    val registerState by viewModel.registerUIState.collectAsStateWithLifecycle()

    RegisterScreen(
        onArrowClick = onArrowClick,
        onButtonClick = { registerDataState ->
            viewModel.updateRegistrationFormData(registerDataState)
            onButtonClick()
        },
        registerUIState = registerState,
    )
}

@Composable
fun AddressScreenRoot(
    viewModel: RegisterViewModel,
    onArrowClick: () -> Unit,
) {
    val registerUiState by viewModel.registerUIState.collectAsStateWithLifecycle()

    AddressScreen(
        registerUIState = registerUiState,
        onArrowClick = onArrowClick,
        onRegisterClick = { viewModel.register(it) },
    )
}
