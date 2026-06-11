package com.vlma.jsonmate.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object Routes {
    const val MAIN = "main"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    mainScreenContent: @Composable () -> Unit,
    settingsScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Routes.MAIN,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }

    ) {
        composable(Routes.MAIN) {
            mainScreenContent()
        }
        composable(Routes.SETTINGS) {
            settingsScreenContent()
        }
    }
}
