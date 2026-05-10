package com.vlma.jsonmate.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vlma.jsonmate.ui.screens.MainScreen
import com.vlma.jsonmate.ui.screens.SettingsScreen
import com.vlma.jsonmate.ui.theme.JSONMateTheme

@Composable
fun MainApp() {
    // 1. GLOBAL STATE (useState)
    val navController = rememberNavController()
    var isDarkTheme by remember { mutableStateOf(false) }

    // 2. THEME PROVIDER
    JSONMateTheme(darkTheme = isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // 3. ROUTER
            AppNavHost(
                navController = navController,
                mainScreenContent = {
                    MainScreen(
                        onNavigateToSettings = { navController.navigate(Routes.SETTINGS) }
                    )
                },
                settingsScreenContent = {
                    SettingsScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = { isDarkTheme = !isDarkTheme },
                        onBack = { navController.popBackStack() }
                    )
                }
            )
        }
    }
}