package com.vlma.jsonmate.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.vlma.jsonmate.ui.components.HeaderBar
import com.vlma.jsonmate.ui.screens.home.MainMenu

@Composable
fun MainScreen(onNavigateToSettings: () -> Unit) {
    // Scaffold is the standard "Page Layout" in Android
    Scaffold(
        topBar = {
            HeaderBar(
                title = "JSONMate",
                onSettingsClick = onNavigateToSettings,
                onBackClick = null
            )
        }
    ) { innerPadding ->
        MainMenu(innerPadding = innerPadding)
    }
}