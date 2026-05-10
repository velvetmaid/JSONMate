package com.vlma.jsonmate.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vlma.jsonmate.ui.components.HeaderBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,        // Passed as a prop
    onThemeToggle: () -> Unit,   // Callback function
    onBack: () -> Unit           // Navigation callback
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
            // A simple "Row" with a label and a Switch
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Dark Mode", style = MaterialTheme.typography.bodyLarge)

                // Switch is the standard toggle component
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = { onThemeToggle() }
                )
            }
        }
    }
}