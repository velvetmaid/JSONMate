package com.vlma.jsonmate.ui.screens.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.SettingsSuggest
import androidx.compose.ui.graphics.vector.ImageVector

enum class ThemeMode(
    val label: String,
    val icon: ImageVector
) {
    SYSTEM("System", Icons.Default.SettingsSuggest),
    LIGHT("Light", Icons.Default.LightMode),
    DARK("Dark", Icons.Default.DarkMode)
}