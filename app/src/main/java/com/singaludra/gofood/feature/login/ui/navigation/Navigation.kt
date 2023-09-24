package com.singaludra.gofood.feature.login.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.singaludra.gofood.feature.login.ui.AddressScreen
import com.singaludra.gofood.feature.login.ui.RegisterScreen

const val REGISTER_GRAPH_ROUTE = "register-graph"
const val REGISTER = "register"
const val REGISTER_ADDRESS = "register/address"

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