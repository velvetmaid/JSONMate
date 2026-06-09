package com.vlma.jsonmate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vlma.jsonmate.ui.components.HeaderBar
import com.vlma.jsonmate.ui.screens.settings.ThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    themeMode: ThemeMode,               // Current theme
    onThemeChange: (ThemeMode) -> Unit, // Theme change callback
    onBack: () -> Unit                  // Navigation callback
) {
    Scaffold(
        topBar = {
            HeaderBar(
                title = "Settings",
                onBackClick = onBack,       // Shows the ArrowBack
                onSettingsClick = null      // Hides the Settings gear
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Appearance
            Text(
                "Appearance", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                ThemeMode.entries.forEach { mode ->
                    FilterChip(
                        selected = themeMode == mode,
                        onClick = { onThemeChange(mode) },
                        label = { Text(mode.label) },
                        leadingIcon = {
                            Icon(
                                mode.icon,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    }
}