package com.singaludra.gofood.main.factories.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.singaludra.gofood.feature.login.ui.navigation.LOGIN_GRAPH_ROUTE
import com.singaludra.gofood.feature.login.ui.navigation.loginGraph
import com.singaludra.gofood.feature.register.ui.navigation.REGISTER_ADDRESS
import com.singaludra.gofood.feature.register.ui.navigation.REGISTER_GRAPH_ROUTE
import com.singaludra.gofood.feature.register.ui.navigation.registerGraph

@Composable
fun MainAppNavHost(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = LOGIN_GRAPH_ROUTE,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination,
    ) {
        loginGraph(
            context = context,
            onBtnRegisterClick = { navHostController.navigate(REGISTER_GRAPH_ROUTE) }
        )
        registerGraph(
            context = context,
            onArrowClick = { navHostController.popBackStack() },
            onButtonClick = {
                navHostController.navigate(REGISTER_ADDRESS)
            },
            navHostController = navHostController
        )
    }
}