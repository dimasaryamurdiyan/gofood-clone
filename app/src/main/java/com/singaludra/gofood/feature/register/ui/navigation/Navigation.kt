package com.singaludra.gofood.feature.register.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.singaludra.gofood.feature.login.presentation.LoginViewModel
import com.singaludra.gofood.feature.login.ui.LoginScreen
import com.singaludra.gofood.feature.login.ui.navigation.REGISTER
import com.singaludra.gofood.feature.login.ui.navigation.REGISTER_ADDRESS
import com.singaludra.gofood.feature.login.ui.navigation.REGISTER_GRAPH_ROUTE
import com.singaludra.gofood.feature.register.ui.AddressScreen
import com.singaludra.gofood.feature.register.ui.RegisterScreen


fun NavGraphBuilder.registerGraph(
    onArrowClick: () -> Unit,
    onButtonClick: (String) -> Unit,
) {
    navigation(
        route = REGISTER_GRAPH_ROUTE,
        startDestination = REGISTER,
    ) {
        composable(REGISTER) {
            RegisterScreen(
                onArrowClick = onArrowClick,
                onButtonClick = { onButtonClick(REGISTER_ADDRESS) }
            )
        }

        composable(REGISTER_ADDRESS) {
            AddressScreen(
                onArrowClick = onArrowClick,
                dropDownList = listOf(),
            )
        }
    }
}
